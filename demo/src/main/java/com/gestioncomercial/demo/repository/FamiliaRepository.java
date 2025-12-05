package com.gestioncomercial.demo.repository;

import com.gestioncomercial.demo.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia,Long> {


    @Override
    Optional<Familia> findById(Long id);


    Optional<Familia> findByNombre(String nombre);

    boolean existsByNombreIgnoreCase(String nombre);
}
