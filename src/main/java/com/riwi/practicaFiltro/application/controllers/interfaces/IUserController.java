package com.riwi.practicaFiltro.application.controllers.interfaces;

import com.riwi.practicaFiltro.application.controllers.generics.Create;
import com.riwi.practicaFiltro.application.dtos.request.UserLogin;
import com.riwi.practicaFiltro.domain.models.UserEntity;

public interface IUserController extends Create<UserLogin> {
}
