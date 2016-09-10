<%-- 
    Document   : listarAlunos
    Created on : 30/08/2016, 18:14:34
    Author     : aluno
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Relação de Alunos!</title>
    </head>
    <body>
        <h1>Lista de Alunos:</h1>
         <a href="cadastrarAluno.html">[Adicionar Aluno]</a>
        <c:forEach var="aluno" items="${alunos}">
            <p><label>Nome: </label><c:out value="${aluno.nome}" /></p>
            <p><a href="pontuar.html?id=${aluno.id}">Pontuar</a></p>
            <p><a href="remover.html?id=${aluno.id}">Remover pontos</a></p>
            <hr />
        </c:forEach>
    </body>
</html>
