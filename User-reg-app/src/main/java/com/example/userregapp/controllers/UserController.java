package com.example.userregapp.controllers;
import com.example.userregapp.services.UserService;

import java.util.ArrayList;
import java.util.Optional;

import com.example.userregapp.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Notacion que nos indica que es un controlador en nuestra app
@RequestMapping("/usr")
public class UserController {
 @Autowired
  UserService userService; // el controler requiere conocer el servicio que va a atender inyectado como propiedad
  
  @GetMapping()
  public ArrayList<UserModel> getUsers(){
      return userService.getUsers();
  }

  @GetMapping(path = "/{id}")
  public Optional<UserModel> getByID(@PathVariable("id")long id){
      return userService.getById(id);
  }

  @GetMapping(path = "/query")
  public ArrayList<UserModel> getByPriority(@PathVariable("priority")Integer id){
      return userService.getByPriority(id);
  }

  @DeleteMapping(path = "/{id}")
  public String deletrById(@PathVariable("id")Long id){
      boolean ok = this.userService.deleteById(id);
      if(ok){
        return "Deleted ID " + id;
      }else{
        return "Not able to delete  " + id;
      }
  }

  @PostMapping()
  public UserModel saveUser(@RequestBody UserModel usr){
      return this.userService.saveUser(usr);
  }
}