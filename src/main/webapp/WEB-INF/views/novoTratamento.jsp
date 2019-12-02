<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Adicionar/Editar Tratamento</title>
		<link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<div align="center">
        	<h1>Adicionar/Editar Tratamento</h1>
        	<br />
        	<form id="error" method = "GET">
        		<td width="10px"><input name="erro" value="${erro}" readonly 
        			style="color: red;font-weight: bold;background: border-box;width: 500px;border: 100px; text-align: center;" /></td>
        	</form>
        	<br />
	        <form id="tratamentos" action="/tratamentos/salvar" method = "POST" modelAttribute="tratamentos">
				<table border="0" cellpadding="10">

					<tr>
						<td>Medico: </td>
						<td><input name="medico" value="${medico}"/></td>
					</tr>
					
					<tr>
						<td>Paciente: </td>
						<td><input name="paciente" value="${paciente}"/></td>
						</td>
					</tr>
					
					<tr>
						<td>Quarto: </td>
						<td><input name="quarto" value="${quarto}"/></td>
					</tr>
					
					<tr>
						<td>Equipamento: </td>
						<td><input name="equipamento" value="${equipamento}"/></td>
					</tr>
					
					<tr>
						<td>Entrada: </td>
						<td><input type="date" name="dtEntrada" value="${dtEntrada}"/></td>
					</tr>
					
					<tr>
						<td>Saída: </td>
						<td><input type="date" name="dtSaida" value="${dtSaida}"/></td>
					</tr>
					
			        <tr>
			            <td colspan="2"><button type="submit">Salvar</button> </td>
			        </tr>
		        </table>
	        </form>
	        
	        <form id="tratamentos" action="/tratamentos" method = "GET">
				<br />
				<button type="submit">Tratamentos</button>
			</form>
		</div>
	</body>
</html>