<%-- 
    Document   : listarProfessores
    Created on : 30/08/2016, 18:14:34
    Author     : aluno
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp" %>
<h1>Lista de Grupos:</h1>
<c:forEach var="grupo" items="${grupo}">
    <p><label>Grupo: </label><c:out value="${grupo[0].getNumero()}" /></p>
    <p><label>Pontos: </label><c:out value="${grupo[1]}" /></p>
    <hr />
</c:forEach>
</body>
</html>
