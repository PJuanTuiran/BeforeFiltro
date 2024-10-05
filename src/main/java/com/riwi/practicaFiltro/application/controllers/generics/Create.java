package com.riwi.practicaFiltro.application.controllers.generics;

import org.springframework.http.ResponseEntity;

public interface Create <T> {

    ResponseEntity<?> create(T t);
}
