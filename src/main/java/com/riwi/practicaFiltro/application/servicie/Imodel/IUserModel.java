package com.riwi.practicaFiltro.application.servicie.Imodel;

import com.riwi.practicaFiltro.application.dtos.request.UserLogin;
import com.riwi.practicaFiltro.application.dtos.response.UserSinPassword;
import com.riwi.practicaFiltro.application.servicie.generics.Create;
import com.riwi.practicaFiltro.domain.models.UserEntity;
import org.apache.catalina.User;

public interface IUserModel extends Create<UserSinPassword, UserLogin> {
}
