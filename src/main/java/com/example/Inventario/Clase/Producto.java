package com.example.Inventario.Clase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto {
 @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int codigo;
    public String nombre;
    public String precio;
    public String cantidad;
    public String fecha;

}
