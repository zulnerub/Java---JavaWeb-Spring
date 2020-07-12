package softuni.firstworkshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.firstworkshop.model.entity.Role;
import softuni.firstworkshop.model.entity.User;
import softuni.firstworkshop.model.service.UserServiceModel;
import softuni.firstworkshop.repository.UserRepository;
import softuni.firstworkshop.service.RoleService;
import softuni.firstworkshop.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        userServiceModel
                .setRole(this.roleService
                        .findByName( this.userRepository.count() == 0
                                ? "ADMIN" : "USER"));

        User user = this.modelMapper
                .map(userServiceModel, User.class);

        return this.modelMapper.map(
                this.userRepository.saveAndFlush(user), UserServiceModel.class);

    }

    @Override
    public UserServiceModel findByUserName(String username) {

        return this.userRepository
                .findByUsername(username)
                .map(user -> this.modelMapper
                    .map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return this.userRepository
                .findAll()
                .stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

    }

    @Override
    public void addRoleToUser(String username, String role) {
        User user = this.userRepository.findByUsername(username)
                .orElse(null);

        if (!user.getRole().getName().equals(role)){
            user.setRole(this.modelMapper.map(this.roleService.findByName(role), Role.class));
            this.userRepository.saveAndFlush(user);
        }
    }
}
