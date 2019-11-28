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
        	<table>
   				<tr>
			    	<td>| CPF</td>
			    	<td>| NOME |</td>
			    	<td>CONVENIO |</td>
		    	</tr>
	    	</table>
       		<c:forEach items="${pacientes}" var="paciente">
       			<table>
       				<tr>
				    	<td><c:out value="| ${paciente.cpf}"/></td>
				    	<td><c:out value="| ${paciente.nome} |"/></td>
				    	<td><c:out value="${paciente.convenio} |"/></td>
				    </tr>
			    </table>
			</c:forEach>
			
			<form id="pacientes" action="/pacientes/novo-paciente" method = "GET">
				<button type="submit">Novo Paciênte</button>
			</form>
			
			<form id="pacientes" action="/pacientes/excluir-paciente" method = "GET">
				<button type="submit">Excluír Paciênte</button>
			</form>
		</div>
	</body>
</html>