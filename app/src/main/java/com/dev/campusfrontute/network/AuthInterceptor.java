package com.dev.campusfrontute.network;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    private SharedPreferences sharedPreferences;
    public AuthInterceptor(Context context) {
        sharedPreferences = context.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        String token = sharedPreferences.getString("token", null);
        Request original = chain.request();
        Request.Builder builder = original.newBuilder();
        if (token != null)
            builder.header("Authorization", "Bearer " + token);


        return chain.proceed(builder.build());
    }
}
