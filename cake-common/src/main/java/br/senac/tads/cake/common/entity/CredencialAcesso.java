/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.entity;

/**
 *
 * @author Fernando
 */
public class CredencialAcesso {

  private static final long serialVersionUID = 1L;

  private String email;

  private String hashSenha;

  private Cliente usuario;

  public CredencialAcesso() {

  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getHashSenha() {
    return hashSenha;
  }

  public void setHashSenha(String hashSenha) {
    this.hashSenha = hashSenha;
  }

  public Cliente getUsuario() {
    return usuario;
  }

  public void setUsuario(Cliente usuario) {
    this.usuario = usuario;
  }

}
