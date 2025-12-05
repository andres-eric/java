package com.gestioncomercial.demo.repository;

import com.gestioncomercial.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    Optional<Cliente> findByNombreIgnoreCase(String nombre);

    boolean existsByNombreIgnoreCase(String nombre);


}
