package project.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workout") // If you want to specify a table name, you can do so here
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private List<Exercise> exercises;

    public Workout() {
    }

    public Workout(Long id, String name, String category, List exercises) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.exercises = exercises;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List getExercises() { return exercises; }

    public void setExercises(List exercises) { this.exercises = exercises; }
}
