package com.example.video_platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;            // <-- जरूरी
import java.util.List;
import com.example.video_platform.Video;
import com.example.video_platform.service.VideoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.video_platform.Video;
import com.example.video_platform.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    // GET /videos - सभी वीडियो लाने के लिए
    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    // POST /videos - नया वीडियो बनाने के लिए
    @PostMapping
    public Video createVideo(@RequestBody Video video) {
        return videoService.createVideo(video);
    }

    
    
    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video) {
        Video updatedVideo = videoService.updateVideo(id, video);
        return ResponseEntity.ok(updatedVideo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }

}
