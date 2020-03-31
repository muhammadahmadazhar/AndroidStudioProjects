package com.example.application27;

import java.util.ArrayList;
import java.util.List;

public class WorkoutExpert {

    List<String> getWorkouts(String workoutTypes){
        List<String> workout=new ArrayList<String>();
        if(workoutTypes.equals("Chest")){
            workout.add("Bench Press");
            workout.add("Cable Flys");
        }
        else if(workoutTypes.equals("Biceps")){
            workout.add("Biceps Curls");
        }
        else if(workoutTypes.equals("Triceps")){
            workout.add("Tricep Ext");
            workout.add("Tricep PushDowns");
        }
        else if(workoutTypes.equals("Shoulders")){
            workout.add("Shoulder Press");
        }
        return workout;
    }
}
