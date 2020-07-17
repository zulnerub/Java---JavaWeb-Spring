package bg.softuni.workOne.announcement;


import bg.softuni.workOne.announcement.model.AnnouncementDTO;
import bg.softuni.workOne.announcement.model.AnnouncementMapper;
import bg.softuni.workOne.announcement.repository.AnnouncementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public List<AnnouncementDTO> findAll() {
        return announcementRepository
                .findAll()
                .stream()
                .map(AnnouncementMapper.INSTANCE::mapAnnouncementEntityToDto)
                .collect(Collectors.toList());
    }

}
