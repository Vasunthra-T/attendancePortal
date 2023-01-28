package com.example.simulator.repository;

import com.example.simulator.model.Hours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursRepository extends JpaRepository<Hours,Integer> {
}
