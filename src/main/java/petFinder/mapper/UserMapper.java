package petFinder.mapper;

import petFinder.entity.User;
import petFinder.rest.model.UserDTO;

public class UserMapper {

    public static User fromDtoToEntity(UserDTO myUserDTO){
        return new User(myUserDTO.getUsername(), myUserDTO.getPassword(), myUserDTO.isAccountNonExpired(),
                myUserDTO.isAccountNonLocked(), myUserDTO.isCredentialsNonExpired(), myUserDTO.isEnabled(),
                myUserDTO.getFullName(), myUserDTO.getEmail(), myUserDTO.getRoles(), myUserDTO.getPasswordConfirm());
    }

    public static UserDTO fromEntityToDTO(User myUser){
        return new UserDTO(myUser.getId(), myUser.getUsername(), myUser.getFullName(),
                myUser.getEmail());
    }

}
