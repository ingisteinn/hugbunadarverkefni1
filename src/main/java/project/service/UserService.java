package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Exercise;
import project.persistence.entities.User;
import project.persistence.repositories.ExerciseRepository;
import project.persistence.repositories.UserRepository;

@Service
public class UserService {

    UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User findOne(String username) {
        return repository.findOne(username);
    }

 


}
