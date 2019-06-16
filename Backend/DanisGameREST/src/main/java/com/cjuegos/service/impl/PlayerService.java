package com.cjuegos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjuegos.entities.Player;
import com.cjuegos.repository.PlayerRepository;
import com.cjuegos.service.IPlayerService;
@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Player> findAll() throws Exception {
		return playerRepository.findAll();
	}

	@Transactional
	@Override
	public Player save(Player t) throws Exception {
		return playerRepository.save(t);
	}

	@Transactional
	@Override
	public Player update(Player t) throws Exception {
		return playerRepository.save(t);
	}

	@Transactional
	@Override
	public Optional<Player> findById(Integer id) throws Exception {
		return playerRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		playerRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}
	
}
