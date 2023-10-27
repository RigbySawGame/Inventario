
package com.example.Inventario.Repositorios;
import com.example.Inventario.Clase.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends CrudRepository<Usuario,Integer>{
    @Query(value="SELECT * FROM usuario " 
            + "WHERE NombreU LIKE %?1% " 
            + "OR Correo LIKE %?1% "
            + "OR Usuario LIKE %?1% "
    ,nativeQuery=true)
    List<Usuario> findForAll(String desc);
}
