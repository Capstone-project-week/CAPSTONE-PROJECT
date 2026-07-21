package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.StoryDto;
import com.example.demo.repository.StoryRepository;
import com.example.demo.service.LoginService;
import com.example.demo.tables.Login;
import com.example.demo.tables.Story;
import com.example.demo.util.JwtUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/stories")
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtil jwtUtil;

    private Login getAuthenticatedUser(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        try {
            String token = authHeader.substring(7);
            Long userId = jwtUtil.getUserIdFromToken(token);
            if (userId != null) {
                return loginService.getUserById(userId);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<?> getUserStories(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        Login user = getAuthenticatedUser(authHeader);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        List<Story> stories = storyRepository.findByUserId(user.getId());
        List<StoryDto> dtos = stories.stream().map(this::convertToDto).collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @Autowired
    private com.example.demo.service.n8nservice n8nService;

    @PostMapping
    public ResponseEntity<?> createStory(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody StoryDto request) {
        Login user = getAuthenticatedUser(authHeader);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        Story story = new Story();
        story.setTitle(request.getTitle());
        story.setPrompt(request.getPrompt());
        
        String content = request.getContent();
        if (content == null || content.trim().isEmpty()) {
            content = n8nService.generateText(request.getPrompt());
        }
        story.setContent(content);
        
        story.setUser(user);
        story.setCreatedAt(LocalDateTime.now());
        
        Story savedStory = storyRepository.save(story);
        
        return ResponseEntity.ok(convertToDto(savedStory));
    }

    private StoryDto convertToDto(Story story) {
        StoryDto dto = new StoryDto();
        dto.setId(story.getId());
        dto.setTitle(story.getTitle());
        dto.setPrompt(story.getPrompt());
        dto.setContent(story.getContent());
        dto.setCreatedAt(story.getCreatedAt());
        dto.setUserId(story.getUser().getId());
        return dto;
    }
}
