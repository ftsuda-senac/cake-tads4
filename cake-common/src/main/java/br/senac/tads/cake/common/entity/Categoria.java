/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fernando.tsuda
 */

public class Categoria implements Serializable {

  private static final long serialVersionUID = 1L;


  private Long id;

  private String nome;

  private List<Produto> produtos;

  public Categoria() {

  }

  public Categoria(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

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

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.id);
    hash = 97 * hash + Objects.hashCode(this.nome);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Categoria other = (Categoria) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    return true;
  }

}
