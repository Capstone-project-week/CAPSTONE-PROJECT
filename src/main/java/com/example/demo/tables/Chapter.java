package com.example.demo.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long storyId;
    private String title;
    private String content;

    public Chapter() {
        super();
    }

    public Chapter(Long id, Long storyId, String title, String content) {
        super();
        this.id = id;
        this.storyId = storyId;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
