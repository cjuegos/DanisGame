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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cjuegos.entities.Player;
import com.cjuegos.service.impl.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/players")
@Api(value = "REST información de players")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@ApiOperation("Obtener jugador con menor preguntas")
	@GetMapping(value = "/menor", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Player> findBottomByOrderByQuestionsDesc() {

		try {
			Player student = playerService.findBottomByOrderByQuestionsDesc();
			return new ResponseEntity<Player>(student, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Lista de estudiantes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Player>> fetchStudents() {
		try {
			List<Player> students = new ArrayList<>();
			students = playerService.findAll();
			return new ResponseEntity<List<Player>>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Player>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Guardar estudiantes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Player student) {
		try {
			Player s = new Player();
			s = playerService.save(student);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation("Borrar estudiante")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Player> student = playerService.findById(id);

			if (!student.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				playerService.deleteById(id);
				return new ResponseEntity<>("Signo se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
