package com.dev.campusfrontute.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dev.campusfrontute.models.MdlUser;
import com.dev.campusfrontute.models.helpers.MdlUserWithRole;
import com.dev.campusfrontute.network.RetrofitClient;
import com.dev.campusfrontute.services.ApiService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private ApiService apiService;
    private static final String SHARED_PREFS = "shared_prefs";
    private static final String TAG = "UserRepository";
    private SharedPreferences sharedPreferences;

    public UserRepository(Context context) {
        apiService = RetrofitClient.getClient().create(ApiService.class);
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    public LiveData<MdlUserWithRole> getLoggedUser() {
        MutableLiveData<MdlUserWithRole> userLiveData = new MutableLiveData<>();
        String token = sharedPreferences.getString("token", null);

        if (token != null) {
            String authHeader = "Bearer " + token;
            apiService.getLoggedUser(authHeader).enqueue(new Callback<MdlUserWithRole>() {
                @Override
                public void onResponse(Call<MdlUserWithRole> call, Response<MdlUserWithRole> response) {
                    if (response.isSuccessful()) {
                        MdlUserWithRole userResponse = response.body();
                        Log.d(TAG, "Respuesta de usuario: " + new Gson().toJson(userResponse));
                        if (userResponse != null)
                            userLiveData.setValue(userResponse);
                        else {
                            Log.e(TAG, "Respuesta de usuario nula");
                            userLiveData.setValue(null);
                        }
                    } else {
                        Log.e(TAG, "Error al obtener el perfil del usuario: " + response.message());
                        userLiveData.setValue(null);
                    }
                }

                @Override
                public void onFailure(Call<MdlUserWithRole> call, Throwable t) {
                    Log.e(TAG, "Error al obtener el perfil del usuario: " + t.getMessage());
                    userLiveData.setValue(null);
                }
            });
        } else {
            userLiveData.setValue(null);
            Log.e(TAG, "Token Nulo");
        }
        return userLiveData;
    }

    /*LOGOUT FUNCTION*/
    public void logout(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("token");
        editor.apply();
    }

}
