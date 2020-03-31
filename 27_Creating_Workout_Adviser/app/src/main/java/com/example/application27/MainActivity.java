package com.example.application27;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {
    private WorkoutExpert expert=new WorkoutExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindWorkout(View view){
        TextView workouts=(TextView) findViewById(R.id.textView);
        Spinner workouttype=(Spinner) findViewById(R.id.workouttype);
        String work=String.valueOf(workouttype.getSelectedItem());
//        workouts.setText(work);
        List<String> workoutList=expert.getWorkouts(work);
        StringBuilder workoutsFormated=new StringBuilder();
        for(String st: workoutList){
            workoutsFormated.append(st).append("\n");
        }
        workouts.setText(workoutsFormated);
    }
}
