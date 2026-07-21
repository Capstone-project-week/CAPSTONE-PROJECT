package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.tables.Story;
import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findByUserId(Long userId);
}
