package com.trabalhofinal.adapters.Persistency;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.AplicativoModel;
import com.trabalhofinal.domain.repository.IAplicativoRepository;

@Repository
@Primary
public class AplicativoJDBCImpl implements IAplicativoRepository{

    private JdbcTemplate jdbcTemplate;
    

    public AplicativoJDBCImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AplicativoModel> todos() {
        List<AplicativoModel> listaApps = this.jdbcTemplate.query("SELECT * FROM Aplicativo", 
            (rs, rowNum) -> new AplicativoModel(
                rs.getLong("codigo"),
                rs.getString("nome"), 
                rs.getDouble("custoMensal")));
        return listaApps;
    }

    @Override
    public AplicativoModel consultaPorCodigo(long codigo) {
        String sql = "SELECT codigo, nome, custoMensal FROM Aplicativo WHERE codigo = ?";
        AplicativoModel app = this.jdbcTemplate.queryForObject(
            sql, new Object[]{codigo}, (rs, rowNum) -> {
            AplicativoModel aplicativo = new AplicativoModel(rs.getLong("codigo"), rs.getString("nome"), rs.getDouble("custoMensal"));
            return aplicativo;
        });
        return app;
    }
    

    @Override
    public boolean cadastrarNovo(AplicativoModel aplicativo) {
        this.jdbcTemplate.update(
            "INSERT INTO Aplicativo (codigo, nome, custoMensal) VALUES (?,?,?)",
            aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());

            return true;
    }

    @Override
    public AplicativoModel editarNome(long codigo, String nomeNovo) {
        this.jdbcTemplate.update(
            "UPDATE Aplicativo SET nome = ? WHERE codigo = ?",
            nomeNovo, codigo);
        
        return consultaPorCodigo(codigo);
    }

    @Override
    public AplicativoModel atualizaCusto(long codigo, Double custoNovo) {
        this.jdbcTemplate.update(
            "UPDATE Aplicativo SET custoMensal = ? WHERE codigo = ?",
            custoNovo, codigo);
            return consultaPorCodigo(codigo);
    }
    
}
