package com.trabalhofinal.domain.repository;

import java.util.List;
import java.util.Optional;

import com.trabalhofinal.domain.model.Cliente;

public interface IClienteRepository {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
}
