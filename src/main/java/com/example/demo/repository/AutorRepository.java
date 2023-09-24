package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AutorEntity;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

}
