package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Exercise;
import project.persistence.repositories.ExerciseRepository;

import java.util.List;

@Service
public class ExerciseService {

    ExerciseRepository repository;

    @Autowired
    public ExerciseService(ExerciseRepository repository) {
        this.repository = repository;
    }

    public Exercise save(Exercise exercise) {
        return repository.save(exercise);
    }

    public void delete(Exercise exercise) {
        repository.delete(exercise);
    }

    public List<Exercise> findAll() {
        return repository.findAll();
    }

    public List<Exercise> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Exercise> findByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Exercise findOne(Long id) {
        return repository.findOne(id);
    }
}
