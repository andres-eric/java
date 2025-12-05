package com.gestioncomercial.demo.services;


import com.gestioncomercial.demo.model.Familia;
import com.gestioncomercial.demo.repository.FamiliaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class FamiliaService {


    private final FamiliaRepository familiaRepository;


    public List<Familia> obtenerFamilias(){
        return familiaRepository.findAll();
    }


    public Familia guardarFamilia(Familia familia){

        if(familia.getNombre()==null || familia.getNombre().isBlank()){
            throw new IllegalArgumentException("Error: El nombre es obligatorio.");
        }
        String nombrelimpio=familia.getNombre().trim();
        familia.setNombre(nombrelimpio);
        if (familiaRepository.existsByNombreIgnoreCase(nombrelimpio)) {
            throw new IllegalArgumentException("Error: El nombre existe en el sistema.");
        }
        return familiaRepository.save(familia);
    }


    public Optional<Familia> obtenerFamiliaid(Long id){
        return familiaRepository.findById(id);
    }



    public void borrarFamilia(Long id){
        familiaRepository.deleteById(id);
    }



}
