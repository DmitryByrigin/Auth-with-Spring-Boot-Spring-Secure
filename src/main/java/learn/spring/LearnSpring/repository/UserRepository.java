package learn.spring.LearnSpring.repository;

import learn.spring.LearnSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByEmail(String email);
    User findUserByEmail(String email);
    User findUserByUsername(String userName);
    User findUserById(Long id);
}
