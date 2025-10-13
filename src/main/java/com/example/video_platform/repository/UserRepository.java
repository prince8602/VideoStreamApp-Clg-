package com.example.video_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.video_platform.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
