package com.example.demo.tables;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Story {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String prompt;
    
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Login user;
    
    private LocalDateTime createdAt = LocalDateTime.now();

    public Story() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Login getUser() { return user; }
    public void setUser(Login user) { this.user = user; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
