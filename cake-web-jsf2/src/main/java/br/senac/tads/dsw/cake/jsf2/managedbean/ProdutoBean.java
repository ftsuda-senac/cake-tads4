/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.cake.jsf2.managedbean;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.entity.ImagemProduto;
import br.senac.tads.cake.common.entity.Produto;
import br.senac.tads.cake.common.service.CategoriaService;
import br.senac.tads.cake.common.service.ProdutoService;
import br.senac.tads.cake.common.service.fakeimpl.CategoriaServiceFakeImpl;
import br.senac.tads.cake.common.service.fakeimpl.ProdutoServiceFakeImpl;
import br.senac.tads.cake.common.service.jpaimpl.CategoriaServiceJPAImpl;
import br.senac.tads.cake.common.service.jpaimpl.ProdutoServiceJPAImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.Part;

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
  
  private Part imagem;
  
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
  
  public Part getImagem() {
    return imagem;
  }
  
  public void setImagem(Part imagem) {
    this.imagem = imagem;
  }
  
  public String salvar() {
    Produto p = new Produto();
    CategoriaService cServ = new CategoriaServiceJPAImpl();
    
    p.setNome(nome);
    p.setDescricao(descricao);
    List<Categoria> listaCategorias = new ArrayList<Categoria>();
    for (Long idCat : idsCategorias) {
      Categoria cat = cServ.obter(idCat);
      listaCategorias.add(cat);
      cat.setProdutos(Arrays.asList(p));
    }
    p.setCategorias(listaCategorias);
    p.setPreco(preco);
    p.setDtCadastro(new Date());
    
    ImagemProduto imagem = new ImagemProduto();
    String nomeArquivo = obterNomeArquivo();
    if (nomeArquivo != null && nomeArquivo.trim().length() > 0) {
      salvarImagem(nomeArquivo);
      imagem.setNomeArquivo(nomeArquivo);
      imagem.setProduto(p);
      p.setImagens(Arrays.asList(imagem));
    }
    
    ProdutoService produtoService = new ProdutoServiceJPAImpl();
    produtoService.incluir(p);
    
    pTemp = p;
    
    Flash flash = FacesContext.getCurrentInstance()
            .getExternalContext().getFlash();
    flash.put("msg", "Produto cadastrado com sucesso");
    flash.put("prod", pTemp);
    
    return "lista.xhtml?faces-redirect=true";
  }
  
  private String obterNomeArquivo() {
    if (imagem != null) {
      String partHeader = imagem.getHeader("content-disposition");
      for (String content : partHeader.split(";")) {
        if (content.trim().startsWith("filename")) {
          String nomeArquivo = content.substring(content.indexOf('=') + 1)
                  .trim().replace("\"", "");
          int lastFilePartIndex = nomeArquivo.lastIndexOf("\\");
          if (lastFilePartIndex > 0) {
            return nomeArquivo.substring(lastFilePartIndex, nomeArquivo.length());
          }
          return nomeArquivo;
        }
      }
    }
    return null;
  }
  
  private void salvarImagem(String nomeImagem) {
    String diretorioDestino = "C:" + File.separator + "desenv"
            + File.separator + "imagens" + File.separator;
    File arquivo = new File(diretorioDestino + nomeImagem);
    
    InputStream inputStream = null;
    OutputStream outputStream = null;
    
    try {
      inputStream = imagem.getInputStream();
      outputStream = new FileOutputStream(arquivo);
      
      int read = 0;
      final byte[] bytes = new byte[1024];
      while ((read = inputStream.read(bytes)) != -1) {
        outputStream.write(bytes, 0, read);
      }
    } catch (IOException e) {
      //TODO: LOGAR ERRO
    } finally {
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e) {
          //TODO: LOGAR ERRO
        }
      }
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          //TODO: LOGAR ERRO
        }
      }
    }
  }
  
  public Produto getProdutoTemp() {
    return pTemp;
  }
  
}
