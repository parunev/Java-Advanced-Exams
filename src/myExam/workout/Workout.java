package myExam.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    public String type;
    public int exerciseCount;
    public List<Exercise> exercises;

    public Workout(String type, int exerciseCount){
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise){
        if (exercises.size() < exerciseCount){
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle){
        for (Exercise exercise : exercises){
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise:exercises){
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise(){
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount(){
        return exercises.size();
    }

    public String getStatistics() {
        return "Workout type: " + type + System.lineSeparator() +
                exercises.stream().map(Exercise::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
