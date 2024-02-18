package learn.spring.LearnSpring.controlers;

import learn.spring.LearnSpring.model.User;
import learn.spring.LearnSpring.services.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class UserProfileController {
    @NonNull
    private UserService service;

    @GetMapping
    public String getUserProfile(Model model, Principal principal) {
        User user = service.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "userProfile";
    }
}
