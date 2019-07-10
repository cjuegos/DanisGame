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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cjuegos.entities.Player;
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
	
	@ApiOperation("List sesions")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sesion>> fetchSesions() {
		try {
			List<Sesion> sesions = new ArrayList<>();
			sesions = sesionService.findAll();
			return new ResponseEntity<List<Sesion>>(sesions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Sesion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Get sesion by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sesion> fetchSesion(@PathVariable("id") Integer id) {

		try {
			Optional<Sesion> sesion = sesionService.findById(id);

			if (!sesion.isPresent()) {
				return new ResponseEntity<Sesion>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Sesion>(sesion.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Sesion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Get top sesion")
	@GetMapping(value = "/top", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sesion> fetchTopSesion() {

		try {
			Sesion sesion = sesionService.findTopByOrderByIdDesc();
			return new ResponseEntity<Sesion>(sesion, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Sesion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save sesion")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Sesion sesion) {
		try {
			Sesion s = new Sesion();
			s = sesionService.save(sesion);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
