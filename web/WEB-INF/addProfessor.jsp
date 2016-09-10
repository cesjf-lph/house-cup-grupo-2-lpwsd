<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo professor</title>
    </head>
    <body>
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
