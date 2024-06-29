package com.trabalhofinal.adapters.Persistency;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.repository.IAssinaturaRepository;


@Repository
public class AssinaturaRepositoryImpl implements IAssinaturaRepository {

    List<AssinaturaModel> assinaturas;

    @Autowired
    public AssinaturaRepositoryImpl() {

        // AplicativoRepositoryImpl arl = new AplicativoRepositoryImpl();
        // ClienteRepositoryImpl crl = new ClienteRepositoryImpl();

        // assinaturas = new LinkedList<AssinaturaModel>();
        // assinaturas.add(new AssinaturaModel(2222, arl.consultaPorCodigo(1500), crl.consultaPorCodigo(2401), LocalDate.of(2022, 02, 22), LocalDate.of(2033, 02, 22)));
        // assinaturas.add(new AssinaturaModel(3333, arl.consultaPorCodigo(1600), crl.consultaPorCodigo(2402), LocalDate.of(2022, 10, 22), LocalDate.of(2033, 10, 22)));
        // assinaturas.add(new AssinaturaModel(4444, arl.consultaPorCodigo(1700), crl.consultaPorCodigo(2403), LocalDate.of(2022, 10, 22), LocalDate.of(2033, 10, 22)));
        // assinaturas.add(new AssinaturaModel(5555, arl.consultaPorCodigo(1800), crl.consultaPorCodigo(2404), LocalDate.of(2022, 10, 22), LocalDate.of(2033, 10, 22)));
    }

    @Override
    public List<AssinaturaModel> todos() {
        return assinaturas;
    }

    @Override
    public List<AssinaturaModel> consultaPorDataDeFimVigenciaPosterior(LocalDate date) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getFimVigencia().isAfter(date))
        .collect(Collectors.toList());
    }

    @Override
    public List<AssinaturaModel> consultaPorDataDeFimVigenciaAnterior(LocalDate date) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getFimVigencia().isBefore(date))
        .collect(Collectors.toList());
    }

    @Override
    public List<AssinaturaModel> consultaPorCodigoDeCliente(long clienteCodigo) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getCliente().getCodigo() == clienteCodigo)
        .collect(Collectors.toList());
    }

    @Override
    public List<AssinaturaModel> consultaPorCodigoDeApp(long aplicativoCodigo) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getAplicativo().getCodigo() == aplicativoCodigo)
        .collect(Collectors.toList());
    }

    @Override
    public AssinaturaModel consultaPorCodigo(long codigo) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getCodigo() == codigo)
        .findFirst()
        .orElse(null);
    }


    @Override
    public AssinaturaModel save(AssinaturaModel assinatura) {
        assinaturas.add(assinatura);
        return assinatura;
    }

    @Override
    public boolean assinaturaValida(Long codigoAssinatura) {
        return true;
    }
}

