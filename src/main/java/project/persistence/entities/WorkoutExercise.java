package project.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workoutExercise") // If you want to specify a table name, you can do so here
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int sets;
    private int reps;
    private double weight;


    public WorkoutExercise() {
    }

    public WorkoutExercise(Long id, String name, int sets, int reps, double weight) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
