package com.cursoJava.curso.controllers;

import com.cursoJava.curso.models.Usuario;
import com.cursoJava.curso.dao.UsuarioDao;
import com.cursoJava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/v1/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario userLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (userLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(userLogueado.getId()), userLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }
}
