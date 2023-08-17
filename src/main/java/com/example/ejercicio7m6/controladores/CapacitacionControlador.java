package com.example.ejercicio7m6.controladores;

import com.example.ejercicio7m6.modelos.Capacitacion;

import com.example.ejercicio7m6.dao.CapacitacionDao;
import com.example.ejercicio7m6.servicios.CapacitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.util.logging.*;

@Controller

public class CapacitacionControlador {

    @Autowired
    CapacitacionServicio capacitacionServicio;
    private final static Logger LOG_MONITOREO = Logger.getLogger("com.example.ejercicio3m6.controladores");


    @GetMapping("/crear_capacitacion")
    public String crearCapacitacion() {
        LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : crear capacitacion formulario");
        return "crear_capacitacion";
    }

    @PostMapping("/crearCapacitacion")
    public String crearCapacitacion(@RequestParam("nombre") String nombre, @RequestParam("detalle") String detalle, @RequestParam("rutCliente") String rutCliente, @RequestParam("diaSemana") String diaSemana, @RequestParam("hora") Time hora, @RequestParam("lugar") String lugar, @RequestParam("duracion") Time duracion, @RequestParam("cantAsistentes") int cantAsistentes) {
        // Crea un objeto Capacitacion con los datos recibidos

        try {
            LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : crear capacitacion POST");
            Capacitacion capacitacion = new Capacitacion(0, nombre, detalle, rutCliente, diaSemana, hora, lugar, duracion, cantAsistentes);
            CapacitacionDao capacitacionDao = new CapacitacionDao();
            boolean creado = capacitacionDao.crearCapacitacion(capacitacion);

            // Lógica para guardar la capacitación en el listado o en una base de datos
            LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : Se guardó la capacitación");
            return "redirect:/capacitacion"; // Redirige a la página de listado de capacitaciones
        }catch( Exception e){
            LOG_MONITOREO.log(Level.WARNING, "CapacitacionControladorError :" +  e.getMessage());
            return "redirect:/capacitacion";
        }


    }

    @GetMapping("/capacitacion")
    public String listarCapacitacion( Model m){
        LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : LISTAR CAPACITACIONES");

        try {
            //CapacitacionDao capacitacionDao = new CapacitacionDao();

            m.addAttribute("lista", capacitacionServicio.listaCapacitacion());

            System.out.println(capacitacionServicio.listaCapacitacion());

            return "listar_capacitacion";
        }catch( Exception e){
            LOG_MONITOREO.log(Level.WARNING, "CapacitacionControlador Listar Error :" +  e.getMessage());
            return "listar_capacitacion";
        }
    }


    @PostMapping("/capacitacion")
    public String grabarCapacitacion (@RequestParam ("nombre") String nombre,
                                      @RequestParam ("detalle") String detalle,
                                      @RequestParam ("rutCliente") String rut,
                                      @RequestParam ("diaSemana") String dia,
                                      @RequestParam ("hora") Time hora,
                                      @RequestParam ("lugar") String lugar,
                                      @RequestParam ("duracion") Time duracion,
                                      @RequestParam ("cantAsistentes") int asistentes,
                                      Model m) {

        try {
            LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : crear capacitacion POST");
            Capacitacion capacitacion = new Capacitacion(0, nombre, detalle, rut, dia, hora, lugar, duracion, asistentes);
            //CapacitacionDao capacitacionDao = new CapacitacionDao();
            boolean creado = capacitacionServicio.guardarCapacitacion(capacitacion);

            //List<Capacitacion> lista = capacitacionDao.obtenerCapacitaciones();
            m.addAttribute("lista", capacitacionServicio.listaCapacitacion());

            System.out.println(capacitacion.toString());

            LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : Se ha guardado la capacitación");
            return "listar_capacitacion";

        }catch( Exception e){

            LOG_MONITOREO.log(Level.WARNING, "CapacitacionControlador Error :" +  e.getMessage());
            return "redirect:/capacitacion";

        }
    }
}