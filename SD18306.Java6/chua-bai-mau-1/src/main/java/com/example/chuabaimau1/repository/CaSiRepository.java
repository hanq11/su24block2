package com.example.chuabaimau1.repository;

import com.example.chuabaimau1.entity.CaSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaSiRepository extends JpaRepository<CaSi, Integer> {
}
