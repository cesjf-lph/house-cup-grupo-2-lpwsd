<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp" %>
        <h1>Formulário</h1>
        <form action="cadastrarProfessor.html" method="POST">
            <div>
                <label>Nome completo:</label>
                <input name="nome" />
            </div>
            <div>
                <input type="submit" value="Enviar" />
            </div>
        </form>
    </body>
</html>
