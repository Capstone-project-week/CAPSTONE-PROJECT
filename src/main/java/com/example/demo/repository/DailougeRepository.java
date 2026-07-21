package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.tables.Dailouge;
import java.util.List;

@Repository
public interface DailougeRepository extends JpaRepository<Dailouge, Long> {
    List<Dailouge> findBySceneId(Long sceneId);
}
