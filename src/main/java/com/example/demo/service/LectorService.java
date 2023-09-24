package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LectorEntity;

public interface LectorService {

	
	LectorEntity create (LectorEntity lector);
	LectorEntity update (LectorEntity lector);
	void delete (Long id);
	LectorEntity read (Long id);
	List<LectorEntity> readAll();
}
