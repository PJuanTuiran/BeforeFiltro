package com.riwi.practicaFiltro.application.exeptions;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter

public class ErrorSimple {
    private int code;
    private String status;
    private String message;

}
