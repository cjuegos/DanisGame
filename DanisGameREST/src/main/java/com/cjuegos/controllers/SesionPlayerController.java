package com.cjuegos.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cjuegos.entities.Player;
import com.cjuegos.entities.SesionPlayer;
import com.cjuegos.service.impl.SesionPlayerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sesionsplayers")
@Api(value = "REST información de sesions players")
public class SesionPlayerController {

	@Autowired
	private SesionPlayerService sesionPlayerService;
	
	@ApiOperation("Lista de estudiantes")
	@GetMapping(value = "/sesion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SesionPlayer>> fetchBySesionAndState(@PathVariable("id") Integer id) {
		try {
			List<SesionPlayer> students = new ArrayList<>();
			students = sesionPlayerService.fetchBySesion(id);
			return new ResponseEntity<List<SesionPlayer>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SesionPlayer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Lista de estudiantes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SesionPlayer>> fetchStudents() {
		try {
			List<SesionPlayer> students = new ArrayList<>();
			students = sesionPlayerService.findAll();
			return new ResponseEntity<List<SesionPlayer>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SesionPlayer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener estudiante por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SesionPlayer> fetchStudent(@PathVariable("id") Integer id) {

		try {
			Optional<SesionPlayer> student = sesionPlayerService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<SesionPlayer>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<SesionPlayer>(student.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SesionPlayer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Guardar estudiantes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody SesionPlayer student) {
		try {
			SesionPlayer s = new SesionPlayer();
			s = sesionPlayerService.save(student);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Actualizar estudiantes")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody SesionPlayer student) {
		try {
			sesionPlayerService.update(student);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Borrar estudiante")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<SesionPlayer> student = sesionPlayerService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				sesionPlayerService.deleteById(id);
				return new ResponseEntity<>("Signo se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
