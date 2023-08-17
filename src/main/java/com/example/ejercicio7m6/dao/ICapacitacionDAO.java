package com.example.ejercicio7m6.dao;

import com.example.ejercicio7m6.modelos.Capacitacion;

import java.util.List;


interface ICapacitacionDAO {

    List<Capacitacion> obtenerCapacitaciones();

    boolean crearCapacitacion(Capacitacion capacitacion);
}
