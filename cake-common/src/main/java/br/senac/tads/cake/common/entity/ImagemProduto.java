/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.entity;

import java.io.Serializable;

/**
 *
 * @author Fernando
 */

public class ImagemProduto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String legenda;

  private String nomeArquivo;

  private Produto produto;

  public ImagemProduto() {
  }

  public ImagemProduto(Long id, String legenda, String nomeArquivo) {
    this.id = id;
    this.legenda = legenda;
    this.nomeArquivo = nomeArquivo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLegenda() {
    return legenda;
  }

  public void setLegenda(String legenda) {
    this.legenda = legenda;
  }

  public String getNomeArquivo() {
    return nomeArquivo;
  }

  public void setNomeArquivo(String nomeArquivo) {
    this.nomeArquivo = nomeArquivo;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

}
