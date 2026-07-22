package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.tables.Storyoutline;
import java.util.List;

@Repository
public interface StoryoutlineRepository extends JpaRepository<Storyoutline, Long> {
    List<Storyoutline> findByStoryId(Long storyId);
}
