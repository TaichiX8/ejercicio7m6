package com.example.ejercicio5m6.dao;

import com.example.ejercicio5m6.modelos.Capacitacion;

import java.util.List;


interface ICapacitacionDAO {

    List<Capacitacion> obtenerCapacitaciones();

    boolean crearCapacitacion(Capacitacion capacitacion);
}
