/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class Compra implements Serializable {
  
  private Long id;
  
  private Date dataCompra;
  
  private Cliente usuario;
  
  private List<ItemCompra> itensCompra;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDataCompra() {
    return dataCompra;
  }

  public void setDataCompra(Date dataCompra) {
    this.dataCompra = dataCompra;
  }

  public Cliente getUsuario() {
    return usuario;
  }

  public void setUsuario(Cliente usuario) {
    this.usuario = usuario;
  }

  public List<ItemCompra> getItensCompra() {
    return itensCompra;
  }

  public void setItensCompra(List<ItemCompra> itensCompra) {
    this.itensCompra = itensCompra;
  }
    
}
