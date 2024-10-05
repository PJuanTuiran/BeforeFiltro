package com.riwi.practicaFiltro.application.servicie.impl;

import com.riwi.practicaFiltro.application.dtos.request.UserLogin;
import com.riwi.practicaFiltro.application.dtos.response.UserSinPassword;
import com.riwi.practicaFiltro.application.servicie.Imodel.IUserModel;
import com.riwi.practicaFiltro.domain.models.UserEntity;
import com.riwi.practicaFiltro.infrastructure.percistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements IUserModel {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserSinPassword create(UserLogin userlogin) {

        UserEntity userEntity = UserEntity.builder()
                .username(userlogin.getUsername())
                .password(userlogin.getPassword())

                .build();
        userRepository.save(userEntity);
        UserSinPassword userSinPassword = UserSinPassword.builder()
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .rol(userEntity.getRol())
                .build();
        return userSinPassword;
    }
}
