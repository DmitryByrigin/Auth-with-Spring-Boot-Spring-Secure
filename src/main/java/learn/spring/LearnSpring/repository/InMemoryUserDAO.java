package learn.spring.LearnSpring.repository;

import learn.spring.LearnSpring.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryUserDAO {
    private final List<User> USERS = new ArrayList<>();

    public List<User> findAllUsers() {
        return USERS;
    }

    public User saveUser(User user) {
        USERS.add(user);
        return user;
    }

    public User findByEmail(String email) {
//        return null;
        return USERS.stream().filter(element -> element.getEmail().equals(email)).findFirst().orElse(null);
    }

    public User findUserByUsername(String username) {
//        return null;
        return USERS.stream().filter(element -> element.getUsername().equals(username)).findFirst().orElse(null);
    }

    public User updateUser(User user) {
        var userIndex = IntStream.range(0, USERS.size()).filter(index -> USERS.get(index).getEmail().equals(user.getEmail())).findFirst().orElse(-1);
        if(userIndex > -1) {
            USERS.set(userIndex, user);
            return user;
        }
        return null;
    }

    public void deleteUser(String email) {

        var user = findByEmail(email);
        if(user != null) {
            USERS.remove(user);
        }
    }
}
