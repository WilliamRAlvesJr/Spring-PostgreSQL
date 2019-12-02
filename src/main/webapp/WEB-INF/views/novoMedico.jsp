<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Adicionar/Editar Medicos</title>
		<link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<div align="center">
        	<h1>Adicionar/Editar Medicos</h1>
        	<form id="error" method = "GET">
        		<td width="10px"><input name="erro" value="${erro}" readonly 
        			style="color: red;font-weight: bold;background: border-box;width: 500px;border: 100px; text-align: center;" /></td>
        	</form>
	        <form id="medicos" action="/medicos/salvar" method = "POST" modelAttribute="medicos">
				<table border="0" cellpadding="10">

					<tr>
						<td>CPF: </td>
						<td><input name="cpf" value="${cpf}"/></td>
					</tr>
					
					<tr>
						<td>CRM: </td>
						<td><input name="crm" value="${crm}"/></td>
					</tr>
					
					<tr>
						<td>Código: </td>
						<td><input name="codigo" value="${codigo}"/></td>
					</tr>
					
					<tr>
						<td>Telefone: </td>
						<td><input name="telefone" value="${telefone}"/></td>
					</tr>
			
					<tr>
						<td>Nome: </td>
						<td><input name="nome" value="${nome}"/></td>
					</tr>
					
					<tr>
						<td>Data de Admissão: </td>
						<td><input type="date" name="dtAdmissao" value="${dtAdmissao}"/></td>
					</tr>

					<tr>
						<td>Especialidade: </td>
						<td><input name="especialidade" value="${especialidade}"/></td>
					</tr>
					
					<tr>
						<td>Setor: </td>
						<td><input name="setor" value="${setor}"/></td>
					</tr>
					
			        <tr>
			            <td colspan="2"><button type="submit">Salvar</button> </td>
			        </tr>
		        </table>
	        </form>
	        
	        <form id="medicos" action="/medicos" method = "GET">
				<br />
				<button type="submit">Medicos</button>
			</form>
		</div>
	</body>
</html>