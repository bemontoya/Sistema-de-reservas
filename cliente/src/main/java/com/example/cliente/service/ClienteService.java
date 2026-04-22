package com.example.cliente.service;

import com.example.cliente.dto.ClienteDTO;
import com.example.cliente.model.Cliente;
import com.example.cliente.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(ClienteDTO clienteDTO){
        logger.info("Iniciando la creación del cliente con email: {}", clienteDTO.getEmail());

        //Validar si el email ya existe

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(clienteDTO.getNombre());
        nuevoCliente.setEmail(clienteDTO.getEmail());
        nuevoCliente.setTelefono(clienteDTO.getTelefono());

        Cliente clienteGuardado = clienteRepository.save(nuevoCliente);

        logger.debug("Cliente guardado exitosamente con ID: {}", clienteGuardado.getId());
        return clienteGuardado;
    }

    public List<Cliente> obtenerTodos(){
        logger.info("Consultando la lista completa de clientes");
        return clienteRepository.findAll();
    }
}
