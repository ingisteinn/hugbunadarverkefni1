package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.Exercise;

import java.util.List;


public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise save(Exercise exercise);

    void delete(Exercise exercise);

    List<Exercise> findAll();

    List<Exercise> findByName(String name);

    List<Exercise> findByCategory(String category);

    Exercise findById(Long id);
}
