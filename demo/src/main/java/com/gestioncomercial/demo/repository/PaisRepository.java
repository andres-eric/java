package com.gestioncomercial.demo.repository;

import com.gestioncomercial.demo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface PaisRepository extends JpaRepository<Pais, Long> {

    boolean existsByNombreIgnoreCase(String nombre);

}
