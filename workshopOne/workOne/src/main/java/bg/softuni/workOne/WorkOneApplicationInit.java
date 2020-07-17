package bg.softuni.workOne;

import bg.softuni.workOne.announcement.model.AnnouncementEntity;
import bg.softuni.workOne.announcement.repository.AnnouncementRepository;
import bg.softuni.workOne.users.model.RoleEntity;
import bg.softuni.workOne.users.model.UserEntity;
import bg.softuni.workOne.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Component
public class WorkOneApplicationInit implements CommandLineRunner {

    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (announcementRepository.count() == 0) {
            AnnouncementEntity announcementEntity = new AnnouncementEntity();
            announcementEntity.setTitle("Hello Simo");
            announcementEntity.setDescription("Ti mojesh Simo");
            announcementEntity.setCreatedOn(Instant.now());
            announcementEntity.setUpdatedOn(Instant.now());
            announcementRepository.save(announcementEntity);
        }

        if (userRepository.count() == 0) {
            //admin
            UserEntity admin = new UserEntity();
            admin.setEmail("admin@example.com");
            admin.setPasswordHash(passwordEncoder.encode("1234"));

            RoleEntity adminAdminRole = new RoleEntity();
            adminAdminRole.setRole("ROLE_ADMIN");

            RoleEntity adminUserRole = new RoleEntity();
            adminUserRole.setRole("ROLE_USER");

            admin.setRoles(List.of(adminAdminRole, adminUserRole));

            userRepository.save(admin);

//admin
            UserEntity user = new UserEntity();
            user.setEmail("user@example.com");
            user.setPasswordHash(passwordEncoder.encode("5678"));

            RoleEntity userUserRole = new RoleEntity();
            userUserRole.setRole("ROLE_USER");

            user.setRoles(List.of(userUserRole));

            userRepository.save(user);


        }
    }
}
