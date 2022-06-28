package com.example.userregapp.services;

import java.util.ArrayList;
import java.util.Optional;
import com.example.userregapp.models.UserModel;
import com.example.userregapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    /*inyectamos la dependencia como propiedad del tipo user repository, para acceder a nuestros metodos que nos prove 
     * nuestra interfaz al extender de algun CRUD, 
     * El Servicio Requiere saber a que Metodos del repositorio obedece 
    */
    @Autowired
    UserRepository userRepository; 

    public ArrayList<UserModel> getUsers(){
        return (ArrayList <UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel usuario){
        return userRepository.save(usuario);
    }

    public Optional<UserModel> getById(long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getByPriority(Integer priority){
        return userRepository.findByPriority(priority);
    }

    public boolean deleteById(long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;            
        }
    }
}