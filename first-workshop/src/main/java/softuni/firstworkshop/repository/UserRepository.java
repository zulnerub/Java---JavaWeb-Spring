package softuni.firstworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.firstworkshop.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

}
