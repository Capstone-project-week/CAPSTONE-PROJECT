package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.tables.Progress;

import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository repository;

    public Progress save(Progress progress) {
        return repository.save(progress);
    }

    public Progress getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Progress> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
    
    public List<Progress> getByStoryId(Long storyId) {
        return repository.findByStoryId(storyId);
    }

    public List<Progress> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
