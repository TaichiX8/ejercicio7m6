package com.example.ejercicio7m6.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    private String nombre;
    private String apellido;
    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "tipo_usuario", nullable = false)
    private String tipoUsuario;

    @OneToOne(mappedBy = "usuario")
    private Profesional profesional;

    @OneToOne(mappedBy = "usuario")
    private Administrativo administrativo;

    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;
}