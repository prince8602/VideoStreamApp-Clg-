package com.example.video_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.video_platform.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
   
}
