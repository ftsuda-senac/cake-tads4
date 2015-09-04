/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.dsw.web.servlet;

import br.senac.tads.cake.common.entity.Produto;
import br.senac.tads.cake.common.service.ProdutoService;
import br.senac.tads.cake.common.service.fakeimpl.ProdutoServiceFakeImpl;
import br.senac.tads.cake.dsw.web.entity.ProdutoCarrinho;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "CarrinhoServlet", urlPatterns = {"/CarrinhoServlet"})
public class CarrinhoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/carrinho.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession sessao = request.getSession();

    String ip = request.getRemoteAddr();
    sessao.setAttribute("userip", ip);

    String idStr = request.getParameter("id");
    Long id = Long.parseLong(idStr);

    ProdutoService produtoService = new ProdutoServiceFakeImpl();
    Produto prod = produtoService.obter(id);

    ProdutoCarrinho prodCarrinho = new ProdutoCarrinho(prod, new Date());
    List<ProdutoCarrinho> carrinho = 
            (List<ProdutoCarrinho>) sessao.getAttribute("carrinho");
    if (carrinho == null) {
      carrinho = new ArrayList<ProdutoCarrinho>();
      sessao.setAttribute("carrinho", carrinho);
    }
    carrinho.add(prodCarrinho);

    //response.sendRedirect("ListaServlet");
    RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaServlet");
    dispatcher.forward(request, response);

  }
}
