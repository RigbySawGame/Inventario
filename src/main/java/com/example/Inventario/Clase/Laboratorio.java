
package com.example.Inventario.Clase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="laboratorio")
public class Laboratorio {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int numIdentificacion;
    public String nombre;
    public String contacto;
    public String tipo;

  
}
