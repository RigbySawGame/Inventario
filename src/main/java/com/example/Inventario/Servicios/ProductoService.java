
package com.example.Inventario.Servicios;

import com.example.Inventario.Clase.Producto;
import com.example.Inventario.Interfaces.IProductoService;
import com.example.Inventario.Repositorios.IProducto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
       @Autowired
    private IProducto data;

    @Override
    public List<Producto> Listar() {
   return (List<Producto>)data.findAll(); 
    }

    @Override
     public Optional<Producto> ConsultarId(int id) {
          return data.findById(id);
   }

    @Override
    public void Guardar(Producto p) {
        data.save(p);
   }

    @Override
    public void Eliminar(int id) {
         data.deleteById(id);
     
    }

    @Override
    public List<Producto> Buscar(String desc) {
        return data.findForAll(desc);
    }
    
}
