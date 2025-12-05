package com.gestioncomercial.demo.repository;

import com.gestioncomercial.demo.model.Probabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbabilidadRepository extends JpaRepository<Probabilidad, Long> {

    boolean existsByNombreIgnoreCase(String nombre);

}
