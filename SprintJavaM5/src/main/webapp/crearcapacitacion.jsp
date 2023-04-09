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
				<h1 class="h3 mb-3 fw-normal text-center">Crear capacitación</h1>

				<form  class="was-validated" action="CrearCapacitacion" method="post">
					<div class="form-group">
						<label class="text-center" for="idCapacitacion">ID de
							Capacitación:</label> <input type="number" class="form-control"
							id="idCapacitacion" required name="idCapacitacion">
							<div class="invalid-feedback">Favor ingrese un valor</div>
					</div>
				
					<div class="form-group">
						<label for="rutCliente">Rut de Cliente:</label> <select class="form-select" required aria-label="select example"
							id="rutCliente" name="rutCliente">
							<option value="" disabled selected hidden>Selecciona un Rut de Cliente Existente</option>
							<c:forEach var="client" items="${requestScope.clientes}">
								<option value="${client.rutCliente}"><c:out value="${client.nombres}" />&nbsp;<c:out value="${client.apellidos}" />&nbsp;-&nbsp;<c:out value="${client.rutCliente}"/></option>
							</c:forEach>	
						</select>
						<div class="invalid-feedback">Favor seleccione un RUT</div>
					</div>
					<div class="form-group" >
						<label for="dia">Día:</label> 
						<select class="form-select" required aria-label="select example" id="dia" name="dia" >
							<option value="" disabled selected hidden>Selecciona un
								día</option>
							<option value="lunes">Lunes</option>
							<option value="martes">Martes</option>
							<option value="miercoles">Miércoles</option>
							<option value="jueves">Jueves</option>
							<option value="viernes">Viernes</option>
							<option value="sabado">Sábado</option>
							<option value="domingo">Domingo</option>
						</select>
						<div class="invalid-feedback">Favor seleccione un dia</div>
					</div>
					<div class="form-group">
						<label class="text-center" for="hora">Hora (xx:xx):</label> <input
							type="time" class="form-control" id="hora" name="hora" required
							pattern="^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$">
							<div class="invalid-feedback">Favor ingrese una hora</div>
					</div>
					<div class="form-group">
						<label class="text-center" for="lugar">Lugar:</label> <input
							type="text" required class="form-control" id="lugar" name="lugar">
							<div class="invalid-feedback">Favor ingrese una Locacion donde se impartira la Capacitacion</div>
					</div>
					<div class="form-group">
						<label class="text-center" for="duracion">Duración:</label> 
						<select class="form-select" required aria-label="select example" id="duracion" name="duracion" >
							<option value="" disabled selected hidden>Selecciona duracion</option>
							<option value="30">30 minutos</option>
							<option value="60">1 Hora</option>
							<option value="90">1 Hora 30 minutos</option>
							<option value="120">2 Horas</option>
							<option value="150">2 Horas 30 minutos</option>
							<option value="180">3 Horas</option>
							<option value="210">3 Horas 30 Minutos </option>
							<option value="240">4 Horas</option>
						</select>
						<div class="invalid-feedback">Favor seleccione duracion</div>
					</div>
					<div class="form-group">
						<label class="text-center" for="cantAsist">Cantidad de
							Asistentes:</label> <input type="number" class="form-control"
							id="cantAsist" required name="cantAsist">
							<div class="invalid-feedback">Favor indique Cantidad de Asistentes esperados</div>
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
	<script src="Assets/crearcapareg.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>