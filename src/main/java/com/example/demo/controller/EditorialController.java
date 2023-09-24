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

import com.example.demo.entity.EditorialEntity;
import com.example.demo.service.EditorialService;

import static com.example.demo.commons.GlobalConstans.API_EDITORIAL;

import java.util.List;

@RestController
@RequestMapping(API_EDITORIAL)
public class EditorialController {

	@Autowired
	private EditorialService editorialService;

	@GetMapping("/all")
	public List<EditorialEntity> listar() {
		return editorialService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EditorialEntity> listar2(@PathVariable("id") long id) {
		EditorialEntity editorial = editorialService.read(id);
		if (editorial != null) {
			return new ResponseEntity<>(editorial, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/editorial")
	public ResponseEntity<EditorialEntity> crearEditorial(@RequestBody EditorialEntity ed) {
		try {
			EditorialEntity editorial = editorialService.create(ed);
			return new ResponseEntity<EditorialEntity>(editorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/editorial/{id}")
	public ResponseEntity<EditorialEntity> updateTutorial(@PathVariable("id") long id,
			@RequestBody EditorialEntity editorial) {
		EditorialEntity ed = editorialService.read(id);

		if (ed != null) {
			ed.setId(editorial.getId());
			ed.setEditorial(editorial.getEditorial());

			return new ResponseEntity<>(editorialService.create(ed), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/editorial/{id}")
	public ResponseEntity<HttpStatus> deleteEditorial(@PathVariable("id") long id) {
		try {
			editorialService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
