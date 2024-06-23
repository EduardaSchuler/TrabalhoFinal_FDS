package com.trabalhofinal.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

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
        return assinaturaRepository.findAll();
    }

    public Assinatura criarAssinatura(Long codigoCliente, Long codigoAplicativo) throws ParseException {        
        String inicioVigencia = LocalDate.now().toString();
        String fimVigencia = LocalDate.now().plusDays(7).toString();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Cliente cliente = clienteRepository.findById(codigoCliente).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Aplicativo aplicativo = aplicativoRepository.findById(codigoAplicativo).orElseThrow(() -> new RuntimeException("Aplicativo não encontrado"));
        Assinatura assinatura = new Assinatura();
        assinatura.setCliente(cliente);
        assinatura.setAplicativo(aplicativo);
        assinatura.setInicioVigencia(sdf.parse(inicioVigencia));
        assinatura.setFimVigencia(sdf.parse(fimVigencia));

        return assinaturaRepository.save(assinatura);
    } 

    public List<Assinatura> listarPorTipo(String tipo) {
        LocalDate hoje = LocalDate.now();
        switch (tipo.toUpperCase()) {
            case "ATIVAS":
                return assinaturaRepository.findByFimVigenciaAfter(hoje);
            case "CANCELADAS":
                return assinaturaRepository.findByFimVigenciaBefore(hoje);
            default:
                return assinaturaRepository.findAll();
        }
    }

    public List<Assinatura> listarPorCliente(Long codigoCliente) {
        return assinaturaRepository.ConsultaPorCodigoDeCliente(codigoCliente);
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