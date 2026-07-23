package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DailougeRepository;
import com.example.demo.tables.Dailouge;

import java.util.List;

@Service
public class DailougeService {

    @Autowired
    private DailougeRepository repository;

    public Dailouge save(Dailouge dailouge) {
        return repository.save(dailouge);
    }

    public Dailouge getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Dailouge> getBySceneId(Long sceneId) {
        return repository.findBySceneId(sceneId);
    }

    public List<Dailouge> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
