package petFinder.service.token.impl;

import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Service;
import petFinder.entity.User;
import petFinder.service.token.RandomTokenService;

import java.util.UUID;

@Service
public class RandomTokenServiceImpl implements RandomTokenService {

    public String randomToken(User user) {
        UUID nameBasedUUID = Generators.nameBasedGenerator().generate(user.getUsername());
        return nameBasedUUID.toString();
    }
}
