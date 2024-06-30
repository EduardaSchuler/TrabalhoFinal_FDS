package com.trabalhofinal.domain.repository;

import java.time.LocalDate;
import java.util.List;

import com.trabalhofinal.domain.model.AplicativoModel;
import com.trabalhofinal.domain.model.AssinaturaModel;

public interface IAssinaturaRepository {
    List<AssinaturaModel> todos();
    List<AssinaturaModel> consultaPorDataDeFimVigenciaPosterior(LocalDate date);
    List<AssinaturaModel> consultaPorDataDeFimVigenciaAnterior(LocalDate date);
    List<AssinaturaModel> consultaPorCodigoDeCliente(long clienteCodigo);
    List<AssinaturaModel> consultaPorCodigoDeApp(long aplicativoCodigo);
    AssinaturaModel consultaPorCodigo(long codigo);
    AssinaturaModel save(AssinaturaModel assinatura);
}
