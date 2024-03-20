package com.clinica_veterinaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Dueño {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private int celular;
    @OneToOne(cascade = CascadeType.ALL)// relación uno a uno con la tabla de mascota
    @JoinColumn(name = "masc_id", referencedColumnName = "id")
    private Mascota unaMascota;
}
