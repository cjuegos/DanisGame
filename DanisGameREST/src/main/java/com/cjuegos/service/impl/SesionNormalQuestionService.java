package com.cjuegos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjuegos.entities.SesionNormalQuestion;
import com.cjuegos.repository.SesionNormalQuestionRepository;
import com.cjuegos.service.ISesionNormalQuestionService;
@Service
public class SesionNormalQuestionService implements ISesionNormalQuestionService {

	@Autowired
	private SesionNormalQuestionRepository sesionNormalQuestionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<SesionNormalQuestion> findAll() throws Exception {
		return sesionNormalQuestionRepository.findAll();
	}

	@Transactional
	@Override
	public SesionNormalQuestion save(SesionNormalQuestion t) throws Exception {
		return sesionNormalQuestionRepository.save(t);
	}

	@Transactional
	@Override
	public SesionNormalQuestion update(SesionNormalQuestion t) throws Exception {
		return sesionNormalQuestionRepository.save(t);
	}

	@Transactional
	@Override
	public Optional<SesionNormalQuestion> findById(Integer id) throws Exception {
		return sesionNormalQuestionRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		sesionNormalQuestionRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public List<SesionNormalQuestion> fetchBySesionAndState(int id, boolean state) throws Exception {
		// TODO Auto-generated method stub
		return sesionNormalQuestionRepository.fetchBySesionAndState(id, state);
	}
	
}