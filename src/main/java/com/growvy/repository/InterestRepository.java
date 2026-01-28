package com.growvy.repository;

import com.growvy.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    // 이름으로 관심사 조회
    Optional<Interest> findByName(String name);
}
