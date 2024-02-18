package learn.spring.LearnSpring.services.impl;

import learn.spring.LearnSpring.model.User;
import learn.spring.LearnSpring.repository.InMemoryUserDAO;
import learn.spring.LearnSpring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryUserServiceImpl implements UserService {
    private final InMemoryUserDAO repository;

    @Override
    public List<User> findAllUsers() {
         return repository.findAllUsers();
    }

    @Override
    public User saveUser(User user) {
        return repository.saveUser(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User updateUser(Long id, User user) {
        return repository.updateUser(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    public void deleteUser(String email) {
        repository.deleteUser(email);
    }
}
