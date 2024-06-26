package com.dev.campusfrontute.services;

import com.dev.campusfrontute.models.helpers.LoginRequest;
import com.dev.campusfrontute.models.helpers.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @POST("Auth/login")
    Call<UserResponse> loginUser(@Body LoginRequest request);
    @GET("api/MdlUsers/profile")
    Call<UserResponse> getUserProfile(@Header("Authorization") String token);
}