package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CategoriaEntity;

public interface CategoriaService {

	CategoriaEntity create (CategoriaEntity categoria);
	CategoriaEntity update (CategoriaEntity categoria);
	void delete (Long id);
	CategoriaEntity read (Long id);
	List<CategoriaEntity> readAll();
}
