package bg.softuni.security;

import bg.softuni.security.model.AuthorityEntity;
import bg.softuni.security.model.UserEntity;
import bg.softuni.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityApplicationInit implements CommandLineRunner {

   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

    public SecurityApplicationInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = new UserEntity();
        user.setName("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setEnabled(true);

        AuthorityEntity userAuthorityEntity = new AuthorityEntity();
        userAuthorityEntity.setName("ROLE_USER");
        userAuthorityEntity.setUser(user);

        user.setAuthorities(List.of(userAuthorityEntity));

        userRepository.save(user);

        UserEntity admin = new UserEntity();
        admin.setName("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setEnabled(true);

        AuthorityEntity adminAdminAuthorityEntity = new AuthorityEntity();
        adminAdminAuthorityEntity.setName("ROLE_ADMIN");
        adminAdminAuthorityEntity.setUser(admin);

        AuthorityEntity adminUserAuthorityEntity = new AuthorityEntity();
        adminUserAuthorityEntity.setName("ROLE_USER");
        adminUserAuthorityEntity.setUser(admin);

        admin.setAuthorities(List.of(adminUserAuthorityEntity, adminAdminAuthorityEntity));

        userRepository.save(admin);
    }
}
