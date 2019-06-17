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

import com.cjuegos.entities.SesionDanisGameQuestion;
import com.cjuegos.service.impl.SesionDanisGameQuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sesionsdanisgamequestions")
@Api(value = "REST información de sesions de danis quetions")
public class SesionDanisGameQuestionController {

	@Autowired
	private SesionDanisGameQuestionService sesionDanisGameQuestionService;

	@ApiOperation("Lista de estudiantes")
	@GetMapping(value = "/{id}/state/{state}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SesionDanisGameQuestion>> fetchBySesionAndState(@PathVariable("id") Integer id, @PathVariable("state") boolean state) {
		try {
			List<SesionDanisGameQuestion> students = new ArrayList<>();
			students = sesionDanisGameQuestionService.fetchBySesionAndState(id,state);
			return new ResponseEntity<List<SesionDanisGameQuestion>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SesionDanisGameQuestion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Lista de estudiantes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SesionDanisGameQuestion>> fetchStudents() {
		try {
			List<SesionDanisGameQuestion> students = new ArrayList<>();
			students = sesionDanisGameQuestionService.findAll();
			return new ResponseEntity<List<SesionDanisGameQuestion>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SesionDanisGameQuestion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener estudiante por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SesionDanisGameQuestion> fetchStudent(@PathVariable("id") Integer id) {

		try {
			Optional<SesionDanisGameQuestion> student = sesionDanisGameQuestionService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<SesionDanisGameQuestion>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<SesionDanisGameQuestion>(student.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SesionDanisGameQuestion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Guardar estudiantes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody SesionDanisGameQuestion student) {
		try {
			SesionDanisGameQuestion s = new SesionDanisGameQuestion();
			s = sesionDanisGameQuestionService.save(student);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Actualizar estudiantes")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody SesionDanisGameQuestion student) {
		try {
			sesionDanisGameQuestionService.update(student);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Borrar estudiante")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<SesionDanisGameQuestion> student = sesionDanisGameQuestionService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				sesionDanisGameQuestionService.deleteById(id);
				return new ResponseEntity<>("Signo se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
