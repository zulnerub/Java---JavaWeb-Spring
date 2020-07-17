package com.simeon.graduation.announcement;

import com.simeon.graduation.announcement.model.AnnouncementDTO;
import com.simeon.graduation.announcement.model.AnnouncementMapper;
import com.simeon.graduation.announcement.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public List<AnnouncementDTO> findAll(){
        return announcementRepository
                .findAll()
                .stream()
                .map(AnnouncementMapper.INSTANCE::mapAnnouncementEntityToDto)
                .collect(Collectors.toList());
    }
}
