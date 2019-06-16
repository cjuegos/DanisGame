package com.cjuegos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjuegos.entities.SesionDanisGameQuestion;
import com.cjuegos.repository.SesionDanisGameQuestionRepository;
import com.cjuegos.service.ISesionDanisGameQuestionService;
@Service
public class SesionDanisGameQuestionService implements ISesionDanisGameQuestionService {

	@Autowired
	private SesionDanisGameQuestionRepository sesionDanisGameQuestionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<SesionDanisGameQuestion> findAll() throws Exception {
		return sesionDanisGameQuestionRepository.findAll();
	}

	@Transactional
	@Override
	public SesionDanisGameQuestion save(SesionDanisGameQuestion t) throws Exception {
		return sesionDanisGameQuestionRepository.save(t);
	}

	@Transactional
	@Override
	public SesionDanisGameQuestion update(SesionDanisGameQuestion t) throws Exception {
		return sesionDanisGameQuestionRepository.save(t);
	}

	@Transactional
	@Override
	public Optional<SesionDanisGameQuestion> findById(Integer id) throws Exception {
		return sesionDanisGameQuestionRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		sesionDanisGameQuestionRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}
	
}