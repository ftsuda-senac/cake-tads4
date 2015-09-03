/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.dsw.web.servlet;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.entity.Produto;
import br.senac.tads.cake.common.service.CategoriaService;
import br.senac.tads.cake.common.service.ProdutoService;
import br.senac.tads.cake.common.service.fakeimpl.CategoriaServiceFakeImpl;
import br.senac.tads.cake.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ListaServlet", urlPatterns = {"/ListaServlet"})
public class ListaServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    ProdutoService produtoService = new ProdutoServiceFakeImpl();
    List<Produto> produtos = produtoService.listar(0, 100);
    request.setAttribute("listaProdutos", produtos);

    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/lista.jsp");
    dispatcher.forward(request, response);
  }
}
