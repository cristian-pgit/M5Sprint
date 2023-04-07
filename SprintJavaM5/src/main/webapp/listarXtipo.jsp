<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bitee Dans Les Youx</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="shortcut icon" href="https://i.ibb.co/FzxxWTL/BDLY-ico.png"
	type="image/x-icon">
<link rel="stylesheet" href="Assets/style.css">
</head>
<body>
	<c:if test="${sessionScope.userName == null}">
		<c:redirect url="/" />
	</c:if>
	<jsp:include page="nav.jsp"></jsp:include>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<div class="form-group">
					<label for="perfil">Elegir Perfil a Listar</label> <select
						class="form-control" id="perfil" name="perfil"
						onchange="displayFormFields()">
						<option value="" disabled selected hidden>---Selecciona---</option>
						<option value="cli" onclick="ListarClientes">Clientes</option>
						<option value="pro">Profesionales</option>
						<option value="adm">Administrativos</option>
					</select>
				</div>
			</div>
			<div class="col-4"></div>
		</div>
		<div class="row">
			<div class="formulario d-none" id="formulario-cli">
				<jsp:include page="listarClientes.jsp" />
			</div>
			<div class="formulario d-none" id="formulario-pro">
				<jsp:include page="listarProfesionales.jsp" />
			</div>
			<div class="formulario d-none" id="formulario-adm">
				<jsp:include page="listarAdministrativos.jsp" />
				<br>
			</div>
		</div>
	</div>




	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
		crossorigin="anonymous"></script>
	<script src="Assets/listarXperfil.js"></script>
</body>
</html>