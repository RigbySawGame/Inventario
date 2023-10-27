
package com.example.Inventario.Servicios;
import com.example.Inventario.Clase.Presentacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.Interfaces.IPresentacionService;
import com.example.Inventario.Repositorios.IPresentacion;

@Service
public class PresentacionService implements IPresentacionService{

    @Autowired
    private IPresentacion data;

    @Override
    public List<Presentacion> Listar() {
        return (List<Presentacion>)data.findAll(); 
    }

    @Override
    public Optional<Presentacion> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Presentacion c) {
        data.save(c);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Presentacion> Buscar(String desc) {
        return data.findForAll(desc);
    }
    
    
    
}
