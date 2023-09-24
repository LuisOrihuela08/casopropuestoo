package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CategoriaService;
import com.example.demo.entity.CategoriaEntity;

import static com.example.demo.commons.GlobalConstans.API_CATEGORIA;

import java.util.List;

@RestController
@RequestMapping(API_CATEGORIA)
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/all")
	public List<CategoriaEntity> listar() {
		return categoriaService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaEntity> listar2(@PathVariable("id") long id) {
		CategoriaEntity categoria = categoriaService.read(id);
		if (categoria != null) {
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/categoria")
	public ResponseEntity<CategoriaEntity> crearCategoria(@RequestBody CategoriaEntity c) {
		try {
			CategoriaEntity categoria = categoriaService.create(c);
			return new ResponseEntity<CategoriaEntity>(categoria, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/categoria/{id}")
	public ResponseEntity<CategoriaEntity> updateTutorial(@PathVariable("id") long id,
			@RequestBody CategoriaEntity categoria) {
		CategoriaEntity cat = categoriaService.read(id);

		if (cat != null) {
			cat.setId(categoria.getId());
			cat.setCategoria(categoria.getCategoria());
			return new ResponseEntity<>(categoriaService.create(cat), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable("id") long id) {
		try {
			categoriaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
