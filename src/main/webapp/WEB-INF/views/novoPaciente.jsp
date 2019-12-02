<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Adicionar/Editar Paciente</title>
		<link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<div align="center">
        	<h1>Adicionar/Editar Paciente</h1>
        	<br />
        	<form id="error" method = "GET">
        		<td width="10px"><input name="erro" value="${erro}" readonly
        			style="color: red;font-weight: bold;background: border-box;width: 500px;border: 100px; text-align: center;" /></td>
        	</form>
        	<br />
	        <form id="pacientes" action="/pacientes/salvar" method = "POST" modelAttribute="pacientes">
				<table border="0" cellpadding="10">

					<tr>
						<td>Ct. Saúde: </td>
						<td><input name="ctSaude" value="${ctSaude}"/></td>
					</tr>
					
					<tr>
						<td>CPF: </td>
						<td><input name="cpf" value="${cpf}"/></td>
					</tr>
			
					<tr>
						<td>Nome: </td>
						<td><input name="nome" value="${nome}"/></td>
					</tr>
					
					<tr>
						<td>Telefone: </td>
						<td><input name="telefone" value="${telefone}"/></td>
					</tr>
					
					<tr>
						<td>Codigo do Convênio: </td>
						<td><input name="convenio" value="${convenio}"/></td>
					</tr>
					
			        <tr>
			            <td colspan="2"><button type="submit">Salvar</button> </td>
			        </tr>
		        </table>
	        </form>
	        
	        <form id="pacientes" action="/pacientes" method = "GET">
				<br />
				<button type="submit">Paciêntes</button>
			</form>
		</div>
	</body>
</html>