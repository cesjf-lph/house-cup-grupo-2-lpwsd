<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem Vindo</title>
    </head>
    <body>
        <h1>Menu</h1>
        <form action="menu.html" method="POST">
          <h1>Seja bem-vindo!</h1>
                <a href="addAluno.jsp">Clique para adicionar Alunos</a><br>
                <a href="addProfessor.jsp">Clique para adicionar Professores</a><br>
                <a href="listarAlunos.jsp">Clique para listar de Alunos</a><br>
                <a href="listarHistoricos.jsp">Clique para listar Históricos</a><br>
                <a href="listarProfessores.jsp">Clique para listar Professores</a><br>
                <a href="pesquisarPeriodo.jsp">Clique para pesquisar por Períodos</a><br>
                <a href="pontuarAluno.jsp">Clique para pontuar Alunos</a><br>
        </form>
    </body>
</html>