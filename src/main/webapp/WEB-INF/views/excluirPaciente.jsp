<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>

		<title>Sistema Hospital - Excluír Paciente</title>
	</head>

	<body>
		<div align="center">
        <h1>Excluír Paciente</h1>
        <br />
	        <form id="pacientes" action="/pacientes/excluir" method = "POST" modelAttribute="excluirPaciente">
				<table border="0" cellpadding="10">
					<tr>
						<td>CPF: </td>
						<td><input name="cpf"/></td>
					</tr>
			
					<tr>
						<td>Nome: </td>
						<td><input name="nome"/></td>
					</tr>
					
					<tr>
						<td>Codigo do Convênio: </td>
						<td><input name="convenio"/></td>
					</tr>
					
			        <tr>
			            <td colspan="2"><button type="submit">Excluír</button> </td>
			        </tr>
		        </table>
	        </form>
	        
	        <form id="pacientes" action="/pacientes" method = "GET">
				<button type="submit">Paciêntes</button>
			</form>
		</div>
	</body>
</html>