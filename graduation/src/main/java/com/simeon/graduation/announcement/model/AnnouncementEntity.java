package com.simeon.graduation.announcement.model;

import com.simeon.graduation.users.model.UserEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "announcements")
public class AnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private Instant createdOn;

    @NotNull
    @Column
    private Instant updatedOn;

    @NotNull
    @Column
    private String title;

    @NotNull
    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public AnnouncementEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public AnnouncementEntity setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public AnnouncementEntity setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AnnouncementEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AnnouncementEntity setDescription(String description) {
        this.description = description;
        return this;
    }

}
