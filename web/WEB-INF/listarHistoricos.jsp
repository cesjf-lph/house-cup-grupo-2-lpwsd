<%-- 
    Document   : listarHistoricos
    Created on : 09/09/2016, 22:02:27
    Author     : aluno
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Históricos</title>
    </head>
    <body>
        <h1>Histórico:</h1>
         <a href="pontuar.html">[Pontuar novo aluno]</a>
        <c:forEach var="historico" items="${historicos}">
            <p><label>Data: </label><c:out value="${historico.data}" /></p>
            <p><label>Aluno: </label><c:out value="${historico.aluno.nome}" /></p>
            <p><label>Professor: </label><c:out value="${historico.professor.nome}" /></p>
            <p><label>Pontos: </label><c:out value="${historico.pontos}" /></p>
            <p><label>Descrição: </label><c:out value="${historico.descricao}" /></p>
            <hr />
        </c:forEach>
    </body>
</html>
