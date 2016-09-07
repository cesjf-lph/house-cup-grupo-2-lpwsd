<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : pontuarAluno
    Created on : 06/09/2016, 21:03:43
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pontuar</title>
    </head>
    <body>
        <h1>Pontuar</h1>
        <form method="post">
            <div>
                <label>Escolha o professor:<select name="professor">
                        <c:forEach var="p" items="${profs}">
                            <option value="${p.id}">${p.nome}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div>
                <label>Escolha o aluno:<select name="aluno">
                        <c:forEach var="a" items="${alus}">
                            <option value="${a.id}">${a.nome}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div>
                <label>Insira o número de pontos:
                    <input type="number" name="pontos" value="10" />
                </label>
            </div>
            <div>
                <label>Descrição:
                    <textarea name="descricao"></textarea>
                </label>
            </div>
            <div>
                <input type="submit" />                              
            </div>
        </form>
    </body>
</html>
