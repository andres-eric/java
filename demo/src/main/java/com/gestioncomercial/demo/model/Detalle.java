package com.gestioncomercial.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




@Getter
@Setter
@Entity
@Table(name="detalle")



public class Detalle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Excel: FECHA INFORME

    @Column(name="fecha_informe")
    private LocalDate fechaInforme;


    // Excel: AÑO

    private Integer anio;


    // Excel: CLIENTE
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    // Excel: PROYECTO
    private String proyecto;


    // Excel: COMERCIAL
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comercial_id")
    private Comercial comercial;


    // Excel: MERCADO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mercado_id")
    private Mercado mercado;


    // Excel: PAIS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    // Excel: Linea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linea_id")
    private Linea linea_producto;


    // Excel: codigo
    @Column(name="codigo_producto")
    private String codigo;


    // Excel: familia
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "familia_id")
    private Familia familia;

    // Excel: cantidad
    @Column(name="cantidad_producto")
    private Integer cantidad;


    @Column(name = "valor_unitario")
    private Double valorUnitario;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moneda_id")
    private Moneda moneda;

    @Column(name = "valor_total_pesos")
    private Double valorTotalPesosCol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "probabilidad_id")
    private Probabilidad probabilidad;


    @Column(name = "fecha_probable_oc")
    private LocalDate fechaProbableRecibirOC;

    @Column(name = "fecha_probable_suministro")
    private LocalDate fechaProbableSuministro;

    @Column(name = "causa_perdida")
    private String causaPerdidaNegocio;

    @Column(length = 500)
    private String comentario;

}
