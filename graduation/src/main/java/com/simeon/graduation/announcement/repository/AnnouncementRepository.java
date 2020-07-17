package com.simeon.graduation.announcement.repository;

import com.simeon.graduation.announcement.model.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository  extends JpaRepository<AnnouncementEntity, Long> {

}
