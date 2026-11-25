package com.puce.evaluacion.controller;

import com.puce.evaluacion.model.Curso;
import com.puce.evaluacion.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private com.puce.evaluacion.service.CursoService cursoService;

    @GetMapping
    public List<com.puce.evaluacion.model.Curso> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.puce.evaluacion.model.Curso> buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public com.puce.evaluacion.model.Curso crear(@RequestBody com.puce.evaluacion.model.Curso curso) {
        return cursoService.crear(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.puce.evaluacion.model.Curso> actualizar(@PathVariable Long id, @RequestBody com.puce.evaluacion.model.Curso detalles) {
        return cursoService.actualizar(id, detalles)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (cursoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/promedio")
    public ResponseEntity<Map<String, Double>> obtenerPromedio() {
        return ResponseEntity.ok(Map.of("costoPromedio", cursoService.obtenerCostoPromedio()));
    }
}
