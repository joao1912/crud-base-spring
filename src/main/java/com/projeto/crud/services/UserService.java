package com.projeto.crud.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.crud.dto.userDto.RequestUserDTO;
import com.projeto.crud.models.User;
import com.projeto.crud.repositories.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {

    return userRepository.findAll();

  }

  public User createUser(RequestUserDTO userData) {

    User usuarioParaCriar = new User();
    usuarioParaCriar.setName(userData.name());
    usuarioParaCriar.setEmail(userData.email());
    usuarioParaCriar.setPassword(userData.password());

    User usuarioCriado = userRepository.save(usuarioParaCriar);


    return usuarioCriado;

  }

  public User editUser(UUID id, RequestUserDTO userData) {

    User usuarioParaEditar = new User();
    usuarioParaEditar.setId(id);
    usuarioParaEditar.setName(userData.name());
    usuarioParaEditar.setEmail(userData.email());
    usuarioParaEditar.setPassword(userData.password());

    User usuarioEditado = userRepository.save(usuarioParaEditar);

    return usuarioEditado;

  }

  public void deleteUser(UUID id) {

    userRepository.deleteById(id);

  }

}
