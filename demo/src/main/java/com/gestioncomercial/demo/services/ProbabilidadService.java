package com.gestioncomercial.demo.services;


import com.gestioncomercial.demo.model.Probabilidad;
import com.gestioncomercial.demo.repository.ProbabilidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class ProbabilidadService {


    private final ProbabilidadRepository ProbabilidadRepository;


    public List<Probabilidad> obtenerProbabilidades(){
        return ProbabilidadRepository.findAll();
    }


    public Probabilidad guardarProbabilidad(Probabilidad probabilidad){

        if(probabilidad.getNombre()==null || probabilidad.getNombre().isBlank()){
            throw new IllegalArgumentException("Error: El nombre es obligatorio.");
        }
        String nombrelimpio=probabilidad.getNombre().trim();
        probabilidad.setNombre(nombrelimpio);
        if (ProbabilidadRepository.existsByNombreIgnoreCase(nombrelimpio)) {
            throw new IllegalArgumentException("Error: El nombre existe en el sistema.");
        }
        return ProbabilidadRepository.save(probabilidad);
    }


    public Optional<Probabilidad> obtenerProbabilidad(Long id){
        return ProbabilidadRepository.findById(id);
    }



    public void borrarProbabilidad(Long id){
        ProbabilidadRepository.deleteById(id);
    }



}
