package com.trabalhofinal.domain.model;

public class Usuario {
  private String usuario; // Identificador do usuário para login
  private String senha; // Senha de acesso do usuário
  
  public Usuario(String usuario, String senha) {
    this.usuario = usuario;
    this.senha = senha;
  }

  public String getUsuario() {
    return usuario;
  }

  public String getSenha() {
    return senha;
  }

  public void setUsuario(String usuario) {
      this.usuario = usuario;
  }

  public void setSenha(String senha) {
      this.senha = senha;
  }
}
