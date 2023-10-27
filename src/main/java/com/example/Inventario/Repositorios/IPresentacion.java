
package com.example.Inventario.Repositorios;

import com.example.Inventario.Clase.Presentacion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPresentacion extends CrudRepository<Presentacion,Integer>{
    @Query(value="SELECT * FROM presentacion " 
            + "WHERE nombre LIKE %?1% " 
            + "OR nombreC LIKE %?1% " 
    ,nativeQuery=true)
    List<Presentacion> findForAll(String desc);
}
