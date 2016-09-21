<%-- 
    Document   : listarProfessores
    Created on : 30/08/2016, 18:14:34
    Author     : aluno
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp" %>
<h1>Lista de Alunos:</h1>
<c:forEach var="professor" items="${professores}">
    <p><label>Nome: </label><c:out value="${professor.nome}" /></p>
    <hr />
</c:forEach>
</body>
</html>
