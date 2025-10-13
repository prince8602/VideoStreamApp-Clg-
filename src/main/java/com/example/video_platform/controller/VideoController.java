package com.example.video_platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    // आप जरूरत अनुसार अन्य CRUD ऑपरेशन भी जोड़ सकते हैं
}
