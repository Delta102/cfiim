package com.dev.campusfrontute.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dev.campusfrontute.models.MdlCourse;
import com.dev.campusfrontute.models.helpers.MdlUserWithRole;
import com.dev.campusfrontute.network.RetrofitClient;
import com.dev.campusfrontute.services.TeacherService;
import com.dev.campusfrontute.services.UserAuthService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {
    private TeacherService teacherService;
    private static final String SHARED_PREFS = "shared_prefs";
    private static final String TAG = "CourseRepository";
    private SharedPreferences sharedPreferences;

    public CourseRepository(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        teacherService = RetrofitClient.getClient(context).create(TeacherService.class);
    }

    public LiveData<List<MdlCourse>> getCoursesByTeacherId(long teacherId) {
        MutableLiveData<List<MdlCourse>> courseLiveData = new MutableLiveData<>();

        teacherService.getCoursesByTeacher(teacherId).enqueue(new Callback<List<MdlCourse>>() {

            @Override
            public void onResponse(Call<List<MdlCourse>> call, Response<List<MdlCourse>> response) {
                if (response.isSuccessful()) {
                    List<MdlCourse> courses = response.body();
                    courseLiveData.setValue(courses);
                } else {
                    Log.e(TAG, "Error al obtener los cursos del profesor: " + response.message());
                    courseLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<MdlCourse>> call, Throwable t) {
                Log.e(TAG, "Error al obtener los cursos del profesor: " + t.getMessage());
                courseLiveData.setValue(null);
            }
        });

        return courseLiveData;
    }
}