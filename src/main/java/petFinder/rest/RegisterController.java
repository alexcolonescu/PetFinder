package petFinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import petFinder.entity.User;
import petFinder.entity.Role;
import petFinder.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        User user = new User();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(@ModelAttribute("user") @RequestBody User user) {
        if (user.getPassword().equalsIgnoreCase(user.getPasswordConfirm())) {
            user.setRoles(Set.of(new Role("ROLE_USER")));
            userService.saveUser(user);
            return "login";
        } else {
            return "register";
        }
    }
}
