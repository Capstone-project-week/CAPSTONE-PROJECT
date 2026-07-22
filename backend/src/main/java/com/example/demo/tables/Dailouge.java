package com.example.demo.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dailouge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sceneId;
    private Long charecterId;
    private String text;

    public Dailouge() {
        super();
    }

    public Dailouge(Long id, Long sceneId, Long charecterId, String text) {
        super();
        this.id = id;
        this.sceneId = sceneId;
        this.charecterId = charecterId;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public Long getCharecterId() {
        return charecterId;
    }

    public void setCharecterId(Long charecterId) {
        this.charecterId = charecterId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
