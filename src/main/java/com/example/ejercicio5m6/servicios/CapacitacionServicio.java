package com.example.ejercicio5m6.servicios;


import com.example.ejercicio5m6.modelos.Capacitacion;
import com.example.ejercicio5m6.repositorios.ICapacitacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapacitacionServicio {

    @Autowired
    ICapacitacionRepositorio iCapacitacionRepositorio;

    public List<Capacitacion> listaCapacitacion(){
        List<Capacitacion> listaCapacitacion = iCapacitacionRepositorio.findAll();
        return listaCapacitacion;
    }

    public Capacitacion obtenerCapacitacion(Integer numCapacitacion){
        Capacitacion capacitacion = iCapacitacionRepositorio.getReferenceById(numCapacitacion);
        return capacitacion;
    }

    public boolean guardarCapacitacion( Capacitacion capacitacion ){
        try {
            iCapacitacionRepositorio.save(capacitacion);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
