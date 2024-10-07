package com.riwi.practicaFiltro.domain.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Entity(name = "inscripciones")
@Getter
@Setter
@Builder
public class InscripcionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;



}
