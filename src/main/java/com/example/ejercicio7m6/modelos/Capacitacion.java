package com.example.ejercicio7m6.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "capacitacion")

public class Capacitacion implements Serializable {
    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column (name = "num_capacitacion")
    private Integer numCapacitacion;

    @Column(name = "nombre" , nullable = false)
    private String nombre;

    @Column(name="detalle" ,nullable = false)
    private String detalle;

    @Column(name = "rut_cliente", length = 12, nullable = false, unique = true)
    private String rutCliente;

    @Column(name = "dia_semana")
    private String diaSemana;

    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Time hora;
    @Column(name = "lugar" , length = 20 , nullable = false)
    private String lugar;
    @Column(name = "duracion")
    @Temporal(TemporalType.TIME)
    private Time duracion;
    @Column (name = "cantidad_asistentes", nullable = false)
    private Integer cantAsistentes;




}

