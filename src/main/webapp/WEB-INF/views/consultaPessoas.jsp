<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Pessoas</title>
	    <link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body background="img_girl.jpg">
		<div align="center">
        <h1>Pessoas</h1>
        <br/>
			<table border="0">
				<tr>
					<td><strong>CPF</strong></td>
					<td><strong>Nome</strong></td>
					<td><strong>Telefone</strong></td>
				</tr>
				<c:forEach var="pessoas" items="${pessoas}">
					<tr>
						<form id="excluir" action="/pessoas" method="POST" modelAttribute="pessoaSelecionado">
							<td><input name="cpf" value="${pessoas.cpf}" readonly/></td>
							<td><input name="nome" value="${pessoas.nome}" readonly/></td>
							<td><input name="telefone" value="${pessoas.telefone}" readonly/></td>
							<td style="padding: 7px;">
								<input id="excluir" type="image" alt="submit" src="../images/Deletar.png" onclick="form.action='/pessoas/excluir';"/>
							</td>
							<td style="padding: 7px;">
								<input id="editor" type="button" value="Inativo" style="border: 0px; background: bottom; color: black;"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoPessoa" action="/pessoas/novo-pessoa" method = "GET">
				<button disabled="disabled">Nova Pessoa</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>