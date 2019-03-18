package com.example.demo.repo;

import com.example.demo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserInfo, Long> {
}
