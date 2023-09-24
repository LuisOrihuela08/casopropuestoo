package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AutorEntity;

public interface AutorService {
	
	AutorEntity create (AutorEntity autor);
	AutorEntity update (AutorEntity autor);
	void delete (Long id);
	AutorEntity read (Long id);
	List<AutorEntity> readAll();

}
