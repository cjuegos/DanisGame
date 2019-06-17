package com.cjuegos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjuegos.entities.NormalQuestion;
import com.cjuegos.repository.NormalQuestionRepository;
import com.cjuegos.service.INormalQuestionService;

@Service
public class NormalQuestionService implements INormalQuestionService {
	
	@Autowired
	private NormalQuestionRepository normalQuestionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<NormalQuestion> findAll() throws Exception {
		return normalQuestionRepository.findAll();
	}

	@Transactional
	@Override
	public NormalQuestion save(NormalQuestion t) throws Exception {
		return normalQuestionRepository.save(t);
	}

	@Transactional
	@Override
	public NormalQuestion update(NormalQuestion t) throws Exception {
		return normalQuestionRepository.save(t);
	}

	@Transactional
	@Override
	public Optional<NormalQuestion> findById(Integer id) throws Exception {
		return normalQuestionRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		normalQuestionRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}

}
