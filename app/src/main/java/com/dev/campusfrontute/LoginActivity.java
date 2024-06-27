package com.dev.campusfrontute;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.campusfrontute.models.helpers.LoginRequest;
import com.dev.campusfrontute.models.MdlUser;
import com.dev.campusfrontute.services.UserAuthService;
import com.dev.campusfrontute.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private UserAuthService userAuthService;
    private static final String SHARED_PREFS = "shared_prefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText userNameTxt = findViewById(R.id.username);
        EditText passwordTxt = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.login_button);
        // Event for Button
        loginBtn.setOnClickListener(new View.OnClickListener() {

            //Recover Data From UI
            @Override
            public void onClick(View v) {
                String userName = userNameTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                loginUser(userName, password);
            }
        });
    }

    private void loginUser(String userName, String password) {
        // Retrofit Init
        userAuthService = RetrofitClient.getClient().create(UserAuthService.class);

        // Call to Api
        LoginRequest request = new LoginRequest(userName, password);
        userAuthService.loginUser(request).enqueue(new Callback<MdlUser>() {
            @Override
            public void onResponse(Call<MdlUser> call, Response<MdlUser> response) {
                if (response.isSuccessful()) {
                    MdlUser loginResponse = response.body();
                    if (loginResponse != null) {
                        loginResponse.setToken(response.body().getToken());

                        // Save The Token
                        saveToken(loginResponse.getToken());

                        Toast.makeText(LoginActivity.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();

                        // Navigate to the main activity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                } else {
                    // Fail Response
                    Toast.makeText(LoginActivity.this, "Su usuario o su contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MdlUser> call, Throwable t) {
                // Manejo de errores de conexión u otros errores
                Log.e("LoginActivity", "Error logging in: " + t.getMessage());
                Toast.makeText(LoginActivity.this, "Error logging in", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveToken(String token) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.apply();
    }
}