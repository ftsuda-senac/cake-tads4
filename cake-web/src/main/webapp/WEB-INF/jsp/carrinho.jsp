<%-- 
    Document   : carrinho
    Created on : 30/08/2015, 16:05:28
    Author     : Fernando
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <div>
      <header>
        <h1>CakeWeb</h1>
      </header>
      <div>
        <h4>Produtos adicionados no carrinho</h4>
        <table>
          <tr>
            <th>Data inclusão</th>
            <th>Produto</th>
            <th>Preço</th>
          </tr>
          <c:forEach items="${sessionScope.carrinho}" var="prodCarr">
            <tr>
              <td><fmt:formatDate value="${prodCarr.dataInclusao}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
              <td>${prodCarr.produto.nome}</td>
              <td><fmt:formatNumber value="${prodCarr.produto.preco}" type="currency" /></td>
            </tr>
          </c:forEach>
        </table>

      </div>
    </div>
  </body>
</html>
