package com.simeon.graduation;

import com.simeon.graduation.announcement.model.AnnouncementEntity;
import com.simeon.graduation.announcement.repository.AnnouncementRepository;
import com.simeon.graduation.users.model.RoleEntity;
import com.simeon.graduation.users.model.UserEntity;
import com.simeon.graduation.users.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class GraduationApplicationInit implements CommandLineRunner {

    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    public GraduationApplicationInit(AnnouncementRepository announcementRepository, UserRepository userRepository) {
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (announcementRepository.count() == 0){
            AnnouncementEntity announcementEntity = new AnnouncementEntity();
            announcementEntity.setTitle("Office to clean");
            announcementEntity.setDescription("Two story office in London");
            announcementEntity.setCreatedOn(Instant.now());
            announcementEntity.setUpdatedOn(Instant.now());
            announcementRepository.save(announcementEntity);
        }

        if (userRepository.count() == 0){
            List<RoleEntity> roles = new ArrayList<>();
            RoleEntity roleUser = new RoleEntity();
            roleUser.setName("USER");

            roles.add(roleUser);


            UserEntity user = new UserEntity();
            user.setEmail("user@user.user");
            user.setPasswordHash("1234");
            user.setRoles(roles);

            userRepository.save(user);
        }
    }
}
