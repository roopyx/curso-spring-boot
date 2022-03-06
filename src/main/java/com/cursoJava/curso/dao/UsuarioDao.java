package com.cursoJava.curso.dao;

import com.cursoJava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    public List<Usuario> getUsuarios();

    void eliminarUsuario(Long id);

    void registrar(Usuario usuario);
}
