package com.example.ejercicio3m6.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControlador {

    @GetMapping("/inicio")
    public String index() {
        return "index";
    }
}
