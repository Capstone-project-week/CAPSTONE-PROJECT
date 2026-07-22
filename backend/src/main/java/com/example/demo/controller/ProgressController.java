package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ProgressService;
import com.example.demo.tables.Progress;

import java.util.List;

@RestController
@RequestMapping("/api/v1/progresses")
public class ProgressController {

    @Autowired
    private ProgressService service;

    @PostMapping
    public ResponseEntity<Progress> create(@RequestBody Progress progress) {
        return ResponseEntity.ok(service.save(progress));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progress> getById(@PathVariable Long id) {
        Progress progress = service.getById(id);
        return progress != null ? ResponseEntity.ok(progress) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Progress>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity<List<Progress>> getByStoryId(@PathVariable Long storyId) {
        return ResponseEntity.ok(service.getByStoryId(storyId));
    }

    @GetMapping
    public ResponseEntity<List<Progress>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
