package com.leo.rhworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.rhworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
