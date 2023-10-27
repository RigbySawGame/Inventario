package com.example.Inventario.Controlador;

import com.example.Inventario.Clase.Laboratorio;
import com.example.Inventario.Interfaces.ILaboratorioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RequestMapping("/laboratorio/")
@Controller
public class ControladorLaboratorio {

    ArrayList<Laboratorio> lista = new ArrayList();
    String carpeta = "laboratorio/";

    @Autowired
    private ILaboratorioService service;

    @GetMapping("/nuevoL")
    public String NuevoLaboratorio() {
        return carpeta + "nuevoLaboratorio";
    }

    @PostMapping("registrarL")
    public String RegistrarLaboratorio(
            @RequestParam("nom") String nom,
            @RequestParam("con") String con,
            @RequestParam("tip") String tip,
            Model model) {
        Laboratorio c = new Laboratorio();
        c.setNombre(nom);
        c.setContacto(con);
        c.setTipo(tip);

        service.Guardar(c);
        return ListarLaboratorio(model);

    }

    @GetMapping("/ListaL") //localhost/
    public String ListarLaboratorio(Model model) {
        model.addAttribute("laboratorio", service.Listar());
        return carpeta + "listalaboratorio"; //listaCliente.html
    }

    @GetMapping("/eliminarL")//localhost/eliminar
    public String EliminarLaboratorio(@RequestParam("num") int num,
            Model model) {
        service.Eliminar(num);
        return ListarLaboratorio(model);
    }

    @GetMapping("/editarL")//localhost/editar
    public String EditarLaboratorio(@RequestParam("num") int num,
            Model model) {

        Optional<Laboratorio> lab = service.ConsultarId(num);
        model.addAttribute("laboratorio", lab);
        return carpeta + "editarLaboratorio"; // editarCliente.html
    }

    @PostMapping("/actualizarL") //localhost/actualizar
    public String ActualizarLaboratorio(@RequestParam("numIdentificacion") int num,
            @RequestParam("nombre") String nom,
            @RequestParam("contacto") String con,
            @RequestParam("tipo") String tip,
            Model model) {
        //Aqui va el proceso de actualizar
        Laboratorio d = new Laboratorio();
        d.setNumIdentificacion(num);
        d.setNombre(nom);
        d.setContacto(con);
        d.setTipo(tip);

        service.Guardar(d);
        return ListarLaboratorio(model);
    }

    @PostMapping("/buscarL")
    public String BuscarLaboratorio(@RequestParam("desc") String desc,
            Model model) {

        List<Laboratorio> lc = service.Buscar(desc);
        model.addAttribute("laboratorio", lc);
        return carpeta + "listaLaboratorio";
    }

}
