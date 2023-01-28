package com.example.simulator.repository;

import com.example.simulator.model.Simulator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SimulatorRepository extends JpaRepository<Simulator,Integer> {
    Optional<Simulator> findByEmpCode(String empCode);

}
