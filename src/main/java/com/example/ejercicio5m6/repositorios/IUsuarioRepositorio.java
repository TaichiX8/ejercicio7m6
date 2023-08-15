package com.example.ejercicio5m6.repositorios;

import com.example.ejercicio5m6.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}


