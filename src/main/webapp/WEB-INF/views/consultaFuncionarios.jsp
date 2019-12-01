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
		<title>Sistema Hospital - Funcionarios</title>
	    <link href="base.css" type="text/css" rel="stylesheet">
	</head>

	<body background="img_girl.jpg">
		<div align="center">
        <h1>Funcionarios</h1>
        <br/>
			<table border="1">
				<tr>
					<td><strong>Código</strong></td>
					<td><strong>Nome</strong></td>
				</tr>
				<c:forEach var="funcionarios" items="${funcionarios}">
					<tr>
						<form id="excluir" action="/funcionarios" method="POST" modelAttribute="funcionarioSelecionado">
							<td width="10px"><input name="cpf" value="${funcionarios.cpf}" readonly/></td>
							<td width="10px"><input name="nome" value="${funcionarios.nome}" readonly/></td>
							<td width="10px"><input name="telefones" value="${funcionarios.telefones}" readonly/></td>
							<td width="10px"><input name="codigo" value="${funcionarios.codigo}" readonly/></td>
							<td width="10px"><input name="dtAdmissao" value="${funcionarios.dtAdmissao}" readonly/></td>
							<td width="10px"><input name="setor" value="${funcionarios.setor}" readonly/></td>
							<td style="padding: 7px;">
								<input id="excluir" type="image" alt="submit" src="../images/Deletar.png" onclick="form.action='/funcionarios/excluir';"/>
							</td>
							<td style="padding: 7px;">
								<input type="image" alt="submit" src="../images/Inserir.png" id="editar" type="submit" onclick="form.action='/funcionarios/editar-funcionario';"/>
							</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<br/>

			<form id="novoFuncionario" action="/funcionarios/novo-funcionario" method = "GET">
				<button type="submit">Novo Funcionario</button>
			</form>
			
			<form id="index" action="/" method = "GET">
				<button type="submit">Indice</button>
			</form>
		</div>
	</body>
</html>