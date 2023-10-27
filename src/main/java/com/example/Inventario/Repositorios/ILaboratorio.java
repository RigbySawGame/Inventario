package com.example.Inventario.Repositorios;

import com.example.Inventario.Clase.Laboratorio;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaboratorio extends CrudRepository<Laboratorio, Integer> {

    @Query(value = "SELECT * FROM laboratorio "
            + "WHERE nombre LIKE %?1% "
            + "OR contacto LIKE %?1% "
            + "OR tipo LIKE %?1% ",
             nativeQuery = true)
    List<Laboratorio> findForAll(String desc);

}
