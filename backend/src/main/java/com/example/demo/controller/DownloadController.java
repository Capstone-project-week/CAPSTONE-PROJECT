package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.DownloadService;
import com.example.demo.tables.Download;

import java.util.List;

@RestController
@RequestMapping("/api/v1/downloads")
public class DownloadController {

    @Autowired
    private DownloadService service;

    @PostMapping
    public ResponseEntity<Download> create(@RequestBody Download download) {
        return ResponseEntity.ok(service.save(download));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Download> getById(@PathVariable Long id) {
        Download download = service.getById(id);
        return download != null ? ResponseEntity.ok(download) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Download>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity<List<Download>> getByStoryId(@PathVariable Long storyId) {
        return ResponseEntity.ok(service.getByStoryId(storyId));
    }

    @GetMapping
    public ResponseEntity<List<Download>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
