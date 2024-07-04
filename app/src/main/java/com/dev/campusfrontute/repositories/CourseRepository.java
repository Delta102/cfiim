package com.dev.campusfrontute.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dev.campusfrontute.models.MdlCourse;
import com.dev.campusfrontute.network.RetrofitClient;
import com.dev.campusfrontute.services.CourseService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {
    private CourseService courseService;
    private static final String TAG = "CourseRepository";
    private SharedPreferences sharedPreferences;

    public CourseRepository(Context context) {
        courseService = RetrofitClient.getClient(context).create(CourseService.class);
    }

    public LiveData<MdlCourse> getCoursesById(long courseId) {
        MutableLiveData<MdlCourse> courseLiveData = new MutableLiveData<>();

        courseService.getCourseById(courseId).enqueue(new Callback<MdlCourse>() {
            @Override
            public void onResponse(Call<MdlCourse> call, Response<MdlCourse> response) {
                MdlCourse courses = response.body();
                courseLiveData.setValue(courses);
            }

            @Override
            public void onFailure(Call<MdlCourse> call, Throwable t) {
                Log.e(TAG, "Error al obtener el curso: " + t.getMessage());
                courseLiveData.setValue(null);
            }
        });

        return courseLiveData;
    }
}
