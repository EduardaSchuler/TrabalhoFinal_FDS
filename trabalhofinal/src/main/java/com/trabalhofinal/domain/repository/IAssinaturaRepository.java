package com.trabalhofinal.domain.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.trabalhofinal.domain.model.Assinatura;

public interface IAssinaturaRepository {
    List<Assinatura> todos();
    List<Assinatura> consultaPorDataDeFimVigenciaPosterior(LocalDate date);
    List<Assinatura> consultaPorDataDeFimVigenciaAnterior(LocalDate date);
    List<Assinatura> consultaPorCodigoDeCliente(long clienteCodigo);
    List<Assinatura> consultaPorCodigoDeApp(long aplicativoCodigo);
    Assinatura consultaPorCodigo(long codigo);
    boolean save(Assinatura assinatura);
    boolean assinaturaValida(Long codigoAssinatura);
}
