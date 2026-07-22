package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DownloadRepository;
import com.example.demo.tables.Download;

import java.util.List;

@Service
public class DownloadService {

    @Autowired
    private DownloadRepository repository;

    public Download save(Download download) {
        return repository.save(download);
    }

    public Download getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Download> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Download> getByStoryId(Long storyId) {
        return repository.findByStoryId(storyId);
    }

    public List<Download> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
