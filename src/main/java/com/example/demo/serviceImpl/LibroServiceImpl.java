package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LibroEntity;
import com.example.demo.repository.LibroRepository;
import com.example.demo.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public LibroEntity create(LibroEntity libro) {
		return libroRepository.save(libro);
	}

	@Override
	public LibroEntity update(LibroEntity libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(id);
		
	}

	@Override
	public LibroEntity read(Long id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id).get();
	}

	@Override
	public List<LibroEntity> readAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();
	}
	
}
