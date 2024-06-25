package com.trabalhofinal.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.AplicativoModel;
import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.model.ClienteModel;
import com.trabalhofinal.domain.repository.IAplicativoRepository;
import com.trabalhofinal.domain.repository.IAssinaturaRepository;
import com.trabalhofinal.domain.repository.IClienteRepository;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Service
public class AssinaturaService {
    @Autowired
    private IAssinaturaRepository assinaturaRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IAplicativoRepository aplicativoRepository;

    public List<AssinaturaModel> listarTodas() {
        return assinaturaRepository.todos();
    }

    public boolean criarAssinatura(long codigoCliente, long codigoAplicativo) throws ParseException {        
        LocalDate inicioVigencia = LocalDate.now();
        LocalDate fimVigencia = LocalDate.now().plusDays(7);

        ClienteModel cliente = clienteRepository.consultaPorCodigo(codigoCliente);
        AplicativoModel aplicativo = aplicativoRepository.consultaPorCodigo(codigoAplicativo);
        AssinaturaModel assinatura = new AssinaturaModel(codigoCliente, aplicativo, cliente, inicioVigencia, fimVigencia);


        return assinaturaRepository.save(assinatura);
    } 

    public List<AssinaturaModel> listarPorTipo(String tipo) {
        LocalDate hoje = LocalDate.now();
        switch (tipo.toUpperCase()) {
            case "ATIVAS":
                return assinaturaRepository.consultaPorDataDeFimVigenciaPosterior(hoje);
            case "CANCELADAS":
                return assinaturaRepository.consultaPorDataDeFimVigenciaAnterior(hoje);
            default:
                return assinaturaRepository.todos();
        }
    }

    public List<AssinaturaModel> listarPorCliente(Long codigoCliente) {
        return assinaturaRepository.consultaPorCodigoDeCliente(codigoCliente);
    }

    public List<AssinaturaModel> listarPorAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.consultaPorCodigoDeApp(codigoAplicativo);
    }

    // public boolean assinaturaValida(Long codigoAssinatura) {
    //     Optional<Assinatura> assinatura = assinaturaRepository.findById(codigoAssinatura);
    //     if (assinatura == null) {
    //         return false;
    //     }
    //     Date now = new Date(codigoAssinatura);
    //     return assinatura.getFimVigencia().after(now);
    // }
}