function displayFormFields() {
    var selectedOption = document.getElementById("perfil").value;
    if (selectedOption == "cli") {
        // Hacer una llamada AJAX a ListarClientes servlet
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "ListarClientes", true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                // Manejar la respuesta del servlet
                console.log(xhr.responseText);
            }
        };
        xhr.send();
        // Mostrar/ocultar elementos de formulario según sea necesario
        document.getElementById("formulario-cli").classList.remove("d-none");
        document.getElementById("formulario-pro").classList.add("d-none");
        document.getElementById("formulario-adm").classList.add("d-none");
    } else if (selectedOption == "pro") {
        // Hacer una llamada AJAX a ListarProfesionales servlet
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "ListarProfesionales", true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                // Manejar la respuesta del servlet
                console.log(xhr.responseText);
            }
        };
        xhr.send();
        // Mostrar/ocultar elementos de formulario según sea necesario
        document.getElementById("formulario-cli").classList.add("d-none");
        document.getElementById("formulario-pro").classList.remove("d-none");
        document.getElementById("formulario-adm").classList.add("d-none");
    } else if (selectedOption == "adm") {
        // Hacer una llamada AJAX a ListarAdministrativos servlet
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "ListarAdministrativos", true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                // Manejar la respuesta del servlet
                console.log(xhr.responseText);
            }
        };
        xhr.send();
        // Mostrar/ocultar elementos de formulario según sea necesario
        document.getElementById("formulario-cli").classList.add("d-none");
        document.getElementById("formulario-pro").classList.add("d-none");
        document.getElementById("formulario-adm").classList.remove("d-none");
    }
}
