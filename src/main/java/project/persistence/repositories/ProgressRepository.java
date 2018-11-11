package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Progress;
import project.persistence.entities.User;

import java.util.List;

public interface ProgressRepository extends JpaRepository<User, Long> {

    Progress save(Progress progress);

    @Query(value = "SELECT p FROM Progress p WHERE p.userId = ?1")
    List<Progress> findByUserId(Long userId);

}
