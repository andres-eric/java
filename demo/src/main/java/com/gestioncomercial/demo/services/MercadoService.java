package com.gestioncomercial.demo.services;


import com.gestioncomercial.demo.model.Mercado;
import com.gestioncomercial.demo.repository.MercadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class MercadoService {


    private final MercadoRepository mercadoRepository;


    public List<Mercado> obtenerMercados(){
        return mercadoRepository.findAll();
    }


    public Mercado guardarMercado(Mercado mercado){

        if(mercado.getNombre()==null || mercado.getNombre().isBlank()){
            throw new IllegalArgumentException("Error: El nombre es obligatorio.");
        }
        String nombrelimpio=mercado.getNombre().trim();
        mercado.setNombre(nombrelimpio);
        if (mercadoRepository.existsByNombreIgnoreCase(nombrelimpio)) {
            throw new IllegalArgumentException("Error: El nombre existe en el sistema.");
        }
        return mercadoRepository.save(mercado);
    }


    public Optional<Mercado> obtenerMercado(Long id){
        return mercadoRepository.findById(id);
    }



    public void borrarMercado(Long id){
        mercadoRepository.deleteById(id);
    }



}
