$(document).ready(function({
    // on ready
}))

async function registrarUsuario() {
    let datos = {}
    datos.nombre = document.getElementById('txtName').value
    datos.apellido = document.getElementById('txtLastName').value
    datos.email = document.getElementById('txtEmail').value
    datos.password = document.getElementById('txtPassword').value

    let repetirPassword = document.getElementById('txtRepeatPassword').value

    if (repetirPassword != datos.password) {
        alert('Las contrasenas no coincidden, intenta nuevamente')
        return;
    }

    const request = await fetch('api/v1/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
    alert("La cuenta fue creada con exito")
    window.location.href = 'login.html'
}