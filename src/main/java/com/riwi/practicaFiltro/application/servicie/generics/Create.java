package com.riwi.practicaFiltro.application.servicie.generics;

import java.util.Optional;

public interface Create <R, T>{

    R create(T t);
}
