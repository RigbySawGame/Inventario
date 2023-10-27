
package com.example.Inventario.Interfaces;

import com.example.Inventario.Clase.Laboratorio;
import java.util.List;
import java.util.Optional;


public interface ILaboratorioService {
   public List<Laboratorio> Listar();
   public Optional<Laboratorio> ConsultarId(int id);//Recoger datos 
   public void Guardar(Laboratorio c);
   public void Eliminar(int id);
   public List<Laboratorio> Buscar(String desc);
    
}
