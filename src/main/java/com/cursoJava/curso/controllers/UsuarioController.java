package com.cursoJava.curso.controllers;

import com.cursoJava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lazlo");
        usuario.setApellido("California");
        usuario.setEmail("Lazlo.cali@gmail.com");
        usuario.setTelefono("+56948376593");
        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(22121L);
        usuario.setNombre("Lazlo");
        usuario.setApellido("California");
        usuario.setEmail("Lazlo.cali@gmail.com");
        usuario.setTelefono("+56948376593");

        Usuario usuario1 = new Usuario();
        usuario1.setId(212121L);
        usuario1.setNombre("Lazlo1");
        usuario1.setApellido("California1");
        usuario1.setEmail("Lazlo.1@gmail.com");
        usuario1.setTelefono("+56943236593");

        Usuario usuario2 = new Usuario();
        usuario2.setId(1344534L);
        usuario2.setNombre("Lazlo2");
        usuario2.setApellido("California2");
        usuario2.setEmail("Lazlo.2@gmail.com");
        usuario2.setTelefono("+56942276593");

        usuarios.add(usuario);
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        return usuarios;
    }

}
