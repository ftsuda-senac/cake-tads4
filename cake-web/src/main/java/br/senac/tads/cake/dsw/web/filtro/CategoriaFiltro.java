/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.dsw.web.filtro;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.service.CategoriaService;
import br.senac.tads.cake.common.service.fakeimpl.CategoriaServiceFakeImpl;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Fernando
 */
@WebFilter(filterName = "CategoriaFiltro", urlPatterns = {"/*"})
public class CategoriaFiltro implements Filter {

  public CategoriaFiltro() {
  }

  /**
   * Filtro usado para carregar as categorias, que sao valores comuns
   * que devem ser exibidos em quase todas as telas.
   * TODO: Melhorar isso.
   * 
   * @param request The servlet request we are processing
   * @param response The servlet response we are creating
   * @param chain The filter chain we are processing
   *
   * @exception IOException if an input/output error occurs
   * @exception ServletException if a servlet error occurs
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {

    HttpServletRequest httpReq = (HttpServletRequest) request;
    ServletContext context = httpReq.getSession().getServletContext();

    CategoriaService categoriaService = new CategoriaServiceFakeImpl();
    List<Categoria> categorias = categoriaService.listar();
    context.setAttribute("listaCategorias", categorias);

    Throwable problem = null;
    try {
      chain.doFilter(request, response);
    } catch (Throwable t) {
      // If an exception is thrown somewhere down the filter chain,
      // we still want to execute our after processing, and then
      // rethrow the problem after that.
      problem = t;
      t.printStackTrace();
    }
  }

  /**
   * Destroy method for this filter
   */
  @Override
  public void destroy() {
  }

  /**
   * Init method for this filter
   *
   * @param filterConfig
   */
  @Override
  public void init(FilterConfig filterConfig) {

  }

}
