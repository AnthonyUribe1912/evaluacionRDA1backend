package com.puce.evaluacion.service;

import com.puce.evaluacion.model.Curso;
import com.puce.evaluacion.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private com.puce.evaluacion.repository.CursoRepository cursoRepository;

    public List<com.puce.evaluacion.model.Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Optional<com.puce.evaluacion.model.Curso> buscarPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public com.puce.evaluacion.model.Curso crear(com.puce.evaluacion.model.Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<com.puce.evaluacion.model.Curso> actualizar(Long id, com.puce.evaluacion.model.Curso detalles) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(detalles.getNombre());
            curso.setDocente(detalles.getDocente());
            curso.setHoras(detalles.getHoras());
            curso.setCosto(detalles.getCosto());
            curso.setModalidad(detalles.getModalidad());
            return cursoRepository.save(curso);
        });
    }

    public boolean eliminar(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Double obtenerCostoPromedio() {
        Double promedio = cursoRepository.obtenerCostoPromedio();
        return promedio != null ? promedio : 0.0;
    }
}
