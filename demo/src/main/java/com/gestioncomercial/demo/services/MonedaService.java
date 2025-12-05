package com.gestioncomercial.demo.services;


import com.gestioncomercial.demo.model.Moneda;
import com.gestioncomercial.demo.repository.MonedaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class MonedaService {


    private final MonedaRepository mondedaRepository;


    public List<Moneda> obtenerMercados(){
        return mondedaRepository.findAll();
    }


    public Moneda guardarMercado(Moneda moneda){

        if(moneda.getNombre()==null || moneda.getNombre().isBlank()){
            throw new IllegalArgumentException("Error: El nombre es obligatorio.");
        }
        String nombrelimpio=moneda.getNombre().trim();
        moneda.setNombre(nombrelimpio);
        if (mondedaRepository.existsByNombreIgnoreCase(nombrelimpio)) {
            throw new IllegalArgumentException("Error: El nombre existe en el sistema.");
        }
        return mondedaRepository.save(moneda);
    }


    public Optional<Moneda> obtenerMercado(Long id){
        return mondedaRepository.findById(id);
    }



    public void borrarMeracdo(Long id){
        mondedaRepository.deleteById(id);
    }



}
