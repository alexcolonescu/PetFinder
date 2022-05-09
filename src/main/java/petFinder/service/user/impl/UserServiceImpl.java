package petFinder.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import petFinder.entity.User;
import petFinder.entity.Role;
import petFinder.repository.RoleRepository;
import petFinder.repository.UserRepository;
import petFinder.service.email.BodyBuilderService;
import petFinder.service.email.EmailSender;
import petFinder.service.token.RandomTokenService;
import petFinder.service.user.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    BodyBuilderService bodyBuilderService;

    @Autowired
    EmailSender emailSender;

    @Autowired
    RandomTokenService randomTokenService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public User findUserByRandomToken(String randomToken) {
        return userRepository.findByRandomToken(randomToken);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUsernameIgnoreCase(userName);
    }

    public boolean findUserByUserNameAndPassword(String userName, String password){
        final Optional<User> myUser = Optional.ofNullable(userRepository.findByUsernameIgnoreCase(userName));
        return myUser.filter(user -> BCrypt.checkpw(password, user.getPassword())).isPresent();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    public User saveUser(User u){
        User user = new User(u);
        user.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
        user.setRandomToken(randomTokenService.randomToken(u));
        emailSender.sendEmail(user.getEmail(), "Activate your PetFinder Account", bodyBuilderService.emailBody(user));
        u.getRoles().forEach(role -> {
            final Role roleByName = roleRepository.findByName(role.getName());
            if (roleByName == null)
                user.getRoles().add(roleRepository.save(role));
            else
                role.setId(roleByName.getId());
        });
        return userRepository.save(user);
    }
}
