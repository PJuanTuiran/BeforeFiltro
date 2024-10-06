package com.riwi.practicaFiltro.application.controllers.impl;

import com.riwi.practicaFiltro.application.controllers.interfaces.IUserController;
import com.riwi.practicaFiltro.application.dtos.request.UserLogin;
import com.riwi.practicaFiltro.application.exeptions.ErrorSimple;
import com.riwi.practicaFiltro.application.servicie.Imodel.IUserModel;
import com.riwi.practicaFiltro.domain.models.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import org.apache.catalina.User;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@RestController
@RequestMapping("/userss")


public class UserController implements IUserController {
    @Autowired
    private IUserModel userModel;

    @Override
    @PostMapping
    @Operation(summary = "Crea un nuevo usuario" , description = "puedes crear un usuario con este endpoint", responses = {@ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"), @ApiResponse(responseCode = "400", description = "Error al registrar el usuario")})
    public ResponseEntity<?> create(@RequestBody @Valid UserLogin userLogin) {

       try{

               return ResponseEntity.status(201).body(userModel.create(userLogin));


       }catch (Exception e){
           ErrorSimple errorSimple = ErrorSimple.builder()
                   .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                   .code(HttpStatus.BAD_REQUEST.value())
                   .message("Error al registrar el usuario")
                   .build();

           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorSimple);
       }
    }

}
