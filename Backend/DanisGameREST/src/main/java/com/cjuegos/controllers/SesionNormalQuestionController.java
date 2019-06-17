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

import com.cjuegos.entities.SesionNormalQuestion;
import com.cjuegos.service.impl.SesionNormalQuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sesionsnormalquestions")
@Api(value = "REST información de sesions de normal questions")
public class SesionNormalQuestionController {
	@Autowired
	private SesionNormalQuestionService sesionNormalQuestionService;

	@ApiOperation("Lista de estudiantes")
	@GetMapping(value = "/{id}/state/{state}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SesionNormalQuestion>> fetchBySesionAndState(@PathVariable("id") Integer id, @PathVariable("state") boolean state) {
		try {
			List<SesionNormalQuestion> students = new ArrayList<>();
			students = sesionNormalQuestionService.fetchBySesionAndState(id,state);
			return new ResponseEntity<List<SesionNormalQuestion>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SesionNormalQuestion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Lista de estudiantes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SesionNormalQuestion>> fetchStudents() {
		try {
			List<SesionNormalQuestion> students = new ArrayList<>();
			students = sesionNormalQuestionService.findAll();
			return new ResponseEntity<List<SesionNormalQuestion>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SesionNormalQuestion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener estudiante por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SesionNormalQuestion> fetchStudent(@PathVariable("id") Integer id) {

		try {
			Optional<SesionNormalQuestion> student = sesionNormalQuestionService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<SesionNormalQuestion>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<SesionNormalQuestion>(student.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SesionNormalQuestion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Guardar estudiantes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody SesionNormalQuestion student) {
		try {
			SesionNormalQuestion s = new SesionNormalQuestion();
			s = sesionNormalQuestionService.save(student);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Actualizar estudiantes")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody SesionNormalQuestion student) {
		try {
			sesionNormalQuestionService.update(student);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Borrar estudiante")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<SesionNormalQuestion> student = sesionNormalQuestionService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				sesionNormalQuestionService.deleteById(id);
				return new ResponseEntity<>("Signo se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
