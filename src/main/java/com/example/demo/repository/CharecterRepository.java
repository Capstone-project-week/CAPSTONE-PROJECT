package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.tables.Charecter;
import java.util.List;

@Repository
public interface CharecterRepository extends JpaRepository<Charecter, Long> {
    List<Charecter> findByStoryId(Long storyId);
}
