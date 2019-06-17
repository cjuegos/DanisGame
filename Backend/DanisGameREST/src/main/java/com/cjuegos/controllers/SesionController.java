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

import com.cjuegos.entities.Sesion;
import com.cjuegos.service.impl.SesionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sesions")
@Api(value = "REST información de sesions")
public class SesionController {

	@Autowired
	private SesionService sesionService;
	
	@ApiOperation("Lista de estudiantes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sesion>> fetchStudents() {
		try {
			List<Sesion> students = new ArrayList<>();
			students = sesionService.findAll();
			return new ResponseEntity<List<Sesion>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Sesion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener estudiante por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sesion> fetchStudent(@PathVariable("id") Integer id) {

		try {
			Optional<Sesion> student = sesionService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<Sesion>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Sesion>(student.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Sesion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
