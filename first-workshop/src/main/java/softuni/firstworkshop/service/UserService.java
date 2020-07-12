package softuni.firstworkshop.service;

import softuni.firstworkshop.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUserName(String username);

    List<String> findAllUsernames();

    void addRoleToUser(String username, String role);
}
