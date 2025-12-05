package com.gestioncomercial.demo.services;


import com.gestioncomercial.demo.model.Pais;
import com.gestioncomercial.demo.repository.PaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class PaisService {


    private final PaisRepository paisRepository;


    public List<Pais> obtenerPaises(){
        return paisRepository.findAll();
    }


    public Pais guardarPais(Pais pais){

        if(pais.getNombre()==null || pais.getNombre().isBlank()){
            throw new IllegalArgumentException("Error: El nombre es obligatorio.");
        }
        String nombrelimpio=pais.getNombre().trim();
        pais.setNombre(nombrelimpio);
        if (paisRepository.existsByNombreIgnoreCase(nombrelimpio)) {
            throw new IllegalArgumentException("Error: El nombre existe en el sistema.");
        }
        return paisRepository.save(pais);
    }


    public Optional<Pais> obtenerPais(Long id){
        return paisRepository.findById(id);
    }



    public void borrarPais(Long id){
        paisRepository.deleteById(id);
    }



}
