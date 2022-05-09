package petFinder.service.user;

import org.springframework.stereotype.Service;
import petFinder.entity.User;

import java.util.List;

@Service
public interface  UserService {

    User findUserByEmail(String email);

    User findUserByUserName(String userName);

    User findUserByRandomToken(String randomToken);

    boolean findUserByUserNameAndPassword(String userName, String password);

    List<User> findAll();

    void deleteById(long id);

    User saveUser(User u);

}
