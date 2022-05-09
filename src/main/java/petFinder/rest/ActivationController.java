package petFinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import petFinder.entity.User;
import petFinder.repository.UserRepository;
import petFinder.service.user.UserService;

@Controller
public class ActivationController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/activation/{randomToken}")
    public String registerForm(@PathVariable String randomToken, Model model) {
        User myUser = new User();
        model.addAttribute("user", userService.findUserByRandomToken(randomToken));
        return "activation";
    }

    @PostMapping(value = "/activation/{randomToken}")
    public String registerUser(@ModelAttribute("user") @RequestBody User user) {
        userService.findUserByRandomToken(user.getRandomToken()).setEnabled(true);
        userRepository.save(userService.findUserByRandomToken(user.getRandomToken()));
        return "redirect:/login";

    }
}
