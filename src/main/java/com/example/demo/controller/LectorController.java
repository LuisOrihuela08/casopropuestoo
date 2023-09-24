package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LectorEntity;
import com.example.demo.service.LectorService;

import static com.example.demo.commons.GlobalConstans.API_LECTOR;

import java.util.List;

@RestController
@RequestMapping(API_LECTOR)
public class LectorController {

	@Autowired
	private LectorService lectorService;
	
	@GetMapping("/all")
	public List<LectorEntity> listar() {
		return lectorService.readAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LectorEntity> listar2(@PathVariable("id") long id) {
		LectorEntity lector = lectorService.read(id);
		if (lector != null) {
			return new ResponseEntity<>(lector, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/lector")
	public ResponseEntity<LectorEntity> crearLector(@RequestBody LectorEntity le) {
		try {
			LectorEntity lector = lectorService.create(le);
			return new ResponseEntity<LectorEntity>(lector, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/lector/{id}")
	public ResponseEntity<LectorEntity> updateTutorial(@PathVariable("id") long id, @RequestBody LectorEntity lector) {
		LectorEntity le = lectorService.read(id);

		if (le != null) {
			le.setId(lector.getId());
			le.setNombre(lector.getNombre());
			le.setTelefono(lector.getTelefono());
			le.setDireccion(lector.getDireccion());
			le.setCodigo_postal(lector.getCodigo_postal());
			le.setObservaciones(lector.getObservaciones());
			
			return new ResponseEntity<>(lectorService.create(le), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
