package com.gestioncomercial.demo.repository;


import com.gestioncomercial.demo.model.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {


    boolean existsByNombreIgnoreCase(String nombre);
}

