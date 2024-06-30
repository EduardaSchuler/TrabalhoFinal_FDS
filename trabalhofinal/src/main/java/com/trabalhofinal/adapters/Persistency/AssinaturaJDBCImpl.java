package com.trabalhofinal.adapters.Persistency;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.AplicativoModel;
import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.repository.IAplicativoRepository;
import com.trabalhofinal.domain.repository.IAssinaturaRepository;

@Repository
@Primary
public class AssinaturaJDBCImpl implements IAssinaturaRepository{

    private AplicativoJDBCImpl aplicativoJDBCImpl;

    private ClienteJDBCImpl clienteJDBCImpl;

    private IAplicativoRepository aplicativoRepository;

    private JdbcTemplate jdbcTemplate;



    @Override
    public AssinaturaModel consultaPorCodigo(long codigo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AssinaturaModel> todos() {
        List<AssinaturaModel> listaApps = this.jdbcTemplate.query("SELECT * FROM Assinatura", 
            (rs, rowNum) -> new AssinaturaModel(
                rs.getLong("codigo"),
                aplicativoJDBCImpl.consultaPorCodigo(rs.getLong("codigoAplicativo")), 
                clienteJDBCImpl.consultaPorCodigo(rs.getLong("codigoCliente"))));
        return listaApps;
    }

    @Override
    public List<AssinaturaModel> consultaPorCodigoDeApp(long aplicativoCodigo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AssinaturaModel> consultaPorCodigoDeCliente(long clienteCodigo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AssinaturaModel> consultaPorDataDeFimVigenciaAnterior(LocalDate date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AssinaturaModel> consultaPorDataDeFimVigenciaPosterior(LocalDate date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssinaturaModel save(AssinaturaModel assinatura) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
