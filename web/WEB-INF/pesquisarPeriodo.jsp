<%-- 
    Document   : pesquisarPeriodo
    Created on : 14/09/2016, 21:50:20
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pesquisar resultados</h1>
        <div>
            <label>Escolha o grupo:<select name="grupo">
                    <c:forEach var="grupo" items="${grupos}">
                        <option value="${grupo.id}">${grupo.numero}</option>
                    </c:forEach>
                </select>
            </label>
        </div>
        <div>
            
        </div>
                    
    </body>
</html>
