package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.WorkoutExercise;
import project.persistence.repositories.WorkoutExerciseRepository;

import java.util.*;

@Service
public class WorkoutExerciseService {

    WorkoutExerciseRepository repository;

    @Autowired
    public WorkoutExerciseService(WorkoutExerciseRepository repository) {
        this.repository = repository;
    }

    public WorkoutExercise save(WorkoutExercise exercise) {
        return repository.save(exercise);
    }

    public void delete(WorkoutExercise exercise) {
        repository.delete(exercise);
    }

    public List<WorkoutExercise> findAll() {
        return repository.findAll();
    }

    public List<WorkoutExercise> findByName(String name) {
        return repository.findByName(name);
    }

    public WorkoutExercise findOne(Long id) {
        return repository.findOne(id);
    }

}
