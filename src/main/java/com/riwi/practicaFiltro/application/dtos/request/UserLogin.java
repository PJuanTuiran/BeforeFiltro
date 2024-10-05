package com.riwi.practicaFiltro.application.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLogin {
    @Schema(required = true, example = "admin")
    @NotBlank(message = "El username no puede ser vacio")
    private String username;

    @NotBlank(message = "El password no puede ser vacio")
    @Schema(required = true, example = "jfajfaj" )
    private String password;
}
