package com.gestioncomercial.demo.services;


import com.gestioncomercial.demo.model.Cliente;
import com.gestioncomercial.demo.repository.ClienteRepository; // Importamos todos los repos
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClienteService {


    private final ClienteRepository clienteRepository;



    public Cliente guardarCliente(Cliente cliente) {

        if(cliente.getNombre()==null || cliente.getNombre().isBlank()){
            throw new IllegalArgumentException("Error: El nombre es obligatorio.");
        }
        String nombrelimpio=cliente.getNombre().trim();
        cliente.setNombre(nombrelimpio);
        if (clienteRepository.existsByNombreIgnoreCase(nombrelimpio)) {
            throw new IllegalArgumentException("Error: El nombre existe en el sistema.");
        }
        return clienteRepository.save(cliente);

    }



    public Optional<Cliente> buscarCliente(String nombre) {
        if(nombre==null || nombre.isBlank()){
            return Optional.empty();
        }
        String nombrelimpio=nombre.trim();
        return clienteRepository.findByNombreIgnoreCase(nombrelimpio);
    }




    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }



    public boolean eliminar(Long id){

        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;

        }else {

            return false;
        }
    }




}
