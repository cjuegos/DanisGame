package com.cjuegos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjuegos.entities.Sesion;
import com.cjuegos.repository.SesionRepository;
import com.cjuegos.service.ISesionService;
@Service
public class SesionService implements ISesionService {

	@Autowired
	private SesionRepository sesionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Sesion> findAll() throws Exception {
		return sesionRepository.findAll();
	}

	@Transactional
	@Override
	public Sesion save(Sesion t) throws Exception {
		return sesionRepository.save(t);
	}

	@Transactional
	@Override
	public Sesion update(Sesion t) throws Exception {
		return sesionRepository.save(t);
	}

	@Transactional
	@Override
	public Optional<Sesion> findById(Integer id) throws Exception {
		return sesionRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		sesionRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}
	
}