package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.tables.Progress;
import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByUserId(Long userId);
    List<Progress> findByStoryId(Long storyId);
}
