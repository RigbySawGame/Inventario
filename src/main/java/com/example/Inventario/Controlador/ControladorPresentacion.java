
package com.example.Inventario.Controlador;
import com.example.Inventario.Clase.Presentacion;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Inventario.Interfaces.IPresentacionService;
import java.util.List;

@RequestMapping("/presentacion/")
@Controller
public class ControladorPresentacion {
    
    String carpeta = "presentacion/";
    
    @Autowired
    private IPresentacionService service;
    
    @GetMapping("/nuevo")
    public String NuevoTipo() {

        return carpeta + "nuevoPresentacion"; //nuevoPresentacion.html
    }
    
    @PostMapping("/registrar") //localhost/registrar
    public String RegistrarPresentacion(
            @RequestParam("nom") String nom,
            @RequestParam("nomC") String nomC,
            Model model) {
        //Aqui va el proceso de registrar
        Presentacion c = new Presentacion();
        c.setNombre(nom);
        c.setNombreC(nomC);
        
        service.Guardar(c);
        return ListarPresentacion(model);
    }
    
    @GetMapping("/Lista") //localhost/
    public String ListarPresentacion(Model model) {
        model.addAttribute("presentacion",service.Listar());
        return carpeta + "listaPresentacion"; //listaPresentacion.html
    }
    
    @GetMapping("/eliminar")//localhost/eliminar
    public String EliminarPresentacion(@RequestParam("cod") int cod,
            Model model) {
        service.Eliminar(cod);
        return ListarPresentacion(model);
    }
    
    @GetMapping("/editar")//localhost/editar
    public String EditarPresentacion(@RequestParam("cod") int cod,
            Model model) {
        
        Optional<Presentacion> lc = service.ConsultarId(cod);
        model.addAttribute("presentacion", lc);
        return carpeta + "editarPresentacion"; // editarTipo.html
    }
    @PostMapping("/actualizar") //localhost/actualizarU
    public String ActualizarTipo (
            @RequestParam("codigo") int cod,
            @RequestParam("nombre") String nom,
            @RequestParam("nombreC") String nomC,
            Model model ) {
        //Aqui va el proceso de actualizar
        
        Presentacion d = new Presentacion();
        d.setCodigo(cod);
        d.setNombre(nom);
        d.setNombreC(nomC);
        
        service.Guardar(d);
        return ListarPresentacion(model);
    }
    @PostMapping("/buscar")
    public String BuscarTipo(@RequestParam("desc") String desc,
            Model model) {
        
        List<Presentacion> lc = service.Buscar(desc);
        model.addAttribute("presentacion", lc);
        return carpeta + "listaPresentacion";
    }
   

}
