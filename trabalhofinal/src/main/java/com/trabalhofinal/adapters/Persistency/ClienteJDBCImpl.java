package com.trabalhofinal.adapters.Persistency;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.ClienteModel;
import com.trabalhofinal.domain.repository.IClienteRepository;

@Repository
@Primary
public class ClienteJDBCImpl implements IClienteRepository{
    
    private JdbcTemplate jdbcTemplate;

    public ClienteJDBCImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ClienteModel> todos() {
        List<ClienteModel> listaCli = this.jdbcTemplate.query("SELECT * FROM Cliente",
            (rs, rowNum) -> new ClienteModel(
                rs.getLong("codigo"),
                rs.getString("nome"), 
                rs.getString("email")));
        
        return listaCli;
    }

    @Override
    public ClienteModel consultaPorCodigo(long codigo) {
        String sql = "SELECT codigo, nome, custoMensal FROM Aplicativo WHERE codigo = ?";
        ClienteModel cli = this.jdbcTemplate.queryForObject(
            sql, new Object[]{codigo}, (rs, rowNum) -> {
            ClienteModel cliente = new ClienteModel(rs.getLong("codigo"), rs.getString("nome"), rs.getString("email"));
            return cliente;
        });
        return cli;
    }

    @Override
    public boolean cadastrarNovo(ClienteModel cliente) {
        this.jdbcTemplate.update(
            "INSERT INTO Cliente (codigo, nome, email) VALUES (?,?,?)",
            cliente.getCodigo(), cliente.getNome(), cliente.getEmail());

            return true;
    }

    @Override
    public ClienteModel editarNome(long codigo, String nomeNovo) {
        this.jdbcTemplate.update(
            "UPDATE Aplicativo SET nome = ? WHERE codigo = ?",
            nomeNovo, codigo);
        
        return consultaPorCodigo(codigo);
    }

    @Override
    public ClienteModel editarEmail(long codigo, String emailNovo) {
        this.jdbcTemplate.update(
            "UPDATE Aplicativo SET nome = ? WHERE codigo = ?",
            emailNovo, codigo);
        
        return consultaPorCodigo(codigo);
    }

}
