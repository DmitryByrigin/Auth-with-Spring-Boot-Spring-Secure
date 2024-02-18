package learn.spring.LearnSpring.services.impl;

import learn.spring.LearnSpring.model.User;
import learn.spring.LearnSpring.repository.UserRepository;
import learn.spring.LearnSpring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Primary
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User saveUser(User user) {
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findUserByEmail(email);
    }


    @Override
    public User updateUser(Long id, User user) {
        User existUser = repository.findUserById(id);

        existUser.setUsername(user.getUsername());
        existUser.setLastName(user.getLastName());
        existUser.setDateOfBirth(user.getDateOfBirth());
        existUser.setEmail(user.getEmail());
        existUser.setRoles(user.getRoles());
        existUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(existUser);
    }


    @Override
    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    @Transactional
    public void deleteUser(String email) {
        System.out.println("Interface " + email);
        repository.deleteByEmail(email);
    }
}
