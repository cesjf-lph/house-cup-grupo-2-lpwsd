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
                <label>Insira o número de pontos:
                    <input type="text" name="pontos" />
                </label>
            </div>
            <div>

                <input type="hidden" name="a_id" value="${id}"/>

            </div>
            <div>
                <input type="submit" />                              
            </div>
        </form>
    </body>
</html>
