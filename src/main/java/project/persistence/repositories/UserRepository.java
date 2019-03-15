package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Progress;
import project.persistence.entities.User;
import project.persistence.entities.Workout;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    @Query(value = "SELECT p FROM User p WHERE p.username = ?1")
    List<User> findOne(String username);
    List<User> findAll();

}
