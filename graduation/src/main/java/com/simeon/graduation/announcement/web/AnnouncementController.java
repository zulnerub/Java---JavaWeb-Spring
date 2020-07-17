package com.simeon.graduation.announcement.web;

import com.simeon.graduation.announcement.repository.AnnouncementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    //TODO: Role user
    @GetMapping
    public String announcement(Model model){
        model.addAttribute("announcements",
                announcementRepository.findAll());

        return "announcement/announcements";
    }
}
