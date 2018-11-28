package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Exercise;
import project.persistence.entities.WorkoutExercise;

import java.util.List;


public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {

    WorkoutExercise save(WorkoutExercise exercise);

    void delete(WorkoutExercise exercise);

    List<WorkoutExercise> findAll();

    List<WorkoutExercise> findByName(String name);

    @Query(value = "SELECT p FROM Exercise p WHERE p.id = ?1")
    WorkoutExercise findOne(Long id);
}
