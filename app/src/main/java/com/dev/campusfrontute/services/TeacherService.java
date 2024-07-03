package com.dev.campusfrontute.services;


import com.dev.campusfrontute.models.MdlCourse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TeacherService {
    @GET("courses/{teacherId}")
    Call<List<MdlCourse>> getCoursesByTeacher(@Path("teacherId") long teacherId);
}
