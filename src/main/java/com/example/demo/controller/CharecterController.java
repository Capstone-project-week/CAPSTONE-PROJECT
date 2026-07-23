package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CharecterService;
import com.example.demo.tables.Charecter;

import java.util.List;

@RestController
@RequestMapping("/api/v1/charecters")
public class CharecterController {

    @Autowired
    private CharecterService service;

    @PostMapping
    public ResponseEntity<Charecter> create(@RequestBody Charecter charecter) {
        return ResponseEntity.ok(service.save(charecter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Charecter> getById(@PathVariable Long id) {
        Charecter charecter = service.getById(id);
        return charecter != null ? ResponseEntity.ok(charecter) : ResponseEntity.notFound().build();
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity<List<Charecter>> getByStoryId(@PathVariable Long storyId) {
        return ResponseEntity.ok(service.getByStoryId(storyId));
    }

    @GetMapping
    public ResponseEntity<List<Charecter>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
