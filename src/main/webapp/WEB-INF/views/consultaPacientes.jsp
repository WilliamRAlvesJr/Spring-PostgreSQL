<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Pacientes</title>
	    <link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body background="img_girl.jpg">
		<div align="center">
        <h1>Pacientes</h1>
        <br/>
			<table border="0">
				<tr>
					<td><strong>Ct. Saúde</strong></td>
					<td><strong>CPF</strong></td>
					<td><strong>Nome</strong></td>
					<td hidden="true"><strong>Telefone</strong></td>
					<td><strong>Convênio</strong></td>
				</tr>
				<c:forEach var="paciente" items="${pacientes}">
					<tr>
						<form id="excluir" action="/pacientes" method="POST" modelAttribute="pacienteSelecionado">
							<td><input name="ctSaude" value="${paciente.ctSaude}" readonly/></td>
							<td><input name="cpf" value="${paciente.cpf}" readonly/></td>
							<td><input name="nome" value="${paciente.nome}" readonly/></td>
							<td><input name="convenio" value="${paciente.convenio}" readonly/></td>
							<td><input hidden="true" name="telefone" value="${paciente.telefone}" readonly/></td>
							<td style="padding: 7px;">
								<input id="excluir" type="image" alt="submit" src="../images/Deletar.png" onclick="form.action='/pacientes/excluir';"/>
							</td>
							<td style="padding: 7px;">
								<input type="image" alt="submit" src="../images/Inserir.png" id="editar" type="submit" onclick="form.action='/pacientes/editar-paciente';"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoPacientes" action="/pacientes/novo-paciente" method = "GET">
				<button type="submit">Novo Paciente</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>