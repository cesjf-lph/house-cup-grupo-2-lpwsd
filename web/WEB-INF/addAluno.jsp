<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo aluno</title>
    </head>
    <body>
        <h1>Formulário</h1>
        <form action="add" method="POST">
            <div>
                <label>Nome completo:</label>
                <input name="nome" />
            </div>
            <div>
                <label>Idade:</label>
                <input name="idade" />
            </div>
            <div>
                <label>Matrícula:</label>
                <input name="matricula" />
            </div>
            <div>
                <input type="submit" value="Enviar" />
            </div>
        </form>
    </body>
</html>