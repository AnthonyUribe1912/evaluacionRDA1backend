package com.puce.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaRepository extends JpaRepository<com.puce.evaluacion.model.Mascota, Long> {
    List<com.puce.evaluacion.model.Mascota> findByEspecieIgnoreCase(String especie);
}

