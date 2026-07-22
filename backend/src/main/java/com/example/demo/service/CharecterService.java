package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CharecterRepository;
import com.example.demo.tables.Charecter;

import java.util.List;

@Service
public class CharecterService {

    @Autowired
    private CharecterRepository repository;

    public Charecter save(Charecter charecter) {
        return repository.save(charecter);
    }

    public Charecter getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Charecter> getByStoryId(Long storyId) {
        return repository.findByStoryId(storyId);
    }

    public List<Charecter> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
