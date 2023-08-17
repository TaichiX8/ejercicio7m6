package com.example.ejercicio7m6.servicios;

import com.example.ejercicio7m6.modelos.Usuario;
import com.example.ejercicio7m6.repositorios.IAdministrativoRepositorio;
import com.example.ejercicio7m6.repositorios.IClienteRepositorio;
import com.example.ejercicio7m6.repositorios.IProfesionalRepositorio;
import com.example.ejercicio7m6.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio usuarioRepositorio;

    @Autowired
    IClienteRepositorio clienteRepositorio;

    @Autowired
    IAdministrativoRepositorio administrativoRepositorio;

    @Autowired
    IProfesionalRepositorio profesionalRepositorio;


    public List<Usuario> listaUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepositorio.findAll();
        return listaUsuarios;
    }

    public Long crearUsuario(Usuario usuario) {
        try {
            Usuario us = usuarioRepositorio.save(usuario);
            return us.getId();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
