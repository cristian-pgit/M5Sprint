<div class="container">
        <br>
	    <h1 class="text-center py-3">Listado de Profesionales</h1>
        <br>
       <table>
  <thead>
    <tr>
      <th>ID de Usuario</th>
      <th>Nombre de Usuario</th>
      <th>Fecha de Nacimiento</th>
      <th>RUN</th>
      <th>Titulo</th>
      <th>Fecha de Ingreso:</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="user" items="${requestScope.usuarios}">
      <tr>
        <td><c:out value="${user.idUsuario}"/></td>
        <td><c:out value="${user.userName}"/></td>
        <td><c:out value="${user.fNacimiento}"/></td>
        <td><c:out value="${user.run}"/></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
    </div>