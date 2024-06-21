package com.trabalhofinal.domain.repository;

import java.util.List;
import java.util.Optional;

import com.trabalhofinal.domain.model.Aplicativo;

public interface IAplicativoRepository {
    List<Aplicativo> findAll();
    Optional<Aplicativo> findById(Long id);
    Aplicativo save(Aplicativo aplicativo);
}
