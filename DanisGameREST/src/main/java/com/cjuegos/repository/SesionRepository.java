package com.cjuegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjuegos.entities.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Integer> {

}
