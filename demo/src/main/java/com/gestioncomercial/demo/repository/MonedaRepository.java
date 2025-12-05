package com.gestioncomercial.demo.repository;


import com.gestioncomercial.demo.model.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long> {

    boolean existsByNombreIgnoreCase(String nombre);

}
