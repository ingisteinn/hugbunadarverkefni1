package project.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Exercise {
    @Id
    private Long id;
    private String name;
    private String category;

    public Exercise() {
    }

    public Exercise(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
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
}
