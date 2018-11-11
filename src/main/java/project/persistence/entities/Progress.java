package project.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Progress {
    @Id
    private Long exerciseId;
    private Long userId;
    private int sets;
    private int reps;
    private double weight;
    private Date date;

    public Progress() {
    }

    public Progress(Long exerciseId, Long userId, int sets, int reps, double weight, Date date) {
        this.exerciseId = exerciseId;
        this.userId = userId;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() { return reps; }

    public void setReps(int reps) { this.reps = reps; }

    public double getWeigt() {return weight; }

    public void setWeight(double weight ) {this.weight = weight; }

    public Date getDdate() {return date; }

    public void setDate(Date date) {this.date = date; }



}
