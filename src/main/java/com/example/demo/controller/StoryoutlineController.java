package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.StoryoutlineService;
import com.example.demo.tables.Storyoutline;

import java.util.List;

@RestController
@RequestMapping("/api/v1/storyoutlines")
public class StoryoutlineController {

    @Autowired
    private StoryoutlineService service;

    @PostMapping
    public ResponseEntity<Storyoutline> create(@RequestBody Storyoutline storyoutline) {
        return ResponseEntity.ok(service.save(storyoutline));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Storyoutline> getById(@PathVariable Long id) {
        Storyoutline storyoutline = service.getById(id);
        return storyoutline != null ? ResponseEntity.ok(storyoutline) : ResponseEntity.notFound().build();
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity<List<Storyoutline>> getByStoryId(@PathVariable Long storyId) {
        return ResponseEntity.ok(service.getByStoryId(storyId));
    }

    @GetMapping
    public ResponseEntity<List<Storyoutline>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
