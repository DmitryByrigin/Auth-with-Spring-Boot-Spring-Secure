package learn.spring.LearnSpring.controlers;
import learn.spring.LearnSpring.model.User;
import learn.spring.LearnSpring.services.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @NonNull
    private UserService service;

    @GetMapping
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }


    @GetMapping("/{email}")
    public User findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @PutMapping("update_user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id ) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("delete_user/{email}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteUser(@PathVariable String email) {
        service.deleteUser(email);
    }
}
