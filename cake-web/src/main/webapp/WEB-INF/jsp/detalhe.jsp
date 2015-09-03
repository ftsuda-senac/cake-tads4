<%-- 
    Document   : detalhe
    Created on : 30/08/2015, 16:05:18
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
      .produto .imagem img {
        width: 100%;
      }
      .produto .imagem {
        max-width: 600px;
      }
    </style>
  </head>
  <body>
    <div>
      <header>
        <h1>CakeWeb</h1>
      </header>
      <div>
        <div id="categorias">
          <h4>Categorias</h4>
          <c:forEach items="${listaCategorias}" var="categoria">
            <p><a href="#"><c:out value="${categoria.nome}" /></a></p>
            </c:forEach>
            <c:if test="${empty listaCategorias}">
            <p>Nenhuma categoria encontrada</p>
          </c:if>
        </div>
        <div id="conteudo">
          <c:choose>
            <c:when test="${not empty produto}">
              <div id="produto">
                <div class="imagem">
                  <img src="resources/img/bolo.jpg" alt="bolo" /> <!-- ACHAR E USAR IMAGENS MAIS ADEQUADAS -->
                </div>
                <h2>${produto.nome}</h2>
                <h3>Descrição:</h3>
                <p>${produto.descricao}</p>
                <h3>Categorias:</h3>
                <p>
                  <c:forEach items="${produto.categorias}" var="cat">
                    <span><a href="#">${cat.nome}</a></span>
                    </c:forEach>
                </p>
                <h3>Preço:</h3>
                <p><fmt:formatNumber value="${produto.preco}" type="currency" /></p>
                <form action="CarrinhoServlet" method="post" enctype="application/x-www-form-urlencoded">
                  <input type="hidden" name="id" value="${produto.id}" />
                  <input type="submit" value="Adicionar ao carrinho" />
                </form>
                <p><a href="ListaServlet">Voltar</a></p>
              </div>
            </c:when>
            <c:otherwise>
              <p>Nenhum produto encontrado</p>
              <a href="ListaServlet">Voltar</a>
            </c:otherwise>
          </c:choose>
        </div>
        <div id="opcoes">
          <c:if test="${not empty sessionScope.usuario}">
            <p>Usuario [NOME USUÁRIO]</p>
          </c:if>

          <c:choose>
            <c:when test="${not empty sessionScope.carrinho}"> <%-- CORRIGIR A CONDIÇÃO --%>
              <c:choose>
                <c:when test="${fn:length(sessionScope.carrinho) == 0}">
                  <p>Seu carrinho está vazio.</p>
                </c:when>
                <c:when test="${fn:length(sessionScope.carrinho) == 1}">
                  <p>Você tem 1 item no carrinho.<a href="CarrinhoServlet">Ver carrinho</a></p>
                </c:when>
                <c:otherwise>
                  <p>Você tem ${fn:length(sessionScope.carrinho)} itens no carrinho. <a href="CarrinhoServlet">Ver carrinho</a></p>
                </c:otherwise>
              </c:choose>
            </c:when>
            <c:otherwise>
              <p>Seu carrinho está vazio.</p>
            </c:otherwise>
          </c:choose>
          <h4>Opções</h4>
          <form method="post" action="busca" enctype="application/x-www-form-urlencoded">
            <input type="text" placeholder="Digite um texto para busca" name="termo" />
            <input type="submit" value="Buscar" />
          </form>
        </div>
      </div>
    </div>
  </body>
</html>

