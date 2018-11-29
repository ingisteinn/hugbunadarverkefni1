package project.persistence.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workout") // If you want to specify a table name, you can do so here
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String name;
    private String category;
    @ElementCollection
    @CollectionTable(name="listOfWorkoutExercises")
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<WorkoutExercise> exercises;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int day;
    private int month;
    private int year;

    public Workout() {
    }

    public Workout(Long id, Long userId, String name, String category, List exercises, Date date) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.category = category;
        this.exercises = exercises;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<WorkoutExercise> getExercises() { return exercises; }

    public void setExercises(List exercises) { this.exercises = exercises; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.day = date.getDate();
        this.month = (date.getMonth() + 1);
        this.year = date.getYear() + 1900;
        this.date = date;
    }

}
