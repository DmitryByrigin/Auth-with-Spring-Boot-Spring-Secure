package learn.spring.LearnSpring.controlers;

import learn.spring.LearnSpring.model.User;
import learn.spring.LearnSpring.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user) {
        User registeredUser = userService.saveUser(user);
        if (registeredUser != null) {
            return "userProfile";
        } else {
            return "register";
        }
    }
}
