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
<<<<<<< HEAD
import com.dev.campusfrontute.models.MdlUser;
=======
import com.dev.campusfrontute.models.helpers.UserResponse;
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
import com.dev.campusfrontute.services.ApiService;
import com.dev.campusfrontute.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private ApiService apiService;
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
<<<<<<< HEAD

=======
                Log.i("Login", userName);
                Log.i("Login", password);
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
                loginUser(userName, password);
            }
        });
    }

    private void loginUser(String userName, String password) {
        // Retrofit Init
        apiService = RetrofitClient.getClient().create(ApiService.class);
<<<<<<< HEAD

        // Call to Api
        LoginRequest request = new LoginRequest(userName, password);
        apiService.loginUser(request).enqueue(new Callback<MdlUser>() {
            @Override
            public void onResponse(Call<MdlUser> call, Response<MdlUser> response) {
                if (response.isSuccessful()) {
                    MdlUser loginResponse = response.body();
=======
        Log.i("Login", "Presionando el botón");

        // Call to Api
        LoginRequest request = new LoginRequest(userName, password);
        apiService.loginUser(request).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    // Éxito en el login
                    UserResponse loginResponse = response.body();
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
                    if (loginResponse != null) {
                        loginResponse.setToken(response.body().getToken());

                        // Save The Token
                        saveToken(loginResponse.getToken());

<<<<<<< HEAD
                        Toast.makeText(LoginActivity.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                        // Navigate to the main activity
=======
                        Toast.makeText(LoginActivity.this, "Login successful y el token es: " + response.body().getToken(), Toast.LENGTH_SHORT).show();
                        // Navigate to the main activity or home screen
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                } else {
<<<<<<< HEAD
                    // Fail Response
=======
                    // Error en el login
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
                    Toast.makeText(LoginActivity.this, "Su usuario o su contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
<<<<<<< HEAD
            public void onFailure(Call<MdlUser> call, Throwable t) {
                // Fail Connection
=======
            public void onFailure(Call<UserResponse> call, Throwable t) {
                // Manejo de errores de conexión u otros errores
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
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