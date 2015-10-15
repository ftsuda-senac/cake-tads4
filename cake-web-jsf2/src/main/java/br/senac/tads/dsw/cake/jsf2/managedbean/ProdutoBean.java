/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.cake.jsf2.managedbean;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.entity.Produto;
import br.senac.tads.cake.common.service.CategoriaService;
import br.senac.tads.cake.common.service.ProdutoService;
import br.senac.tads.cake.common.service.fakeimpl.CategoriaServiceFakeImpl;
import br.senac.tads.cake.common.service.fakeimpl.ProdutoServiceFakeImpl;
import br.senac.tads.cake.common.service.jpaimpl.CategoriaServiceJPAImpl;
import br.senac.tads.cake.common.service.jpaimpl.ProdutoServiceJPAImpl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@ManagedBean
@RequestScoped
public class ProdutoBean implements Serializable {

  @ManagedProperty(value = "#{param.id}") // Permite associar um parametro passado via URL na requisicao
  private Long idProd;

  private String nome;

  private String descricao;

  private List<Long> idsCategorias;

  private BigDecimal preco;

  private List<Produto> listaProdutos;

  private Produto pTemp;

  /**
   * Creates a new instance of ProdutoBean
   */
  public ProdutoBean() {
  }

  /**
   * @return the lista
   */
  public List<Produto> getLista() {
    ProdutoService service = new ProdutoServiceJPAImpl();
    setListaProdutos(service.listar(0, 100));
    return getListaProdutos();
  }

  public Produto getProduto() {
    /*
     String id = FacesContext.getCurrentInstance()
     .getExternalContext()
     .getRequestParameterMap().get("id");
                
     Long idProd = Long.parseLong(id);*/
    ProdutoService service = new ProdutoServiceJPAImpl();
    return service.obter(idProd);
  }

  public List<Produto> getListaProdutos() {
    return listaProdutos;
  }

  public void setListaProdutos(List<Produto> listaProdutos) {
    this.listaProdutos = listaProdutos;
  }

  public Long getIdProd() {
    return idProd;
  }

  public void setIdProd(Long idProd) {
    this.idProd = idProd;
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

  public List<Long> getIdsCategorias() {
    return idsCategorias;
  }

  public void setIdsCategorias(List<Long> idsCategorias) {
    this.idsCategorias = idsCategorias;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public String salvar() {
    Produto p = new Produto();
    CategoriaService cServ = new CategoriaServiceJPAImpl();

    p.setNome(nome);
    p.setDescricao(descricao);
    List<Categoria> listaCategorias = new ArrayList<Categoria>();
    for (Long idCat : idsCategorias) {
      listaCategorias.add(cServ.obter(idCat));
    }
    p.setCategorias(listaCategorias);
    p.setPreco(preco);
    p.setDtCadastro(new Date());
    
    ProdutoService produtoService = new ProdutoServiceJPAImpl();
    produtoService.incluir(p);
    
    pTemp = p;
    
    Flash flash = FacesContext.getCurrentInstance()
            .getExternalContext().getFlash();
    flash.put("msg", "Produto cadastrado com sucesso");
    flash.put("prod", pTemp);

    return "lista.xhtml?faces-redirect=true";
  }

  public Produto getProdutoTemp() {
    return pTemp;
  }
  
}
