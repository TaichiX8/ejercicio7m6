package com.example.ejercicio7m6.controladores;

import com.example.ejercicio7m6.modelos.Usuario;
import com.example.ejercicio7m6.servicios.UsuarioServicio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioServicio.listaUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "lista_usuario";
    }

    @GetMapping("/crear-usuario")
    public String crearUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "crear_usuarios";

    }

    @PostMapping("/crear-usuario")
    public String guardarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "lista_usuarios";

    }

}