<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
			body {
			    background-image: url("../images/Fundo.jpg");
			    background-repeat: no-repeat;
				background-size: cover;
			}
		</style>
		<title>Sistema Hospital - Equipamentos</title>
	    <link href="base.css" type="text/css" rel="stylesheet">
	</head>

	<body background="img_girl.jpg">
		<div align="center">
        <h1>Equipamentos</h1>
        <br/>
			<table border="1">
				<tr>
					<td><strong>Código</strong></td>
					<td><strong>Nome</strong></td>
				</tr>
				<c:forEach var="equipamento" items="${equipamentos}">
					<tr>
						<form id="excluir" action="/equipamentos" method="POST" modelAttribute="equipamentoSelecionado">
							<td width="10px"><input name="codigo" value="${equipamento.codigo}" readonly/></td>
							<td width="10px"><input name="nome" value="${equipamento.nome}" readonly/></td>
							<td style="padding: 7px;">
								<input id="excluir" type="image" alt="submit" src="../images/Deletar.png" onclick="form.action='/equipamentos/excluir';"/>
							</td>
							<td style="padding: 7px;">
								<input type="image" alt="submit" src="../images/Inserir.png" id="editar" type="submit" onclick="form.action='/equipamentos/editar-equipamento';"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoEquipamento" action="/equipamentos/novo-equipamento" method = "GET">
				<button type="submit">Novo Equipamento</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>