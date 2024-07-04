package com.dev.campusfrontute.services;

import com.dev.campusfrontute.models.MdlCourse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CourseService {
    @GET("Course/{courseId}")
    Call<MdlCourse> getCourseById(@Path("courseId") long courseId);
}
