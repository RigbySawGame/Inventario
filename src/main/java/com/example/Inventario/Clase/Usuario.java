
package com.example.Inventario.Clase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")

public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    public int Codigo;
    public String NombreU;
    public String Correo;
    public String Usuario;
    
}
