package com.puce.evaluacion.service;

import com.puce.evaluacion.model.Mascota;
import com.puce.evaluacion.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private com.puce.evaluacion.repository.MascotaRepository mascotaRepository;

    public List<com.puce.evaluacion.model.Mascota> listarTodas() {
        return mascotaRepository.findAll();
    }

    public com.puce.evaluacion.model.Mascota registrar(com.puce.evaluacion.model.Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public List<com.puce.evaluacion.model.Mascota> listarPorEspecie(String especie) {
        return mascotaRepository.findByEspecieIgnoreCase(especie);
    }
}