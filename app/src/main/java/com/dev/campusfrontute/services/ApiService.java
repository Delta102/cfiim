package com.dev.campusfrontute.services;

import com.dev.campusfrontute.models.helpers.LoginRequest;
<<<<<<< HEAD
import com.dev.campusfrontute.models.MdlUser;
import com.dev.campusfrontute.models.helpers.MdlUserWithRole;
=======
import com.dev.campusfrontute.models.helpers.UserResponse;
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @POST("Auth/login")
<<<<<<< HEAD
    Call<MdlUser> loginUser(@Body LoginRequest request);
    @GET("Auth/profile")
    Call<MdlUserWithRole> getLoggedUser(@Header("Authorization") String token);
    /*@POST("Auth/logout")
    Call<Void> logoutUser(@Header("Authorization") String token);*/

=======
    Call<UserResponse> loginUser(@Body LoginRequest request);
    @GET("api/MdlUsers/profile")
    Call<UserResponse> getUserProfile(@Header("Authorization") String token);
>>>>>>> 475d4251c30d8f8b845c9c05b82716f2f8f01c7c
}