package com.gestioncomercial.demo.services;


import com.gestioncomercial.demo.model.Linea;
import com.gestioncomercial.demo.repository.LineaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class LineaService {


    private final LineaRepository lineaRepository;


    public List<Linea> obtenerLineas(){
        return lineaRepository.findAll();
    }


    public Linea guardarLinea(Linea linea){

        if(linea.getNombre()==null || linea.getNombre().isBlank()){
            throw new IllegalArgumentException("Error: El nombre es obligatorio.");
        }
        String nombrelimpio=linea.getNombre().trim();
        linea.setNombre(nombrelimpio);
        if (lineaRepository.existsByNombreIgnoreCase(nombrelimpio)) {
            throw new IllegalArgumentException("Error: El nombre existe en el sistema.");
        }
        return lineaRepository.save(linea);
    }


    public Optional<Linea> obtenerLinea(Long id){
        return lineaRepository.findById(id);
    }



    public void borrarLinea(Long id){
        lineaRepository.deleteById(id);
    }



}
