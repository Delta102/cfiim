package com.dev.campusfrontute;

<<<<<<< HEAD

import android.content.Intent;
=======
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.dev.campusfrontute.models.MdlUser;
import com.dev.campusfrontute.models.MdlUser;
import com.dev.campusfrontute.models.helpers.MdlUserWithRole;
import com.dev.campusfrontute.repositories.UserRepository;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private UserRepository usersRepository;
    private static final String TAG = "MainActivity";
    private int id;
=======
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
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        usersRepository = new UserRepository(this);

        getLoggedUser(usersRepository);
        logoutAction();
    }

    private void getLoggedUser(UserRepository usersRepository){
        usersRepository.getLoggedUser().observe(this, new Observer<MdlUserWithRole>() {
            @Override
            public void onChanged(MdlUserWithRole mdlUserR) {
                if (mdlUserR != null && mdlUserR.getUser() != null)
                    mainUI(mdlUserR);

                else
                    Toast.makeText(MainActivity.this, "Error al obtener al usuario logueado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mainUI(MdlUserWithRole mdlUser){
        TextView txtName = findViewById(R.id.txt_user);
        txtName.setText("Bienvenido(a)! " + mdlUser.getUser().getFirstname() + ", " + mdlUser.getUser().getLastname());
    }

    private void logoutAction(){
        //Logout btn
        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersRepository.logout();
                navigateToLogin();
            }
        });
    }
    private void navigateToLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
=======

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
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
