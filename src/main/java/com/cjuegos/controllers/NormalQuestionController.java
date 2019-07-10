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

import com.cjuegos.entities.NormalQuestion;
import com.cjuegos.service.impl.NormalQuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/normalquestions")
@Api(value = "REST información de preguntas normal")
public class NormalQuestionController {
	@Autowired
	private NormalQuestionService normalQuestionService;
	
	@ApiOperation("List questions")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NormalQuestion>> fetchQuestions() {
		try {
			List<NormalQuestion> questions = new ArrayList<>();
			questions = normalQuestionService.findAll();
			return new ResponseEntity<List<NormalQuestion>>(questions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<NormalQuestion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Get question by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NormalQuestion> fetchQuestion(@PathVariable("id") Integer id) {

		try {
			Optional<NormalQuestion> question = normalQuestionService.findById(id);

			if (!question.isPresent()) {
				return new ResponseEntity<NormalQuestion>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<NormalQuestion>(question.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<NormalQuestion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
