<%-- 
    Document   : pesquisarPeriodo
    Created on : 14/09/2016, 21:50:20
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp" %>
        <h1>Pesquisar resultados</h1>
        <form action="listarPorPeriodo.html" method="POST">
            <div>
                <label>Escolha o período:
                        <select name = "periodos">
                        <c:forEach var="data" items="${datas}">
                            <option value="${data}">${data}</option> 
                        </c:forEach>
                        </select>
                
                </label>
            </div>
            <div>
                <input type="submit" value="Enviar" />
            </div>
        </form>

    </body>
</html>
