package softuni.firstworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.firstworkshop.model.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

    Optional<User> findByUsername(String name);
}
