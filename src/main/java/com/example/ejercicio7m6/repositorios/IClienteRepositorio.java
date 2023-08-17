package com.example.ejercicio7m6.repositorios;

import com.example.ejercicio7m6.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepositorio extends JpaRepository<Cliente, Integer > {

}
