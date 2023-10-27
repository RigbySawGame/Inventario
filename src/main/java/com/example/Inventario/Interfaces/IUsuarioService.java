
package com.example.Inventario.Interfaces;
import com.example.Inventario.Clase.Usuario;
import java.util.List;
import java.util.Optional;


public interface IUsuarioService {
   public List<Usuario> Listar();
   public Optional<Usuario> ConsultarId(int id);//Recoger datos 
   public void Guardar(Usuario c);
   public void Eliminar(int id);
   public List<Usuario> Buscar(String desc);
}
