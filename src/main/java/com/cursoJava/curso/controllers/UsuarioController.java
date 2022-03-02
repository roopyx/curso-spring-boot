package com.cursoJava.curso.controllers;

import com.cursoJava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "Usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lazlo");
        usuario.setApellido("California");
        usuario.setEmail("Lazlo.cali@gmail.com");
        usuario.setTelefono("+56948376593");
        return usuario;
    }

}
