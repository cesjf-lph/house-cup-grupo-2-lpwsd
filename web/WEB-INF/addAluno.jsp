<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp" %>
<h1>Formulário</h1>
<form action="cadastrarAluno.html" method="POST">
    <div>
        <label>Nome completo:</label>
        <input name="nome" />
    </div>
    <div>
        <label>Matrícula:</label>
        <input name="matricula" />
    </div>
    <div>
        <label>Escolha o grupo:<select name="grupo">
                <c:forEach var="grupo" items="${grupos}">
                    <option value="${grupo.id}">${grupo.numero}</option>
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