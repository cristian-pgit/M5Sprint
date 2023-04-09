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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<br>
		<h1 class="text-center py-3">Listado de Clientes</h1>
		<br>
		<div class="table-responsive">
			<table>
				<thead>
					<tr>
						<th>ID de Usuario</th>
						<th>Nombre de Usuario</th>
						<th>Fecha de Nacimiento</th>
						<th>RUN</th>
						<th>RUT de Cliente</th>
						<th>Nombres</th>
						<th>Apellidos</th>
						<th>Telefono</th>
						<th>AFP</th>
						<th>Sist. Salud</th>
						<th>Direccion</th>
						<th>Comuna</th>
						<th>Edad</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="client" items="${requestScope.clientes}">
						<tr>
							<td><c:out value="${client.idUsuario}" /></td>
							<td><c:out value="${client.userName}" /></td>
							<td><fmt:formatDate value="${client.fNacimiento}"
									pattern="dd/MM/yyyy" /></td>
							<td><c:out value="${client.run}" /></td>
							<td><c:out value="${client.rutCliente}" /></td>
							<td><c:out value="${client.nombres}" /></td>
							<td><c:out value="${client.apellidos}" /></td>
							<td><c:out value="${client.fono}" /></td>
							<td><c:out value="${client.afp}" /></td>
							<td><c:choose>
									<c:when test="${client.sds == 1}">Fonasa</c:when>
									<c:when test="${client.sds == 2}">Isapre</c:when>
									<c:otherwise>Otro</c:otherwise>
								</c:choose></td>
							<td><c:out value="${client.direccion}" /></td>
							<td><c:out value="${client.comuna}" /></td>
							<td><c:out value="${client.edad}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
		crossorigin="anonymous"></script>
</body>
</html>