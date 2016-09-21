<%-- 
    Document   : listarAlunos
    Created on : 30/08/2016, 18:14:34
    Author     : aluno
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp" %>
<h1>Lista de Alunos:</h1>
<c:forEach var="aluno" items="${alunos}">
    <p><label>Nome: </label><c:out value="${aluno.nome}" /></p>
    <p><label>Grupo: </label><c:out value="${aluno.grupo.numero}" /></p>
    <p><a href="pontuar.html?id=${aluno.id}">Pontuar</a></p>
    <hr />
</c:forEach>
</body>
</html>
