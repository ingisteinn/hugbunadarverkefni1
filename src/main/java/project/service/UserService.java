package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Progress;
import project.persistence.entities.User;
import project.persistence.repositories.ProgressRepository;
import project.persistence.repositories.UserRepository;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    ProgressRepository progressRepository;

    @Autowired
    public UserService(UserRepository userRepository, ProgressRepository progressRepository) {
        this.userRepository = userRepository;
        this.progressRepository = progressRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findOne(String username) {
        return userRepository.findOne(username);
    }

    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public List<Progress> findByUserId(Long userId) {
        return progressRepository.findByUserId(userId);
    }

}
