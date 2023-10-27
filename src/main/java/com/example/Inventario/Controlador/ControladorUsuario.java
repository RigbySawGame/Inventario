package com.example.Inventario.Controlador;

import com.example.Inventario.Clase.Usuario;
import com.example.Inventario.Interfaces.IUsuarioService;
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

@RequestMapping("/usuario/")
@Controller
public class ControladorUsuario {

    ArrayList<Usuario> listaU = new ArrayList();
    String carpeta = "usuario/";
    
    @Autowired
    private IUsuarioService service;

    @GetMapping("/nuevoU")
    public String NuevoUsuario() {

        return carpeta + "nuevoUsuario"; //nuevoUsuario.html
    }

    @PostMapping("/registrarU") //localhost/registrarU
    public String RegistrarUsuario(
            @RequestParam("nomU") String nomU,
            @RequestParam("correo") String correo,
            @RequestParam("usua") String usua,
            Model model) {
        //Aqui va el proceso de registrar
        Usuario d = new Usuario();
        d.setNombreU(nomU);
        d.setCorreo(correo);
        d.setUsuario(usua);

        service.Guardar(d);
        return ListarUsuario(model);
    }

    @GetMapping("/Lista") //localhost/
    public String ListarUsuario(Model model) {
        model.addAttribute("usuario",service.Listar());
        return carpeta + "listaUsuario"; //listaUsuario.html
    }

    @GetMapping("/eliminarU")//localhost/eliminar
    public String EliminarUsuario(@RequestParam("cod") int cod,
            Model model) {
        service.Eliminar(cod);
        return ListarUsuario(model);
        
    }

    @GetMapping("/editarU")//localhost/editarPro
    public String EditarUsuario(@RequestParam("cod") int cod,
            Model model) {
        
        Optional<Usuario> pro = service.ConsultarId(cod);
        model.addAttribute("usuario", pro);
        return carpeta + "editarUsuario"; // editarUsuario.html
    }

    @PostMapping("/actualizarU") //localhost/actualizarU
    public String ActualizarUsuario(
            @RequestParam("Codigo") int cod,
            @RequestParam("NombreU") String nomU,
            @RequestParam("Correo") String correo,
            @RequestParam("Usuario") String usua,
            Model model ) {
        //Aqui va el proceso de actualizar
        
        Usuario d = new Usuario();
        d.setCodigo(cod);
        d.setNombreU(nomU);
        d.setCorreo(correo);
        d.setUsuario(usua);
        
        service.Guardar(d);
        return ListarUsuario(model);
    }
    @PostMapping("/buscarU")
    public String BuscarUsuario(@RequestParam("desc") String desc,
            Model model) {
        
        List<Usuario> lc = service.Buscar(desc);
        model.addAttribute("usuario", lc);
        return carpeta + "listaUsuario";
    }
}
