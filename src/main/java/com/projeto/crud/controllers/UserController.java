package com.projeto.crud.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.crud.dto.userDto.RequestUserDTO;
import com.projeto.crud.dto.userDto.ResponseUserDTO;
import com.projeto.crud.models.User;
import com.projeto.crud.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/todos")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> usuarios = userService.getAllUsers();
    return ResponseEntity.ok(usuarios);
  }

  @PostMapping("/criar")
  private ResponseEntity<ResponseUserDTO> createUser(@RequestBody RequestUserDTO userData) {

    User usuario = userService.createUser(userData);

    ResponseUserDTO responseUser = new ResponseUserDTO(usuario.getName(), usuario.getEmail());

    return ResponseEntity.ok(responseUser);

  }
  
   @PutMapping("/editar/{id}")
  public ResponseEntity<ResponseUserDTO> editUser(@PathVariable UUID id, @RequestBody RequestUserDTO userData) {
    User usuarioEditado = userService.editUser(id, userData);
    ResponseUserDTO responseUser = new ResponseUserDTO(usuarioEditado.getName(), usuarioEditado.getEmail());
    return ResponseEntity.ok(responseUser);
  }

  @DeleteMapping("/deletar/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

}
