package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Workout;
import project.persistence.repositories.WorkoutRepository;

import java.util.List;

@Service
public class WorkoutService {
    WorkoutRepository repository;

    @Autowired
    public WorkoutService(WorkoutRepository repository) {
        this.repository = repository;
    }

    public Workout save(Workout workout) {
        return repository.save(workout);
    }

    public void delete(Workout workout) {
        repository.delete(workout);
    }

    public List<Workout> findAll() {
        return repository.findAll();
    }

    public List<Workout> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Workout> findByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Workout findOne(Long id) {
        return repository.findOne(id);
    }
}
