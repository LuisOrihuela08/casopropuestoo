package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public CategoriaEntity create(CategoriaEntity categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
	}

	@Override
	public CategoriaEntity update(CategoriaEntity categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(id);
	}

	@Override
	public CategoriaEntity read(Long id) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(id).get();
	}

	@Override
	public List<CategoriaEntity> readAll() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	
}
