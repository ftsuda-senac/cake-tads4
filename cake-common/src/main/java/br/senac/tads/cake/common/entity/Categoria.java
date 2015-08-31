/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class Categoria implements Serializable {

  public Categoria() {
    
  }

  public Categoria(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }
  
  private Long id;
  
  private String nome;
  
  private List<Produto> produtos;

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
    
}
