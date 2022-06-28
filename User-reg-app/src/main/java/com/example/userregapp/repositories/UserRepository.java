package com.example.userregapp.repositories;

import java.util.ArrayList;

import com.example.userregapp.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*extendemos de CrudRepository en donde estamos entregando un UserModel y una manera de Obtener nuestros datos
 * como ID en este caso estamos usando un LONG
 * UserRepository Requiere Saber a Que modelo va a utilizar
 */
@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByPriority(Integer priority); //custom comportamiento para obtener por prioridad
}