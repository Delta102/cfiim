package com.dev.campusfrontute;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.campusfrontute.adapters.CourseAdapter;
import com.dev.campusfrontute.models.MdlCourse;
import com.dev.campusfrontute.models.helpers.MdlUserWithRole;
import com.dev.campusfrontute.repositories.CourseRepository;
import com.dev.campusfrontute.repositories.UserRepository;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private UserRepository usersRepository;
    private CourseRepository coursesRepository;
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersRepository = new UserRepository(this);
        coursesRepository = new CourseRepository(this);

        setupLogoutButton();
        observeLoggedUser();
    }

    private void setupLogoutButton() {
        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersRepository.logout();
                navigateToLogin();
            }
        });
    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void observeLoggedUser() {
        usersRepository.getLoggedUser().observe(this, new Observer<MdlUserWithRole>() {
            @Override
            public void onChanged(MdlUserWithRole mdlUserWithRole) {
                if (mdlUserWithRole != null && mdlUserWithRole.getUser() != null) {
                    displayUserInfo(mdlUserWithRole);
                    loadUserCourses(mdlUserWithRole.getUser().getId());
                } else {
                    Toast.makeText(MainActivity.this, "Error al obtener al usuario logueado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void displayUserInfo(MdlUserWithRole mdlUserWithRole) {

        ImageView imgProfilePicture = findViewById(R.id.imgPicture);
        // Load Image
        if(mdlUserWithRole.getUser().getPicture() != 0) {
            Log.d(TAG, "displayUserInfo: " + mdlUserWithRole.getPictureUrl());
            loadImageProfile(mdlUserWithRole.getPictureUrl(), imgProfilePicture);
        }
        else{
            imgProfilePicture.setImageResource(R.drawable.userblankprofile);
        }





        TextView txtName = findViewById(R.id.txt_user);

        String fullFirstName = mdlUserWithRole.getUser().getFirstname().trim();
        String firstName = capitalize(fullFirstName.split(" ")[0]);

        String fullLastName = mdlUserWithRole.getUser().getLastname().trim();
        String lastName = capitalize(fullLastName.split(" ")[0]);

        // Set text
        txtName.setText(firstName + ", " + lastName + "!");
    }

    private void loadImageProfile(String url, ImageView imgProfilePicture) {
        Picasso.get()
                .load(R.drawable.background)
                .fit()
                .centerCrop()
                .placeholder(R.drawable.userblankprofile)
                .error(R.drawable.userblankprofile)
                .networkPolicy(NetworkPolicy.NO_CACHE)  // Evita la caché
                .into(imgProfilePicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("loadingpicture", "Imagen cargada exitosamente");
                    }
                    @Override
                    public void onError(Exception e) {
                        Log.e("loadingpicture", "Error al cargar la imagen: " + e.getMessage());
                    }
                });
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    private void loadUserCourses(long userId) {
        recyclerView = findViewById(R.id.rvCourses);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        coursesRepository.getCoursesByTeacherId(userId).observe(this, new Observer<List<MdlCourse>>() {
            @Override
            public void onChanged(List<MdlCourse> courses) {
                if (courses != null) {
                    setupCourseAdapter(courses);
                } else {
                    // Handle case where courses are null
                    Toast.makeText(MainActivity.this, "No se encontraron cursos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupCourseAdapter(List<MdlCourse> courses) {
        if (courseAdapter == null) {
            courseAdapter = new CourseAdapter(courses, MainActivity.this);
            recyclerView.setAdapter(courseAdapter);
        } else
            courseAdapter.notifyDataSetChanged();
    }
}
