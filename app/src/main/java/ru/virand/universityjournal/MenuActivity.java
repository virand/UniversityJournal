package ru.virand.universityjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnMenuTimetable;
    Button btnMenuGroup;
    Button btnMenuTasks;
    Button btnMenuTeachers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btnMenuTimetable = (Button) findViewById(R.id.btnMenuTimetable);
        btnMenuGroup = (Button) findViewById(R.id.btnMenuGroup);
        btnMenuTasks = (Button) findViewById(R.id.btnMenuTasks);
        btnMenuTeachers = (Button) findViewById(R.id.btnMenuTeachers);

        btnMenuTimetable.setOnClickListener(this);
        btnMenuGroup.setOnClickListener(this);
        btnMenuTasks.setOnClickListener(this);
        btnMenuTeachers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent;

        switch(v.getId()){
            case R.id.btnMenuTimetable:
                intent = new Intent(this, TimetableActivity2.class);
                startActivity(intent);
                break;
            case R.id.btnMenuGroup:

                break;
            case R.id.btnMenuTasks:
                break;
            case R.id.btnMenuTeachers:
                break;
        }
    }
}
