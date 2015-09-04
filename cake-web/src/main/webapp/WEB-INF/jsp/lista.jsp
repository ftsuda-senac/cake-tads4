<%-- 
    Document   : lista
    Created on : 02/09/2015, 22:04:58
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          <c:forEach items="${applicationScope.listaCategorias}" var="categoria">
            <p><a href="#"><c:out value="${categoria.nome}" /></a></p>
          </c:forEach>
          <c:if test="${empty listaCategorias}">
            <p>Nenhuma categoria encontrada</p>
          </c:if>
        </div>
        <div id="conteudo">
          <c:forEach items="${listaProdutos}" var="produto">
            <div class="produto">
              <div class="imagem">
                <img src="resources/img/bolo.jpg" alt="bolo" /> <!-- ACHAR E USAR IMAGENS MAIS ADEQUADAS -->
              </div>
              <div class="info">
                <h2>${produto.nome}</h2>
                <p>${produto.descricao}</p>
                <p>
                  <c:forEach items="${produto.categorias}" var="cat">
                    <span><a href="#">${cat.nome}</a></span>
                  </c:forEach>
                </p>
                <p><a href="DetalheServlet?id=${produto.id}">Ver mais</a></p>
              </div>
            </div>
          </c:forEach>
          <c:if test="${empty listaProdutos}">
            <p>Nenhum produto encontrado</p>
          </c:if>
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
                  <p>Você tem ${fn:length(sessionScope.carrinho)} itens no carrinho.<a href="CarrinhoServlet">Ver carrinho</a></p>
                </c:otherwise>
              </c:choose>
            </c:when>
            <c:otherwise>
              <p>Seu carrinho está vazio.</p>
            </c:otherwise>
          </c:choose>
          <h4>Opções</h4>
          <form method="post" action="busca" enctype="application/x-www-form-urlencoded">
            <label>Buscar:</label>
            <input type="text" placeholder="Digite um texto para busca" name="termo" />
            <input type="submit" value="Buscar" />
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
