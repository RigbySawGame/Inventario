
package com.example.Inventario.Controlador;

import com.example.Inventario.Clase.Cliente;
import com.example.Inventario.Interfaces.IClienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/cliente/")
@Controller
public class ControladorCliente {
    
    ArrayList<Cliente> lista = new ArrayList();
    String carpeta = "cliente/";
    
    @Autowired
    private IClienteService service;
    
    @GetMapping("/nuevoC") //localhost/cliente/nuevo
    public String NuevoCliente(){
        return carpeta+"nuevoCliente"; //nuevoCliente.html
    }
    
    @PostMapping("/registrarC") //localhost/cliente/registrarC
    public String RegistrarCliente(
            @RequestParam("nom") String nom,
            @RequestParam("ape") String ape,
            @RequestParam("dni") String dni,
            @RequestParam("cel") String cel,
            @RequestParam("email") String email,
            @RequestParam("dir") String dir,
            Model model)  
    {
        
        Cliente c = new Cliente();
        c.setNombre(nom);
        c.setApellido(ape);
        c.setDni(dni);
        c.setCelular(cel);
        c.setEmail(email);
        c.setDireccion(dir);
        
        service.Guardar(c);
        return ListarCliente(model);
    }
    
    @GetMapping("/ListaC") //localhost/
    public String ListarCliente(Model model){
        model.addAttribute("clientes",service.Listar());
        return carpeta+"listaCliente";
    }
    
    @GetMapping("/eliminarC")//localhost/eliminar
    public String EliminarCliente(@RequestParam("cod") int cod,
            Model model) {
        service.Eliminar(cod);
        return ListarCliente(model);
        }
        
    
    
    @GetMapping("/editarC") //localhost/editar
    public String EditarCliente(@RequestParam("cod")int cod,
                                  Model model)
    {
       Optional<Cliente> pro = service.ConsultarId(cod);
       model.addAttribute("cliente", pro);
       return carpeta + "editarCliente";
        
    }
    
    @PostMapping("/actualizarC") //localhost/actualizar
    public String ActualizarCliente(@RequestParam("codigo") int cod,
            @RequestParam("nombre") String nom,
            @RequestParam("apellido") String ape,
            @RequestParam("dni") String dni,
            @RequestParam("celular") String cel,
            @RequestParam("email") String email,
            @RequestParam("direccion") String dir,
            Model model)
    {
        Cliente c = new Cliente();
        c.setCodigo(cod);
        c.setNombre(nom);
        c.setApellido(ape);
        c.setDni(dni);
        c.setCelular(cel);
        c.setEmail(email);
        c.setDireccion(dir);
        
        service.Guardar(c);
        return ListarCliente(model);
        
    }
    
    @PostMapping("/buscarC") //localhost/buscar
    public String BuscarCliente(@RequestParam("desc") String desc,
                                Model model)
    {
        List<Cliente> ld = service.Buscar(desc);
        model.addAttribute("cliente", ld);
        return carpeta + "listaCliente";
    }
}
          

