package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

}
