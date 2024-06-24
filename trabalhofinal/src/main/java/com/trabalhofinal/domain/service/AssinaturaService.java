package com.trabalhofinal.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.trabalhofinal.adapters.persistencia.AssinaturaRepositoryImpl;
import com.trabalhofinal.domain.model.Aplicativo;
import com.trabalhofinal.domain.model.Assinatura;
import com.trabalhofinal.domain.model.Cliente;
import com.trabalhofinal.domain.repository.IAplicativoRepository;
import com.trabalhofinal.domain.repository.IAssinaturaRepository;
import com.trabalhofinal.domain.repository.IClienteRepository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AssinaturaService {
    @Autowired
    private IAssinaturaRepository assinaturaRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IAplicativoRepository aplicativoRepository;

    public List<Assinatura> listarTodas() {
        return assinaturaRepository.todos();
    }

    public boolean criarAssinatura(long codigoCliente, long codigoAplicativo) throws ParseException {        
        LocalDate inicioVigencia = LocalDate.now();
        LocalDate fimVigencia = LocalDate.now().plusDays(7);

        Cliente cliente = clienteRepository.consultaPorCodigo(codigoCliente);
        Aplicativo aplicativo = aplicativoRepository.consultaPorCodigo(codigoAplicativo);
        Assinatura assinatura = new Assinatura(codigoCliente, aplicativo, cliente, inicioVigencia, fimVigencia);


        return assinaturaRepository.save(assinatura);
    } 

    public List<Assinatura> listarPorTipo(String tipo) {
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

    public List<Assinatura> listarPorCliente(Long codigoCliente) {
        return assinaturaRepository.consultaPorCodigoDeCliente(codigoCliente);
    }

    public List<Assinatura> listarPorAplicativo(Long codigoAplicativo) {
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