package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CommunityRepository;
import com.example.demo.tables.Community;

import java.util.List;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository repository;

    public Community save(Community community) {
        return repository.save(community);
    }

    public Community getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Community> getByStoryId(Long storyId) {
        return repository.findByStoryId(storyId);
    }

    public List<Community> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Community> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
