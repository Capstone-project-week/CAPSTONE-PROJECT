package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.StoryoutlineRepository;
import com.example.demo.tables.Storyoutline;

import java.util.List;

@Service
public class StoryoutlineService {

    @Autowired
    private StoryoutlineRepository repository;

    public Storyoutline save(Storyoutline storyoutline) {
        return repository.save(storyoutline);
    }

    public Storyoutline getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Storyoutline> getByStoryId(Long storyId) {
        return repository.findByStoryId(storyId);
    }

    public List<Storyoutline> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
