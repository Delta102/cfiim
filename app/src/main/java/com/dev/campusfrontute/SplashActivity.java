package com.dev.campusfrontute;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.auth0.android.jwt.JWT;

public class SplashActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "shared_prefs";
    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Animaciones
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        ImageView logoImageTextView = findViewById(R.id.logoImageView);

        logoImageTextView.setAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkLoginStatus();
                /*Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();*/
            }
        }, 4000);
    }

    private void checkLoginStatus() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);

        if (token != null && isTokenValid(token)) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        finish();
    }

    private boolean isTokenValid(String token) {
        try {
            JWT jwt = new JWT(token);
            if (jwt.isExpired(10)) {
                Log.i(TAG, "Token Expirado");
                return false;
            } else {
                Log.i(TAG, "Token Válido");
                return true;
            }
        } catch (Exception e) {
            Log.e(TAG, "Token Validation Error" + e.getMessage());
            return false;
        }
    }
}