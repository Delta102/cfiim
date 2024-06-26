package com.dev.campusfrontute;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.dev.campusfrontute.models.MdlUser;
import com.dev.campusfrontute.models.MdlUser;
import com.dev.campusfrontute.models.helpers.MdlUserWithRole;
import com.dev.campusfrontute.repositories.UserRepository;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private UserRepository usersRepository;
    private static final String TAG = "MainActivity";
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersRepository = new UserRepository(this);

        getLoggedUser(usersRepository);
        logoutAction();
    }

    private void getLoggedUser(UserRepository usersRepository){
        usersRepository.getLoggedUser().observe(this, new Observer<MdlUserWithRole>() {
            @Override
            public void onChanged(MdlUserWithRole mdlUserR) {
                if (mdlUserR != null && mdlUserR.getUser() != null)
                    mainUI(mdlUserR);

                else
                    Toast.makeText(MainActivity.this, "Error al obtener al usuario logueado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mainUI(MdlUserWithRole mdlUser){
        TextView txtName = findViewById(R.id.txt_user);
        txtName.setText("Bienvenido(a)! " + mdlUser.getUser().getFirstname() + ", " + mdlUser.getUser().getLastname());
    }

    private void logoutAction(){
        //Logout btn
        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersRepository.logout();
                navigateToLogin();
            }
        });
    }
    private void navigateToLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
