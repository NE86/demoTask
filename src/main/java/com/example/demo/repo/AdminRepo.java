package com.example.demo.repo;

import com.example.demo.domain.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminInfo, Long> {
}

