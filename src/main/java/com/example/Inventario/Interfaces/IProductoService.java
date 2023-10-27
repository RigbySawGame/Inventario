
package com.example.Inventario.Interfaces;

import com.example.Inventario.Clase.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luis
 */
public interface IProductoService {
     public List<Producto> Listar();
   public Optional<Producto> ConsultarId(int id);//Recoger datos 
   public void Guardar(Producto p);
   public void Eliminar(int id);
   public List<Producto> Buscar(String desc);
    
}
