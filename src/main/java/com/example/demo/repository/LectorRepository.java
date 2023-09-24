package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LectorEntity;

public interface LectorRepository extends JpaRepository<LectorEntity, Long> {

}
