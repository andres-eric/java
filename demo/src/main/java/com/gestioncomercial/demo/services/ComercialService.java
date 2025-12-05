package com.gestioncomercial.demo.services;


import com.gestioncomercial.demo.model.Comercial;
import com.gestioncomercial.demo.repository.ComercialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComercialService {

    private final ComercialRepository comercialRepository;





    public Optional<Comercial> EncontrarNombre(String nombre) {
        if(nombre==null || nombre.isBlank()){
            return Optional.empty();
        }
        String nombrelimpio=nombre.trim();
        return comercialRepository.findByNombreIgnoreCase(nombrelimpio);
    }



    public Comercial GuardarComercial(Comercial comercial) {

        if(comercial.getNombre()==null || comercial.getNombre().isBlank()){
            throw new IllegalArgumentException("Error: El nombre es obligatorio.");
        }
        String nombrelimpio=comercial.getNombre().trim();
        comercial.setNombre(nombrelimpio);
        if (comercialRepository.existsByNombreIgnoreCase(nombrelimpio)) {
            throw new IllegalArgumentException("Error: El nombre existe en el sistema.");
        }
        return comercialRepository.save(comercial);
    }



    public List<Comercial> encontrarTodosComerciales() {
        return comercialRepository.findAll();
    }



    public void eliminarComercial(Long id) {
        comercialRepository.deleteById(id);
    }



    // faltapor revisar
    public void eliminarPorNombre(String nombre) {
            Optional<Comercial> nombreid=comercialRepository.findByNombreIgnoreCase(nombre);
            Comercial comercial;
            if(nombreid.isEmpty()){
                throw new IllegalArgumentException("Error: No se encontró ningún cliente con el nombre: " + nombre);
            } else {
                comercial=nombreid.get();
            }
            comercialRepository.delete(comercial);
    }
}
