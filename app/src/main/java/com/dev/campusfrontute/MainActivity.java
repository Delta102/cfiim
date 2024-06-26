package com.dev.campusfrontute;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.campusfrontute.models.helpers.UserResponse;
import com.dev.campusfrontute.network.RetrofitClient;
import com.dev.campusfrontute.services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private static final String SHARED_PREFS = "shared_prefs";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the Token JWT
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);

        if(token != null)
            getUserProfile(token);
        else
            Toast.makeText(this, "Token no encontrado", Toast.LENGTH_SHORT).show();

        // Logout
        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void getUserProfile(String token){
        apiService = RetrofitClient.getClient().create(ApiService.class);

        String authHeader = "Bearer " + token;

        apiService.getUserProfile(authHeader).enqueue(
                new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        UserResponse userProfile = response.body();

                        if(userProfile != null)
                            Toast.makeText(MainActivity.this, "Usuario: " + userProfile.getUsername(), Toast.LENGTH_SHORT).show();
                        else{
                            Toast.makeText(MainActivity.this, "Error al obtener el perfil de usuario", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Log.e(TAG, "Error al obtener el perfil del usuario: " + t.getMessage());
                        Toast.makeText(MainActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    private void logout() {
        // Clear the token from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("token");
        editor.apply();

        // Redirect to the login screen
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
