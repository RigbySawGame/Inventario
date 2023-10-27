
package com.example.Inventario.Interfaces;
import com.example.Inventario.Clase.Presentacion;
import java.util.List;
import java.util.Optional;

public interface IPresentacionService {
   public List<Presentacion> Listar();
   public Optional<Presentacion> ConsultarId(int id);//Recoger datos 
   public void Guardar(Presentacion c);
   public void Eliminar(int id);
   public List<Presentacion> Buscar(String desc);
}
