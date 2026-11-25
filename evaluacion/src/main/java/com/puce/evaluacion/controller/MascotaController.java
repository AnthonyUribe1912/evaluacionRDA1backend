package com.puce.evaluacion.controller;

import com.puce.evaluacion.model.Mascota;
import com.puce.evaluacion.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private com.puce.evaluacion.service.MascotaService mascotaService;

    @GetMapping
    public List<com.puce.evaluacion.model.Mascota> listarTodas() {
        return mascotaService.listarTodas();
    }

    @PostMapping
    public com.puce.evaluacion.model.Mascota registrar(@RequestBody com.puce.evaluacion.model.Mascota mascota) {
        return mascotaService.registrar(mascota);
    }

    @GetMapping("/especie")
    public List<com.puce.evaluacion.model.Mascota> listarPorEspecie(@RequestParam String nombre) {
        return mascotaService.listarPorEspecie(nombre);
    }
}


