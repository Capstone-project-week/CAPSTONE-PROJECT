package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.tables.Download;
import java.util.List;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Long> {
    List<Download> findByUserId(Long userId);
    List<Download> findByStoryId(Long storyId);
}
