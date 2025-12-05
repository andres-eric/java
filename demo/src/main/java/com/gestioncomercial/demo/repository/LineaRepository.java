package com.gestioncomercial.demo.repository;

import com.gestioncomercial.demo.model.Linea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LineaRepository extends JpaRepository<Linea, Long> {

    boolean existsByNombreIgnoreCase(String nombre);

}
