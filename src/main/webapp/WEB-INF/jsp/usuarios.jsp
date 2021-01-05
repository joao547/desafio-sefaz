<%@ page import="victor.joao.sefaz.model.Usuario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: joao-victor
  Date: 31/12/2020
  Time: 02:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de usuarios</title>
</head>
<body>
    <table>
        <thead>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
        </thead>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
