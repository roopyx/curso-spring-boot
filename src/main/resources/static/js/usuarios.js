// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios()
  $('#usuarios').DataTable();
  actualizarEmailDelUsuario()
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

async function cargarUsuarios() {

    const request = await fetch('api/v1/usuarios', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Authorization': localStorage.token

        }
    })

    const usuarios = await request.json()

    let listadoHTML = ''
    for (let usuario of usuarios) {
      let btn-eliminar = '<a href="#" onClick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

      let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+ ' ' +usuario.apellido+'</td><td>'
                        +usuario.email+'</td><td>'+usuario.telefono+'</td><td>'+btn-eliminar+'</td></tr>'

      listadoHTML += usuarioHtml
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHTML
}

async function eliminarUsuario(id) {

    if(!confirm('Desea eliminar el usuario')) {
        return;
    }

    const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        }
    })

    location.reload()
}


