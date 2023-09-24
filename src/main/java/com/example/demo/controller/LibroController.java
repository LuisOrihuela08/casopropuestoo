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

import com.example.demo.service.LibroService;
import com.example.demo.entity.LibroEntity;

import static com.example.demo.commons.GlobalConstans.API_LIBRO;

import java.util.List;;

@RestController
@RequestMapping(API_LIBRO)
public class LibroController {

	@Autowired
	private LibroService libroService;

	@GetMapping("/all")
	public List<LibroEntity> listar() {
		return libroService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<LibroEntity> listar2(@PathVariable("id") long id) {
		LibroEntity libro = libroService.read(id);
		if (libro != null) {
			return new ResponseEntity<>(libro, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/libro")
	public ResponseEntity<LibroEntity> crearLibro(@RequestBody LibroEntity l) {
		try {
			LibroEntity libro = libroService.create(l);
			return new ResponseEntity<LibroEntity>(libro, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/libro/{id}")
	public ResponseEntity<LibroEntity> updateTutorial(@PathVariable("id") long id, @RequestBody LibroEntity libro) {
		LibroEntity lib = libroService.read(id);

		if (lib != null) {
			lib.setId(libro.getId());
			lib.setTitulo(libro.getTitulo());
			lib.setFecha_lanzamiento(libro.getFecha_lanzamiento());
			lib.setIdioma(libro.getIdioma());
			lib.setPaginas(libro.getPaginas());
			lib.setDescripcion(libro.getDescripcion());
			lib.setPortada(libro.getPortada());
			return new ResponseEntity<>(libroService.create(lib), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/libro/{id}")
	public ResponseEntity<HttpStatus> deleteLibro(@PathVariable("id") long id) {
		try {
			libroService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
