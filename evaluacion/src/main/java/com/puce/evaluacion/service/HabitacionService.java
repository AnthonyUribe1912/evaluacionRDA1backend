package com.puce.evaluacion.service;

import com.puce.evaluacion.model.Habitacion;
import com.puce.evaluacion.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    @Autowired
    private com.puce.evaluacion.repository.HabitacionRepository habitacionRepository;

    public List<com.puce.evaluacion.model.Habitacion> listarTodas() {
        return habitacionRepository.findAll();
    }

    public com.puce.evaluacion.model.Habitacion registrar(com.puce.evaluacion.model.Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public List<com.puce.evaluacion.model.Habitacion> listarDisponibles() {
        return habitacionRepository.findByDisponibleTrue();
    }
}
