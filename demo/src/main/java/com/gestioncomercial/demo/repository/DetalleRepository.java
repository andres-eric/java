package com.gestioncomercial.demo.repository;

import com.gestioncomercial.demo.model.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {

    List<Detalle> findByFechaInforme(LocalDate fecha);

    List<Detalle> findByProbabilidad_Nombre(String probabilidad);

    List<Detalle> findByFechaInformeBetween(LocalDate inicio, LocalDate fin);

    List<Detalle> findByCliente_NombreAndAnio(String clientenombre, Integer anio);

}
