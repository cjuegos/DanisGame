package com.cjuegos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjuegos.entities.DanisGameQuestion;
import com.cjuegos.service.impl.DanisGameQuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/danisgamequestions")
@Api(value = "REST información de preguntas de dani")
public class DanisGameQuestionController {

	@Autowired
	private DanisGameQuestionService danisGameQuestionService;
	
	@ApiOperation("Lista de estudiantes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DanisGameQuestion>> fetchStudents() {
		try {
			List<DanisGameQuestion> students = new ArrayList<>();
			students = danisGameQuestionService.findAll();
			return new ResponseEntity<List<DanisGameQuestion>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<DanisGameQuestion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener estudiante por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DanisGameQuestion> fetchStudent(@PathVariable("id") Integer id) {

		try {
			Optional<DanisGameQuestion> student = danisGameQuestionService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<DanisGameQuestion>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<DanisGameQuestion>(student.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DanisGameQuestion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
