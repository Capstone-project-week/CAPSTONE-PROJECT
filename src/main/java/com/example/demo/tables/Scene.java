package com.example.demo.tables;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Scene {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String chapter;
private String description;
private String imageUrl;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getChapter() {
    return chapter;
}

public void setChapter(String chapter) {
    this.chapter = chapter;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getImageUrl() {
    return imageUrl;
}

public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
}

}
