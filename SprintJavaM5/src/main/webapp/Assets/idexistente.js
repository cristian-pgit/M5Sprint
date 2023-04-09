var listaUsuarios = [document.get]
  var valorBuscado = "";

$.get('${pageContext.request.contextPath}/BuscarID', function(data) {
        alert(data);
    });


  function verificarValor() {
    valorBuscado = document.getElementById("idUser").value;

    if (valorBuscado.trim() === '') {
      console.log("El valor está vacío.");
    } else if (listaUsuarios.includes(valorBuscado)) {
      console.log("El Id de Usuario: " + valorBuscado + " ya existe. Elige otro.");
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'El ID de Usuario ya existe.',
        footer: 'Elige otro valor'
      });
    } else {
      console.log("El valor " + valorBuscado + " NO se encuentra en la lista.");
    }
  }