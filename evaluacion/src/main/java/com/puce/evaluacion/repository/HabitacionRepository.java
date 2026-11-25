package com.puce.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<com.puce.evaluacion.model.Habitacion, Long> {
    List<com.puce.evaluacion.model.Habitacion> findByDisponibleTrue();
}
