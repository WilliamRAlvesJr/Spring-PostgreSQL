<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Tratamentos</title>
	    <link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body background="img_girl.jpg">
		<div align="center">
        <h1>Tratamentos</h1>
        <br/>
			<table>
				<tr>
					<td><strong>Medico</strong></td>
					<td><strong>Paciente</strong></td>
					<td><strong>Quarto</strong></td>
					<td><strong>Equipamento</strong></td>
					<td><strong>Entrada</strong></td>
					<td hidden="true"><strong>Saída</strong></td>
				</tr>
				<c:forEach var="tratamento" items="${tratamentos}">
					<tr>
						<form id="excluir" action="/tratamentos" method="POST" modelAttribute="tratamentoSelecionado">
							<td><input name="medico" value="${tratamento.medico}" readonly/></td>
							<td><input name="paciente" value="${tratamento.paciente}" readonly/></td>
							<td><input name="quarto" value="${tratamento.quarto}" readonly/></td>
							<td><input name="equipamento" value="${tratamento.equipamento}" readonly/></td>
							<td><input type="date" name="dtEntrada" value="${tratamento.dtEntrada}" readonly/></td>
							<td hidden="true"><input type="date" name="dtSaida" value="${tratamento.dtSaida}" readonly/></td>
							<td style="padding: 7px;">
								<input id="excluir" type="image" alt="submit" src="../images/Deletar.png" onclick="form.action='/tratamentos/excluir';"/>
							</td>
							<td style="padding: 7px;">
								<input type="image" alt="submit" src="../images/Inserir.png" id="editar" type="submit" onclick="form.action='/tratamentos/editar-tratamento';"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoTratamento" action="/tratamentos/novo-tratamento" method = "GET">
				<button type="submit">Novo Tratamento</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>