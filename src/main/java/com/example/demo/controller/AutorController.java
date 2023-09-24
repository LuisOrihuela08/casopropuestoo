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

import com.example.demo.entity.AutorEntity;
import com.example.demo.service.AutorService;

import static com.example.demo.commons.GlobalConstans.API_AUTOR;

import java.util.List;

@RestController
@RequestMapping(API_AUTOR)
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@GetMapping("/all")
	public List<AutorEntity> listar() {
		return autorService.readAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutorEntity> listar2(@PathVariable("id") long id) {
		AutorEntity autor = autorService.read(id);
		if (autor != null) {
			return new ResponseEntity<>(autor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/autor")
	public ResponseEntity<AutorEntity> crearAutor(@RequestBody AutorEntity a) {
		try {
		AutorEntity autor = autorService.create(a);
			return new ResponseEntity<AutorEntity>(autor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/autor/{id}")
	public ResponseEntity<AutorEntity> updateTutorial(@PathVariable("id") long id, @RequestBody AutorEntity autor) {
		AutorEntity au = autorService.read(id);

		if (au != null) {
			au.setId(autor.getId());
			au.setAutor(autor.getAutor());
						return new ResponseEntity<>(autorService.create(au), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/autor/{id}")
	public ResponseEntity<HttpStatus> deleteAutor(@PathVariable("id") long id) {
		try {
			autorService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
