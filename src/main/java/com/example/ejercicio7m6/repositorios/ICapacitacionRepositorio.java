package com.example.ejercicio7m6.repositorios;

import com.example.ejercicio7m6.modelos.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICapacitacionRepositorio extends JpaRepository<Capacitacion, Integer > {



}
