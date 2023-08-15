package com.example.ejercicio5m6.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactoControlador {

    @GetMapping("/contacto")
    public String contacto( Model model ) {
        model.addAttribute("respuesta" , "x");
        return "contacto";
    }

    @PostMapping("/contacto")
    public String enviarContacto(@RequestParam("nombre") String nombre , @RequestParam("email") String email , @RequestParam("descripcion") String descripcion , Model model) {


        model.addAttribute("respuesta", "El mensaje ha sido enviado ,pronto te contactaremos");
        System.out.println("Nombre: " + nombre + "\nEmail: " + email + "\nMensaje: " + descripcion);


        return "contacto";

    }

}

