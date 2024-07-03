package com.dev.campusfrontute.services;

import com.dev.campusfrontute.models.helpers.LoginRequest;
import com.dev.campusfrontute.models.MdlUser;
import com.dev.campusfrontute.models.helpers.MdlUserWithRole;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserAuthService {
    @POST("Auth/login")
    Call<MdlUser> loginUser(@Body LoginRequest request);
    @GET("Auth/profile")
    Call<MdlUserWithRole> getLoggedUser();
}