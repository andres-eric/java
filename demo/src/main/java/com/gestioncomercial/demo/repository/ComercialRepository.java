package com.gestioncomercial.demo.repository;

import com.gestioncomercial.demo.model.Cliente;
import com.gestioncomercial.demo.model.Comercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ComercialRepository extends JpaRepository<Comercial,Long> {


    Optional<Comercial> findByNombreIgnoreCase(String nombre);

    boolean existsByNombreIgnoreCase(String nombre);




}
