/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fernando.tsuda
 */
public class Usuario implements Serializable {

  private Long id;

  private String nome;

  private Date dataNascimento;

  private Date dataCadastro;

  private CredencialAcesso credencial;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Date getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(Date dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public CredencialAcesso getCredencial() {
    return credencial;
  }

  public void setCredencial(CredencialAcesso credencial) {
    this.credencial = credencial;
  }

}
