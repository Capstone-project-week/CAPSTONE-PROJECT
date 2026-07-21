package com.example.demo.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Storyoutline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long storyId;
    
    @Column(columnDefinition = "TEXT")
    private String outlineText;

    public Storyoutline() {
        super();
    }

    public Storyoutline(Long id, Long storyId, String outlineText) {
        super();
        this.id = id;
        this.storyId = storyId;
        this.outlineText = outlineText;
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

    public String getOutlineText() {
        return outlineText;
    }

    public void setOutlineText(String outlineText) {
        this.outlineText = outlineText;
    }
}
