package com.dev.campusfrontute;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.campusfrontute.adapters.CourseAdapter;
import com.dev.campusfrontute.models.MdlCourse;
import com.dev.campusfrontute.models.helpers.MdlUserWithRole;
import com.dev.campusfrontute.repositories.CourseRepository;
import com.dev.campusfrontute.repositories.UserRepository;

import java.util.List;

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
                    displayUserName(mdlUserWithRole);
                    loadUserCourses(mdlUserWithRole.getUser().getId());
                } else {
                    Toast.makeText(MainActivity.this, "Error al obtener al usuario logueado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void displayUserName(MdlUserWithRole mdlUserWithRole) {
        TextView txtName = findViewById(R.id.txt_user);

        String fullFirstName = mdlUserWithRole.getUser().getFirstname();
        String[] nameParts = fullFirstName.split(" ");
        String firstName = nameParts[0];

        String fullLastName = mdlUserWithRole.getUser().getLastname();
        String[] lastNameParts = fullLastName.split(" ");
        String lastName = lastNameParts[0];

        // Set text
        txtName.setText(firstName + ", " + lastName + "!");
    }

    private void loadUserCourses(long userId) {
        recyclerView = findViewById(R.id.rvCourses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        } else {
            courseAdapter.notifyDataSetChanged();
        }
    }
}
