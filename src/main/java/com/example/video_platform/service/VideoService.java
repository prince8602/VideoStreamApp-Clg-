package com.example.video_platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional; // <-- जरूर जोड़ें
import com.example.video_platform.Video;
import com.example.video_platform.repository.VideoRepository;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    
    
    
    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }
    
    
    
    
    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }
    
    
    
    
    public Video updateVideo(Long id, Video newVideoData) {
        return videoRepository.findById(id)
                .map(video -> {
                    video.setTitle(newVideoData.getTitle());
                    video.setUrl(newVideoData.getUrl());
                    return videoRepository.save(video);
                })
                .orElseGet(() -> {
                    newVideoData.setId(id);
                    return videoRepository.save(newVideoData);
                });
    }
    
    
    
    
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
    
    
    
}