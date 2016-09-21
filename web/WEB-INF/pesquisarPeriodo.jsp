<%-- 
    Document   : pesquisarPeriodo
    Created on : 14/09/2016, 21:50:20
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp" %>
        <h1>Pesquisar resultados</h1>
        <form action="pesquisar.html" method="POST">
            <div>
                <label>Escolha o período:<select name="pesquisa">
                        <option value="0">1º Semestre de 2014</option>
                        <option value="1">2º Semestre de 2014</option>
                        <option value="2">1º Semestre de 2015</option>
                        <option value="3">2º Semestre de 2015</option>
                        <option value="4">1º Semestre de 2016</option>
                        <option value="5">2º Semestre de 2016</option>
                    </select>
                </label>
            </div>
            <div>
                <input type="submit" value="Enviar" />
            </div>
        </form>

    </body>
</html>
