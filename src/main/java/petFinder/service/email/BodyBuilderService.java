package petFinder.service.email;


import petFinder.entity.User;

public interface BodyBuilderService {

    String emailBody (User myUser);
}
