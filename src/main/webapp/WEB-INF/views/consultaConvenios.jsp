<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Convênios</title>
	    <link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body background="img_girl.jpg">
		<div align="center">
        <h1>Convênios</h1>
        <br/>
			<table border="0">
				<tr>
					<td><strong>Código</strong></td>
					<td><strong>Nome</strong></td>
				</tr>
				<c:forEach var="convenio" items="${convenios}">
					<tr>
						<form id="excluir" action="/convenios" method="POST" modelAttribute="convenioSelecionado">
							<td><input name="codigo" value="${convenio.codigo}" readonly/></td>
							<td><input name="nome" value="${convenio.nome}" readonly/></td>
							<td style="padding: 7px;">
								<input id="excluir" type="image" alt="submit" src="../images/Deletar.png" onclick="form.action='/convenios/excluir';"/>
							</td>
							<td style="padding: 7px;">
								<input type="image" alt="submit" src="../images/Inserir.png" id="editar" type="submit" onclick="form.action='/convenios/editar-convenio';"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoConvenio" action="/convenios/novo-convenio" method = "GET">
				<button type="submit">Novo Convênio</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>