package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Workout;

import java.util.List;


public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout save(Workout workout);

    void delete(Workout workout);

    List<Workout> findAll();

    List<Workout> findByName(String name);

    List<Workout> findByCategory(String category);

    @Query(value = "SELECT p FROM Workout p WHERE p.id = ?1")
    Workout findOne(Long id);
}
