package com.dev.campusfrontute;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;

import com.dev.campusfrontute.models.MdlCourse;
import com.dev.campusfrontute.models.helpers.ScheduleCourse;
import com.dev.campusfrontute.repositories.CourseRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;

public class CourseActivity extends AppCompatActivity {
    private CourseRepository courseRepository;
    private static final String TAG = "CourseActivity";
    private long courseId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        courseRepository = new CourseRepository(this);

        // Get the course ID from the intent
        courseId = getIntent().getLongExtra("courseId", -1);

        // Observe the course
        observeCourse(courseId);

    }

    private void observeCourse(long courseId) {
        courseRepository.getCoursesById(courseId).observe(this, new Observer<MdlCourse>() {
            @Override
            public void onChanged(MdlCourse mdlCourse) {
                if (mdlCourse != null)
                    displayCourseInfo(mdlCourse);
                else
                    Toast.makeText(CourseActivity.this, "Error al obtener al curso", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayCourseInfo(MdlCourse mdlCourse) {
        //Get the views
        ImageView imgCourse = findViewById(R.id.imgCourse);
        TextView txtCourseName = findViewById(R.id.txtCourseName);
        TextView txtCourseShortName = findViewById(R.id.txtCourseShortName);

        //TODO: Set the Schedule from the Course
        scheduleCourse(mdlCourse.getHorario());
        // Set the Course Image
        Picasso.get().load("https://industrial.unmsm.edu.pe/wp-content/uploads/2018/03/UTE.png").into(imgCourse);

        // Set the Views
        txtCourseName.setText(mdlCourse.getFullname());
        txtCourseShortName.setText(mdlCourse.getShortname());
    }

    private void scheduleCourse(String schedule) {
        Log.d(TAG, "scheduleCourse: " + schedule);

        // Find the TableLayout
        TableLayout tableLayout = findViewById(R.id.tblCourseSchedule);
        Button btnSeeMore = findViewById(R.id.btnSeeMore);

        if (schedule == null || schedule.isEmpty()) {
            // Create and add TextView for no schedule available
            TextView noScheduleTextView = new TextView(this);
            noScheduleTextView.setText("No hay horario disponible");
            noScheduleTextView.setTextColor(getResources().getColor(R.color.black, null));
            noScheduleTextView.setPadding(8, 8, 8, 8);

            // Add the TextView to the TableLayout
            tableLayout.addView(noScheduleTextView);

            // Hide the Ver Más button
            btnSeeMore.setVisibility(View.GONE);
            return;
        }

        // Parse the JSON
        Gson gson = new Gson();
        Type scheduleListType = new TypeToken<List<ScheduleCourse>>() {}.getType();
        List<ScheduleCourse> scheduleList = gson.fromJson(schedule, scheduleListType);

        // Limit to show only the first 3 schedules initially
        int maxSchedulesToShow = 3;
        for (int i = 0; i < Math.min(scheduleList.size(), maxSchedulesToShow); i++) {
            ScheduleCourse scheduleCourse = scheduleList.get(i);
            addScheduleRow(scheduleCourse, tableLayout);
        }

        // Show "Ver Más" button if there are more than maxSchedulesToShow
        if (scheduleList.size() > maxSchedulesToShow) {
            btnSeeMore.setVisibility(View.VISIBLE);
            final int remainingSchedules = scheduleList.size() - maxSchedulesToShow;
            btnSeeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Clear existing views
                    tableLayout.removeAllViews();

                    // Display all schedules
                    for (int j = 0; j < scheduleList.size(); j++) {
                        ScheduleCourse scheduleCourse = scheduleList.get(j);
                        addScheduleRow(scheduleCourse, tableLayout);
                    }

                    // Hide the "Ver Más" button
                    btnSeeMore.setVisibility(View.GONE);
                }
            });
        } else {
            // Hide the "Ver Más" button if there are not enough schedules to show
            btnSeeMore.setVisibility(View.GONE);
        }
    }

    private void addScheduleRow(ScheduleCourse scheduleCourse, TableLayout tableLayout) {
        TableRow tableRow = new TableRow(this);

        // Create and add TextView for the day
        TextView txtDay = new TextView(this);
        txtDay.setText(scheduleCourse.getDia());
        txtDay.setTextColor(getResources().getColor(R.color.black, null));
        txtDay.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        txtDay.setPadding(8, 8, 12, 8);
        tableRow.addView(txtDay);

        // Create and add TextView for the time
        TextView txtTime = new TextView(this);
        txtTime.setText(" " + scheduleCourse.getInicio() + " - " + scheduleCourse.getFin());
        txtTime.setTextColor(getResources().getColor(R.color.black, null));
        txtTime.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        txtTime.setPadding(12, 8, 8, 8);
        tableRow.addView(txtTime);

        // Add the TableRow to the TableLayout
        tableLayout.addView(tableRow);
    }
}