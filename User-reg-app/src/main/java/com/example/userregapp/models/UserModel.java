package com.example.userregapp.models;
import java.util.Objects;
import javax.persistence.*;

/*Esta esnuestra entidad, Trabajamos y manipulamos nuestras tablas de Db en SQL desde El modelo
 * Esta tablas solo contiene 3 propiedas por ahora
 */

@Entity //para saber que es un modelo real
@Table(name ="user") //contolamos el nombre de la tabla 
public class UserModel {
    
    @Id//indicamos que es un PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)//indicamos que es un PK que no puede ser null
    private Long id;

    private String name;
    private String email;
    private Integer priority;
    //constructor vacio opcional, sabemos que se proveé uno por defecto
    public UserModel() {
    }
    //constructor inicializado
    public UserModel(Long id, String name, String email, Integer priority) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.priority = priority;
    }

    //getters and setters to String Autogenerados
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public UserModel id(Long id) {
        setId(id);
        return this;
    }

    public UserModel name(String name) {
        setName(name);
        return this;
    }

    public UserModel email(String email) {
        setEmail(email);
        return this;
    }

    public UserModel priority(Integer priority) {
        setPriority(priority);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(name, userModel.name) && Objects.equals(email, userModel.email) && Objects.equals(priority, userModel.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, priority);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", priority='" + getPriority() + "'" +
            "}";
    }

}