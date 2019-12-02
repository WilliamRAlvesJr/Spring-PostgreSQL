<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		</style>
		<title>Sistema Hospital</title>
		<link href="base.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<div align="center">
			<h1>Sistema Hospital</h1>
			<br />
			<table>
				<tr>
					<td>
						<figure>
							<figcaption><strong>Pacientes</strong></figcaption> 
							<form id="pacientes" action="/pacientes" method = "GET">
								<input class="modules" type="image" src="images/Paciente.png" alt="Submit" width="48" height="48">
							</form>
						</figure>
					</td>
					<td>	
						<figure>
							<figcaption><strong>Convênios</strong></figcaption> 
							<form id="convenios" action="/convenios" method = "GET">
								<input class="modules" type="image" src="images/Convenio2.png" alt="Submit" width="48" height="48">
							</form>
						</figure>
					</td>
					<td>	
						<figure>
							<figcaption><strong>Setores</strong></figcaption> 
							<form id="setores" action="/setores" method = "GET">
								<input class="modules" type="image" src="images/Setor.png" alt="Submit" width="48" height="48">
							</form>
						</figure>
					</td>
					<td>
						<figure>
							<figcaption><strong>Equipamentos</strong></figcaption> 
							<form id="equipamentos" action="/equipamentos" method = "GET">
								<input class="modules" type="image" src="images/Equipamento2.png" alt="Submit" width="48" height="48">
							</form>
						</figure>  
					</td>
				</tr>
				<tr>
					<td>
						<figure>
							<figcaption><strong>Quartos</strong></figcaption> 
							<form id="quartos" action="/quartos" method = "GET">
								<input class="modules" type="image" src="images/Quarto.png" alt="Submit">
							</form>
						</figure>
					</td>
					<td>
						<figure>
							<figcaption><strong>Funcionarios</strong></figcaption> 
							<form id="funcionarios" action="/funcionarios" method = "GET">
								<input class="modules" type="image" src="images/funcionarios.png" alt="Submit">
							</form>
						</figure>
					</td>
					<td>
						<figure>
							<figcaption><strong>Médicos</strong></figcaption> 
							<form id="medicos" action="/medicos" method = "GET">
								<input class="modules" type="image" src="images/Funcionario.png" alt="Submit">
							</form>
						</figure>
					</td>
					<td>
						<figure>
							<figcaption><strong>Tratamento</strong></figcaption> 
							<form id="tratamentos" action="/tratamentos" method = "GET">
								<input class="modules" type="image" src="images/Tratamento.png" alt="Submit">
							</form>
						</figure>
					</td>
				</tr>
				<tr>  
					<td>
						<figure>
							<figcaption><strong>Pessoas no Hospital</strong></figcaption> 
							<form id="pessoas" action="/pessoas" method = "GET">
								<input class="modules" type="image" src="images/Hospital.png" alt="Submit">
							</form>
						</figure>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>