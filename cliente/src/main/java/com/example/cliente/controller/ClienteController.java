package com.example.cliente.controller;

import com.example.cliente.dto.ClienteDTO;
import com.example.cliente.model.Cliente;
import com.example.cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //POST: Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        // @Valid activa las validaciones agregadas al DTO (@NotBlank, @Email)
        Cliente nuevoCliente = clienteService.crearCliente(clienteDTO);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    // GET: Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.obtenerTodos();
        return ResponseEntity.ok(clientes);
    }
}
