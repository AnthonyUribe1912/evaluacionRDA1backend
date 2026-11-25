package com.puce.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends JpaRepository<com.puce.evaluacion.model.Curso, Long> {
    @Query("SELECT AVG(c.costo) FROM Curso c")
    Double obtenerCostoPromedio();
}
