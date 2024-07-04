package com.dev.campusfrontute.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.campusfrontute.CourseActivity;
import com.dev.campusfrontute.R;
import com.dev.campusfrontute.models.MdlCourse;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private List<MdlCourse> courseList;
    private Context context;
    private Boolean isExpanded = false;

    public CourseAdapter(List<MdlCourse> courseList, Context context) {
        this.courseList = courseList;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        MdlCourse course = courseList.get(position);

        // Get the views
        LinearLayout linearLayout = holder.itemView.findViewById(R.id.llCourse);
        TextView txtCourseName = holder.itemView.findViewById(R.id.txtCourseName);
        TextView txtCourseShortName = holder.itemView.findViewById(R.id.txtCourseShortName);
        TextView txtCourseStatus = holder.itemView.findViewById(R.id.txtCourseStatus);


        // Visual Elements
        txtCourseName.setText(course.getFullname());
        txtCourseShortName.setText(course.getShortname());
        txtCourseStatus.setText("Activado: " + course.getId());

        // Intent for Course Detail
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CourseActivity.class);
                intent.putExtra("courseId", course.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}