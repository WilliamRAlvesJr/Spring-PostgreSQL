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
	</head>

	<body>
		<div align="center">
        <h1>Pacientes</h1>
        <br/>
			<table width="800" border="1">
				<tr>
					<td>CPF</td>
					<td>Nome</td>
					<td>Convênio</td>
				</tr>
				<c:forEach var="paciente" items="${pacientes}">
					<tr>
						<form id="excluir" action="/pacientes" method="POST" modelAttribute="pacienteSelecionado">
							<td width="10px"><input name="cpf" value="${paciente.cpf}" readonly/></td>
							<td width="10px"><input name="nome" value="${paciente.nome}" readonly/></td>
							<td width="10px"><input name="convenio" value="${paciente.convenio}" readonly/></td>
							<td width="10px">
								<input type="submit" value="Excluír" onclick="form.action='/pacientes/excluir';"/>
							</td>
							<td width="10px">
								<input type="submit" value="Editar" onclick="form.action='/pacientes/editar-paciente';"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoPacientes" action="/pacientes/novo-paciente" method = "GET">
				<button type="submit">Novo Paciênte</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>