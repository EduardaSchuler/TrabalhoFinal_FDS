package com.trabalhofinal.domain.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.trabalhofinal.domain.model.Assinatura;

public interface IAssinaturaRepository {
    List<Assinatura> findAll();
    List<Assinatura> findByFimVigenciaAfter(LocalDate date);
    List<Assinatura> findByFimVigenciaBefore(LocalDate date);
    List<Assinatura> findByClienteCodigo(Long clienteCodigo);
    List<Assinatura> findByAplicativoCodigo(Long aplicativoCodigo);
    Optional<Assinatura> findById(Long id);
    Assinatura save(Assinatura assinatura);
    boolean assinaturaValida(Long codigoAssinatura);
}
