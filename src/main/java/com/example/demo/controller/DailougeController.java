package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.DailougeService;
import com.example.demo.tables.Dailouge;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dailouges")
public class DailougeController {

    @Autowired
    private DailougeService service;

    @PostMapping
    public ResponseEntity<Dailouge> create(@RequestBody Dailouge dailouge) {
        return ResponseEntity.ok(service.save(dailouge));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dailouge> getById(@PathVariable Long id) {
        Dailouge dailouge = service.getById(id);
        return dailouge != null ? ResponseEntity.ok(dailouge) : ResponseEntity.notFound().build();
    }

    @GetMapping("/scene/{sceneId}")
    public ResponseEntity<List<Dailouge>> getBySceneId(@PathVariable Long sceneId) {
        return ResponseEntity.ok(service.getBySceneId(sceneId));
    }

    @GetMapping
    public ResponseEntity<List<Dailouge>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
