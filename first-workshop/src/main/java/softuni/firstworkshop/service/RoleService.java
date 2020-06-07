package softuni.firstworkshop.service;


import softuni.firstworkshop.model.service.RoleServiceModel;

public interface RoleService {

    RoleServiceModel findByName(String name);
}
