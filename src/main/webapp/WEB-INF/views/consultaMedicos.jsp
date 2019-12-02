<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital - Medicos</title>
	    <link href="../base.css" type="text/css" rel="stylesheet">
	</head>

	<body background="img_girl.jpg">
		<div align="center">
        <h1>Medicos</h1>
        <br/>
			<table border="0">
				<tr>
					<td hidden="true"><strong>CPF</strong></td>
					<td><strong>Nome</strong></td>
					<td><strong>CRM</strong></td>
					<td hidden="true"><strong>Telefone</strong></td>
					<td hidden="true"><strong>Código</strong></td>
					<td hidden="true"><strong>Admissão</strong></td>
					<td><strong>Especialidade</strong></td>
					<td><strong>Setor</strong></td>
				</tr>
				<c:forEach var="medicos" items="${medicos}">
					<tr>
						<form id="excluir" action="/medicos" method="POST" modelAttribute="medicoSelecionado">
							<td hidden="true"><input name="cpf" value="${medicos.cpf}" readonly/></td>
							<td><input name="nome" value="${medicos.nome}" readonly/></td>
							<td><input name="crm" value="${medicos.crm}" readonly/></td>
							<td hidden="true"><input name="telefone" value="${medicos.telefone}" readonly/></td>
							<td hidden="true"><input name="codigo" value="${medicos.codigo}" readonly/></td>
							<td hidden="true"><input type="date" name="dtAdmissao" value="${medicos.dtAdmissao}" readonly/></td>
							<td><input name="especialidade" value="${medicos.especialidade}" readonly/></td>
							<td><input name="setor" value="${medicos.setor}" readonly/></td>
							<td style="padding: 7px;">
								<input id="excluir" type="image" alt="submit" src="../images/Deletar.png"onclick="form.action='/medicos/excluir';""/>
							</td>
							<td style="padding: 7px;">
								<input type="image" alt="submit" src="../images/Inserir.png" id="editar" type="submit" onclick="form.action='/medicos/editar-medico';"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoMedico" action="/medicos/novo-medico" method = "GET">
				<button type="submit">Novo Medico</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>