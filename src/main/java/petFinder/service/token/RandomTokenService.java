package petFinder.service.token;

import petFinder.entity.User;

public interface RandomTokenService {

    String randomToken(User user);
}
