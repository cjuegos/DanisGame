package com.cjuegos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjuegos.entities.SesionPlayer;
import com.cjuegos.repository.SesionPlayerRepository;
import com.cjuegos.service.ISesionPlayerService;

@Service
public class SesionPlayerService implements ISesionPlayerService {

	@Autowired
	private SesionPlayerRepository sesionPlayerRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<SesionPlayer> findAll() throws Exception {
		return sesionPlayerRepository.findAll();
	}

	@Transactional
	@Override
	public SesionPlayer save(SesionPlayer t) throws Exception {
		return sesionPlayerRepository.save(t);
	}

	@Transactional
	@Override
	public SesionPlayer update(SesionPlayer t) throws Exception {
		return sesionPlayerRepository.save(t);
	}

	@Transactional
	@Override
	public Optional<SesionPlayer> findById(Integer id) throws Exception {
		return sesionPlayerRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		sesionPlayerRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}
	
}
