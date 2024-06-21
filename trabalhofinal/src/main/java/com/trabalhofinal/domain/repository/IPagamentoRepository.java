package com.trabalhofinal.domain.repository;

import java.util.List;
import java.util.Optional;

import com.trabalhofinal.domain.model.Pagamento;

public interface IPagamentoRepository {
    List<Pagamento> findAll();
    Optional<Pagamento> findById(Long id);
    Pagamento save(Pagamento pagamento);
}
