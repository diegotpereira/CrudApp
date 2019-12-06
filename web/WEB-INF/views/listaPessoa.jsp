<%-- 
    Document   : listaPessoa
    Created on : 05/12/2019, 22:34:16
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Pessoa</title>
    </head>
    <body>
            <a href="cadastroPessoa">Novo</a>
            <br /> <br />
            <table>
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>E-mail</th>
            </tr>
            <c:forEach items="${pessoas}" var="pessoa">
            <tr>
            <td>${pessoa.id}</td>
            <td>${pessoa.nome}</td>
            <td>${pessoa.cpf}</td>
            <td>${pessoa.email}</td>
            </tr>
            <td><a href="removePessoa?id=${pessoa.id}">Remover</a></td>
            <td><a href="editarPessoa?id=${pessoa.id}">Alterar</a></td>
            </c:forEach>
            </table>
    </body>
</html>
