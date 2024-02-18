package learn.spring.LearnSpring.services;

import learn.spring.LearnSpring.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User saveUser(User user);
    User findByEmail(String email);
    User updateUser(Long id, User user);

    User findUserByUsername(String username);

    void deleteUser(String email);

}
