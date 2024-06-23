package com.trabalhofinal.adapters.persistencia;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.Aplicativo;
import com.trabalhofinal.domain.model.Assinatura;
import com.trabalhofinal.domain.model.Cliente;
import com.trabalhofinal.domain.repository.IAssinaturaRepository;


@Repository
public class AssinaturaRepositoryImpl implements IAssinaturaRepository {

    List<Assinatura> assinaturas;

    

    public AssinaturaRepositoryImpl() {

        AplicativoRepositoryImpl arl = new AplicativoRepositoryImpl();
        ClienteRepositoryImpl crl = new ClienteRepositoryImpl();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        

        // aqui não terminei
        // assinaturas = new LinkedList<Assinatura>();
        // assinaturas.add(new Assinatura(2222, arl.consultaPorCodigo(1500), crl.consultaPorCodigo(2401),sdf.parse("22/10/2010"), sdf.parse("22/10/2030"));
    }

    @Override
    public List<Assinatura> todos() {
        return assinaturas;
    }

    @Override
    public List<Assinatura> ConsultaPorDataDeFimVigenciaPosterior(Date date) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getFimVigencia().after(date))
        .collect(Collectors.toList());
    }

    @Override
    public List<Assinatura> ConsultaPorDataDeFimVigenciaAnterior(Date date) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getFimVigencia().before(date))
        .collect(Collectors.toList());
    }

    @Override
    public List<Assinatura> ConsultaPorCodigoDeCliente(Long clienteCodigo) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getCliente().getCodigo() == clienteCodigo)
        .collect(Collectors.toList());
    }

    @Override
    public List<Assinatura> consultaPorCodigoDeApp(Long aplicativoCodigo) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getAplicativo().getCodigo() == aplicativoCodigo)
        .collect(Collectors.toList());
    }

    @Override
    public List<Assinatura> consultaPorCodigo(Long codigo) {
        return assinaturas.stream()
        .filter(assinatura->assinatura.getCodigo() == codigo)
        .collect(Collectors.toList());
    }

    @Override
    public boolean save(Assinatura assinatura) {
       return assinaturas.add(assinatura);
    }

    @Override
    public boolean assinaturaValida(Long codigoAssinatura) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assinaturaValida'");
    }
    


}

