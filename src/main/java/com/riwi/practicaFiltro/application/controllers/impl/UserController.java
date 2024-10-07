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



    @Override
    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un usuario", description = "Permite actualizar un usuario existente por ID",
            responses = {@ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
                    @ApiResponse(responseCode = "400", description = "Error al actualizar el usuario")})
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UserLogin userLogin) {
        try {
            Optional<UserEntity> user = userModel.update(id, userLogin);
            return user.map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("Usuario no encontrado"));
        } catch (Exception e) {
            ErrorSimple errorSimple = ErrorSimple.builder()
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message("Error al actualizar el usuario")
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorSimple);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un usuario", description = "Permite eliminar un usuario por ID",
            responses = {@ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            boolean isDeleted = userModel.delete(id);
            if (isDeleted) {
                return ResponseEntity.ok().body("Usuario eliminado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario");
        }
    }

    @Override
    @PostMapping
    @Operation(summary = "Crea un nuevo usuario", description = "Permite crear un usuario con este endpoint",
            responses = {@ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Error al registrar el usuario")})
    public ResponseEntity<?> create(@RequestBody @Valid UserLogin userLogin) {
        try {
            UserEntity newUser = userModel.create(userLogin);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (Exception e) {
            ErrorSimple errorSimple = ErrorSimple.builder()
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message("Error al registrar el usuario")
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorSimple);
        }
    }


}
