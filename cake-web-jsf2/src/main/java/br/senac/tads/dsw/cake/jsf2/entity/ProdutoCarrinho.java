/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.cake.jsf2.entity;

import br.senac.tads.cake.common.entity.Produto;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Fernando
 */
public class ProdutoCarrinho implements Serializable {

  private Produto produto;

  private Date dataInclusao;

  public ProdutoCarrinho() {
  }

  public ProdutoCarrinho(Produto produto, Date dataInclusao) {
    this.produto = produto;
    this.dataInclusao = dataInclusao;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Date getDataInclusao() {
    return dataInclusao;
  }

  public void setDataInclusao(Date dataInclusao) {
    this.dataInclusao = dataInclusao;
  }

}
