package com.gestioncomercial.demo.controller;


import com.gestioncomercial.demo.model.Cliente;
import com.gestioncomercial.demo.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/clientes

@RestController
@RequestMapping("/api/clientes") // <--- OJO: Cambiar esto en cada archivo (/api/paises, /api/monedas...)
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente> obtenerClientes() {
        return clienteService.buscarClientes();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {

        Cliente nuevocliente=clienteService.guardarCliente(cliente);
        return new ResponseEntity<>(nuevocliente, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        try {
            boolean eliminado = clienteService.eliminar(id);
            if (eliminado) {
                return ResponseEntity.ok("Cliente eliminado");
            } else {
                return ResponseEntity.notFound().build();
            }


        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se puede eliminar el cliente. Es posible que tenga ventas asociadas.");

        }

    }

}
