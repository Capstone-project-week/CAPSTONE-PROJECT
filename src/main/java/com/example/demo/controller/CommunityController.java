package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CommunityService;
import com.example.demo.tables.Community;

import java.util.List;

@RestController
@RequestMapping("/api/v1/community")
public class CommunityController {

    @Autowired
    private CommunityService service;

    @PostMapping
    public ResponseEntity<Community> create(@RequestBody Community community) {
        return ResponseEntity.ok(service.save(community));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Community> getById(@PathVariable Long id) {
        Community community = service.getById(id);
        return community != null ? ResponseEntity.ok(community) : ResponseEntity.notFound().build();
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity<List<Community>> getByStoryId(@PathVariable Long storyId) {
        return ResponseEntity.ok(service.getByStoryId(storyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Community>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<Community>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
