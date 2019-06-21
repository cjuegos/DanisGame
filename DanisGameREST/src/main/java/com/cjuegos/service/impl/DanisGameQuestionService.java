package com.cjuegos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjuegos.entities.DanisGameQuestion;
import com.cjuegos.repository.DanisGameQuestionRepository;
import com.cjuegos.service.IDanisGameQuestionService;

@Service
public class DanisGameQuestionService implements IDanisGameQuestionService {

	@Autowired
	private DanisGameQuestionRepository danisGameQuestionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<DanisGameQuestion> findAll() throws Exception {
		return danisGameQuestionRepository.findAll();
	}

	@Transactional
	@Override
	public DanisGameQuestion save(DanisGameQuestion t) throws Exception {
		return danisGameQuestionRepository.save(t);
	}

	@Transactional
	@Override
	public DanisGameQuestion update(DanisGameQuestion t) throws Exception {
		return danisGameQuestionRepository.save(t);
	}

	@Transactional
	@Override
	public Optional<DanisGameQuestion> findById(Integer id) throws Exception {
		return danisGameQuestionRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		danisGameQuestionRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}

}
