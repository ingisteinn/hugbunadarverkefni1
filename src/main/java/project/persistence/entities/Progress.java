package project.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long exerciseId;
    private Long userId;
    private int sets;
    private int reps;
    private double weight;
    private Date date;

    public Progress() {
    }

    public Progress(Long id, Long exerciseId, Long userId, int sets, int reps, double weight, Date date) {
        this.id = id;
        this.exerciseId = exerciseId;
        this.userId = userId;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getWeight() {return weight; }

    public void setWeight(double weight ) {this.weight = weight; }

    public Date getDate() {return date; }

    public void setDate(Date date) {this.date = date; }



}
