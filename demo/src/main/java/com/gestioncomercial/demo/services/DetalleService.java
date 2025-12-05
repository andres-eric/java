package com.gestioncomercial.demo.services;

import com.gestioncomercial.demo.model.Detalle;
import com.gestioncomercial.demo.model.Familia;
import com.gestioncomercial.demo.repository.*; // Importamos todos los repos
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DetalleService {


        private final DetalleRepository detalleRepository;
        private final ComercialRepository comercialRepository;
        private final ClienteRepository clienteRepository;
        private final FamiliaRepository familiaRepository;
        private final LineaRepository lineaRepository;
        private final MercadoRepository mercadoRepository;
        private final MonedaRepository monedaRepository;
        private final PaisRepository paisRepository;
        private final ProbabilidadRepository probabilidadRepository;





    public Detalle guardarDetalle(Detalle detalle) {


        // Excel: FECHA INFORME
        if(detalle.getFechaInforme() ==null) {
            throw new IllegalArgumentException("Error: La fecha de entrega es un campo obligatorio.");
        }


        // Excel: AÑO
        if(detalle.getAnio() ==null) {
            throw new IllegalArgumentException("Error: La anio es un campo obligatorio.");
        }


        //Cliente*
        if( detalle.getCliente()!=null && detalle.getCliente().getId()!=null )
        {
         if(!clienteRepository.existsById(detalle.getCliente().getId()) ){
             throw new RuntimeException("Error: El Cliente con ese ID no existe.");
            }
        }


        // Excel: Proyecto
        if(detalle.getProyecto() ==null) {
            throw new IllegalArgumentException("Error: el proyecto es un campo obligatorio.");
        }


        //COMERCIAL*
        if( detalle.getComercial()!=null && detalle.getComercial().getId()!=null )
        {
            if(!comercialRepository.existsById(detalle.getComercial().getId()) ){
                throw new RuntimeException("Error: El Comercial con ese ID no existe.");
            }
        }


        //MERCADO*
        if( detalle.getMercado()!=null && detalle.getMercado().getId()!=null )
        {
            if(!mercadoRepository.existsById(detalle.getMercado().getId()) ){
                throw new RuntimeException("Error: El Mercado con ese ID no existe.");
            }
        }


        //PAIS*
        if( detalle.getPais()!=null && detalle.getPais().getId()!=null )
        {
            if(!paisRepository.existsById(detalle.getPais().getId()) ){
                throw new RuntimeException("Error: El Pais con ese ID no existe.");
            }
        }


        //Linea*
        if( detalle.getLinea_producto()!=null && detalle.getLinea_producto().getId()!=null )
        {
            if(!lineaRepository.existsById(detalle.getLinea_producto().getId()) ){
                throw new RuntimeException("Error: la linea con ese ID no existe.");
            }
        }

        //codigo*
        if(detalle.getCodigo() ==null) {
            throw new IllegalArgumentException("Error: el codigo es un campo obligatorio.");
        }

        //familia*
        if( detalle.getFamilia()!=null && detalle.getFamilia().getId()!=null )
        {
            if(!familiaRepository.existsById(detalle.getFamilia().getId()) ){
                throw new RuntimeException("Error: la familia con ese ID no existe.");

            }
        }



        //cantidad*
        if(detalle.getCantidad() ==null || detalle.getCantidad()<=0 ) {
            throw new IllegalArgumentException("Error: el cantidad es un campo obligatorio y mayor a cero.");
        }




        //valor total*
        if(detalle.getValorUnitario()!=null){


            double totalvalor= detalle.getCantidad()* detalle.getValorUnitario();

            detalle.setValorTotalPesosCol(totalvalor);

        } else {

            detalle.setValorTotalPesosCol(0.0);
        }



        //moneda*
        if( detalle.getMoneda()!=null && detalle.getMoneda().getId()!=null )
        {
            if(!monedaRepository.existsById(detalle.getMoneda().getId()) ){
                throw new RuntimeException("Error: la moneda con ese ID no existe.");
            }
        }



        //probabilidad*
        if( detalle.getProbabilidad()!=null && detalle.getProbabilidad().getId()!=null )
        {
            if(!probabilidadRepository.existsById(detalle.getProbabilidad().getId()) ){
                throw new RuntimeException("Error: la probabilidad con ese ID no existe.");
            }
        }


        // Excel: fecha_probable_oc
        if(detalle.getFechaProbableRecibirOC() ==null) {
            throw new IllegalArgumentException("Error: La fecha de oc es un campo obligatorio.");
        }

        // Excel: fecha_suministro
        if(detalle.getFechaProbableSuministro() ==null) {
            throw new IllegalArgumentException("Error: La fecha de suministro es un campo obligatorio.");
        }

        // Excel: causa_perdida
        if(detalle.getCausaPerdidaNegocio()==null) {
            throw new IllegalArgumentException("Error: La causa es un campo obligatorio.");
        }

        // --- GUARDADO FINAL ---
        return detalleRepository.save(detalle);
    }


    public void borrarDetalle(Long id){
        detalleRepository.deleteById(id);
    }



}
