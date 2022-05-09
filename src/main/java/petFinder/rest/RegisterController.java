package petFinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import petFinder.entity.User;
import petFinder.entity.Role;
import petFinder.exceptions.EmailAlreadyExists;
import petFinder.mapper.UserMapper;
import petFinder.repository.UserRepository;
import petFinder.rest.model.UserDTO;
import petFinder.service.user.UserService;

import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        User user = new User();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(false);
        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(@ModelAttribute("user") @RequestBody UserDTO user) throws EmailAlreadyExists {
        if (user.getPassword().equalsIgnoreCase(user.getPasswordConfirm())) {
            user.setRoles(Set.of(new Role("ROLE_USER")));
            if(emailExists(user.getEmail())){
                throw new EmailAlreadyExists("Email already exists!");
            }
            UserMapper.fromEntityToDTO(userService.saveUser(UserMapper.fromDtoToEntity(user)));
            return "register-success";
        } else {
            return "register";
        }
    }

    private boolean emailExists(final String email) {
        return userRepository.findUserByEmail(email) != null;
    }
}
