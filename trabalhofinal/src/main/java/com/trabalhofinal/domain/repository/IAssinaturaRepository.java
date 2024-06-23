package com.trabalhofinal.domain.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.trabalhofinal.domain.model.Assinatura;

public interface IAssinaturaRepository {
    List<Assinatura> todos();
    List<Assinatura> consultaPorDataDeFimVigenciaPosterior(Date date);
    List<Assinatura> consultaPorDataDeFimVigenciaAnterior(Date date);
    List<Assinatura> consultaPorCodigoDeCliente(Long clienteCodigo);
    List<Assinatura> consultaPorCodigoDeApp(Long aplicativoCodigo);
    List<Assinatura> consultaPorCodigo(Long codigo);
    boolean save(Assinatura assinatura);
    boolean assinaturaValida(Long codigoAssinatura);
}
