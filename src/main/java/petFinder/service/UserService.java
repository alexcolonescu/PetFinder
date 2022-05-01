package petFinder.service;

import org.springframework.stereotype.Service;
import petFinder.entity.User;

import java.util.List;

@Service
public interface  UserService {

    User findUserByEmail(String email);

    User findUserByUserName(String userName);

    boolean findUserByUserNameAndPassword(String userName, String password);

    List<User> findAll();

    void deleteById(long id);

    User saveUser(User u);

}
