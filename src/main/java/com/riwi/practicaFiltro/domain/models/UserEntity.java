package com.riwi.practicaFiltro.domain.models;

import com.riwi.practicaFiltro.utils.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;
    private Roles rol;
    @OneToMany(mappedBy = "users")
    private Set<InscripcionesEntity> inscripciones;

}
