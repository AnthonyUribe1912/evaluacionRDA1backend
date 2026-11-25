package com.puce.evaluacion.controller;

import com.puce.evaluacion.model.Habitacion;
import com.puce.evaluacion.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private com.puce.evaluacion.service.HabitacionService habitacionService;

    @GetMapping
    public List<com.puce.evaluacion.model.Habitacion> listarTodas() {
        return habitacionService.listarTodas();
    }

    @PostMapping
    public com.puce.evaluacion.model.Habitacion registrar(@RequestBody com.puce.evaluacion.model.Habitacion habitacion) {
        return habitacionService.registrar(habitacion);
    }

    @GetMapping("/disponibles")
    public List<com.puce.evaluacion.model.Habitacion> listarDisponibles() {
        return habitacionService.listarDisponibles();
    }
}

