package com.example.demo.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long storyId;
    private String format;
    private LocalDateTime downloadDate;

    public Download() {
        super();
        this.downloadDate = LocalDateTime.now();
    }

    public Download(Long id, Long userId, Long storyId, String format, LocalDateTime downloadDate) {
        super();
        this.id = id;
        this.userId = userId;
        this.storyId = storyId;
        this.format = format;
        this.downloadDate = downloadDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public LocalDateTime getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(LocalDateTime downloadDate) {
        this.downloadDate = downloadDate;
    }
}
