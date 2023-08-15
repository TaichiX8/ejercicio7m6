package com.example.ejercicio5m6.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    private String apellidos;
    private String rut;
    private String edad;
    private String direccion;
    private String comuna;
    private String telefono;
    private String afp;
    @Column(name = "sistema_salud")
    private Integer sistemaSalud;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

}