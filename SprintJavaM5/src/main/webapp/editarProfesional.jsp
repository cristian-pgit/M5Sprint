<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bitte Dans Les Youx</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="shortcut icon" href="https://i.ibb.co/FzxxWTL/BDLY-ico.png"
	type="image/x-icon">
<link rel="stylesheet" href="Assets/style.css">

</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<c:if test="${sessionScope.userName == null}">
		<c:redirect url="/" />
	</c:if>

	<div class="container">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4 text-center">
				<br>
				<h1 class="h3 mb-3 fw-normal text-center">Editar Profesional</h1>

				<form class="was-validated" action="EditarProfesional" method="post">

					<div class="form-group">
						<label for="idUser">Id de Usuario a Editar</label> <select
							class="form-select" required aria-label="select example"
							id="idUser" name="idUser">
							<option value="" disabled selected hidden>Selecciona un
								Cliente a Editar</option>
							<c:forEach var="pros" items="${requestScope.pros}">
								<option value="${pros.idUsuario}"><c:out value="${pros.userName}" />&nbsp;-&nbsp; <c:out value="${pros.idUsuario}" /></option>
							</c:forEach>
						</select>
						<div class="invalid-feedback">Favor seleccione Profesional a
							Editar</div>
					</div>

					<div class="form-group">
						<label class="text-center" for="userName">Nombre de
							Usuario: </label> <input type="text" class="form-control" id="userName"
							required name="userName">
						<div class="invalid-feedback">Escriba un Nombre de Usuario</div>
					</div>
					<div class="form-group">
						<label class="text-center" for="password">Password: </label> <input
							type="password" class="form-control" id="password" required
							name="password">
						<div class="invalid-feedback">Ingrese un Password. Debe
							contener un simbolo y un numero al menos.</div>
					</div>
					<div class="form-group">
						<label for="fechaNac">Fecha de Nacimiento:</label>
						<div class="input-group date" data-provide="datepicker">
							<input type="text" class="form-control" id="fechaNac"
								name="fechaNac" required>
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-th"></span>
							</div>
						</div>
						<div class="invalid-feedback">Favor eliga una fecha</div>
					</div>
					<div class="form-group">
						<label class="text-center" for="run">RUN (Rol Unico
							Nacional):</label> <input type="number" class="form-control" id="run"
							required name="run">
						<div class="invalid-feedback">Ingrese un RUN de 8 digitos
							sin puntos ni digito verificador</div>
					</div>
					<div class="form-group">
						<label class="text-center" for="titulo">Titulo
							Profesional: </label> <input type="text" class="form-control" id="titulo"
							required name="titulo">
						<div class="invalid-feedback">Favor ingrese Titulo
							Profesional</div>
					</div>
					<div class="form-group">
						<label for="fechaIng">Fecha de Ingreso:</label>
						<div class="input-group date" data-provide="datepicker">
							<input type="text" class="form-control" id="fechaIng"
								name="fechaIng" required>
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-th"></span>
							</div>
							<div class="invalid-feedback">Favor ingrese Fecha de
								Ingreso a la compañia</div>
						</div>
					</div>


					<br>
					<button type="submit" class="btn btn-primary" id="save">Guardar</button>
				</form>
			</div>
			<div class="col-4"></div>
		</div>

	</div>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
		crossorigin="anonymous"></script>
	<script src="Assets/crearuser.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="Assets/idexistente.js"></script>
	<script src="Assets/segperfil.js"></script>
</body>
</html>