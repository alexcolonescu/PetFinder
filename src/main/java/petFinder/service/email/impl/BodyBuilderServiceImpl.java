package petFinder.service.email.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petFinder.entity.User;
import petFinder.service.email.BodyBuilderService;
import petFinder.service.token.RandomTokenService;

@Service
public class BodyBuilderServiceImpl implements BodyBuilderService {

    @Autowired
    RandomTokenService randomTokenService;

    @Override
    public String emailBody(User myUser) {
        return "Hello," +
                "In order to activate your PetFinder account, please access the following link:\n" +
                "http://localhost:8080/activation/" + myUser.getRandomToken();
    }
}
