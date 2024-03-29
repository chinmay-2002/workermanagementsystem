package net.chinmay.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.chinmay.springboot.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

	
}
