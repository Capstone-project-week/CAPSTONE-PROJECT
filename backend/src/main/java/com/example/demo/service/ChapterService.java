package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ChapterRepository;
import com.example.demo.tables.Chapter;

import java.util.List;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepository repository;

    public Chapter save(Chapter chapter) {
        return repository.save(chapter);
    }

    public Chapter getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Chapter> getByStoryId(Long storyId) {
        return repository.findByStoryId(storyId);
    }

    public List<Chapter> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
