<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Quartos</title>
	    <link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body background="img_girl.jpg">
		<div align="center">
        <h1>Quartos</h1>
        <br/>
			<table border="0">
				<tr>
					<td><strong>Código</strong></td>
					<td><strong>Nome</strong></td>
					<td><strong>Setor</strong></td>
					<td><strong>Equipamento</strong></td>
				</tr>
				<c:forEach var="quarto" items="${quartos}">
					<tr>
						<form id="excluir" action="/quartos" method="POST" modelAttribute="quartoSelecionado">
							<td><input name="codigo" value="${quarto.codigo}" readonly/></td>
							<td><input name="nome" value="${quarto.nome}" readonly/></td>
							<td><input name="setor" value="${quarto.setor}" readonly/></td>
							<td><input name="equipamento" value="${quarto.equipamento}" readonly/></td>
							<td style="padding: 7px;">
								<input id="excluir" type="image" alt="submit" src="../images/Deletar.png" onclick="form.action='/quartos/excluir';"/>
							</td>
							<td style="padding: 7px;">
								<input type="image" alt="submit" src="../images/Inserir.png" id="editar" type="submit" onclick="form.action='/quartos/editar-quarto';"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoQuarto" action="/quartos/novo-quarto" method = "GET">
				<button type="submit">Novo Quarto</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>