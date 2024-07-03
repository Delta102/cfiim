package com.dev.campusfrontute.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dev.campusfrontute.models.helpers.MdlUserWithRole;
import com.dev.campusfrontute.network.RetrofitClient;
import com.dev.campusfrontute.services.UserAuthService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private UserAuthService userAuthService;
    private static final String SHARED_PREFS = "shared_prefs";
    private static final String TAG = "UserRepository";
    private SharedPreferences sharedPreferences;

    public UserRepository(Context context) {
        userAuthService = RetrofitClient.getClient(context).create(UserAuthService.class);
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    public LiveData<MdlUserWithRole> getLoggedUser() {
        MutableLiveData<MdlUserWithRole> userLiveData = new MutableLiveData<>();

        userAuthService.getLoggedUser().enqueue(new Callback<MdlUserWithRole>() {
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

        return userLiveData;
    }


    /*LOGOUT FUNCTION*/
    public void logout(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("token");
        editor.apply();
    }

}
