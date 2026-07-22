package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ChapterService;
import com.example.demo.tables.Chapter;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chapters")
public class ChapterController {

    @Autowired
    private ChapterService service;

    @PostMapping
    public ResponseEntity<Chapter> create(@RequestBody Chapter chapter) {
        return ResponseEntity.ok(service.save(chapter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> getById(@PathVariable Long id) {
        Chapter chapter = service.getById(id);
        return chapter != null ? ResponseEntity.ok(chapter) : ResponseEntity.notFound().build();
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity<List<Chapter>> getByStoryId(@PathVariable Long storyId) {
        return ResponseEntity.ok(service.getByStoryId(storyId));
    }

    @GetMapping
    public ResponseEntity<List<Chapter>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
