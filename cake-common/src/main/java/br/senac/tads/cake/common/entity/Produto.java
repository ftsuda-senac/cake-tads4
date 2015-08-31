/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class Produto implements Serializable {

  public Produto() {
  }

  public Produto(Long id, String nome, String descricao, List<ImagemProduto> imagens, List<Categoria> categorias, BigDecimal preco) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.imagens = imagens;
    this.categorias = categorias;
    this.preco = preco;
  }

  private Long id;

  private String nome;

  private String descricao;
  
  private BigDecimal preco;

  private List<ImagemProduto> imagens;

  private List<Categoria> categorias;

  private List<ItemCompra> itensCompra;

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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<ImagemProduto> getImagens() {
    return imagens;
  }

  public void setImagens(List<ImagemProduto> imagens) {
    this.imagens = imagens;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public List<ItemCompra> getItensCompra() {
    return itensCompra;
  }

  public void setItensCompra(List<ItemCompra> itensCompra) {
    this.itensCompra = itensCompra;
  }

}
