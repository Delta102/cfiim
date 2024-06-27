package com.dev.campusfrontute.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.campusfrontute.R;
import com.dev.campusfrontute.models.MdlCourse;
import com.dev.campusfrontute.network.RetrofitClient;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private List<MdlCourse> courseList;
    private Context context;

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

        // Aquí vinculas los datos del curso con los elementos visuales del ViewHolder
        holder.txtCourseName.setText(course.getFullname());
        holder.txtCourseDescription.setText(course.getShortname());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView txtCourseName;
        TextView txtCourseDescription;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCourseName = itemView.findViewById(R.id.courseTextView);
            txtCourseDescription = itemView.findViewById(R.id.shortNameTxtView);
        }
    }
}