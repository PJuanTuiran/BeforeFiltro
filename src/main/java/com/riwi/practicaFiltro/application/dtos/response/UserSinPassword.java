package com.riwi.practicaFiltro.application.dtos.response;

import com.riwi.practicaFiltro.utils.enums.Roles;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserSinPassword {

    private String username;
    private String email;
    private Roles rol;
}
