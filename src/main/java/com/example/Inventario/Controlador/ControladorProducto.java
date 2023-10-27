package com.example.Inventario.Controlador;

import com.example.Inventario.Clase.Producto;
import com.example.Inventario.Interfaces.IProductoService;

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


@RequestMapping("/producto/") //localhost/proveedor
@Controller
public class ControladorProducto {

    ArrayList<Producto> lista3 = new ArrayList();
    String carpeta3 = "/producto/";

    @Autowired
    private IProductoService service;

    @GetMapping("/nuevoP") //localhost/nuevoProve   
    public String NuevoProducto() {

        return carpeta3 + "nuevoProducto"; //nuevoProveedor.html (nombre de la vista html en templates)
    }

    @PostMapping("/registrarP") // localhost/registrarProve (esto se ejecuta ahi)
    public String RegistrarProveedor(
            @RequestParam("nom") String nom,
            @RequestParam("pre") String pre,
            @RequestParam("can") String can,
            @RequestParam("fec") String fec,
            Model model) {
        //Aqui va el proceso de registrar

        Producto p = new Producto();

        p.setNombre(nom);
        p.setPrecio(pre);
        p.setCantidad(can);
        p.setFecha(fec);
        lista3.add(p);
        service.Guardar(p);
        return ListarProducto(model); //Llamamos la misma funcion porque tiene las mismas lineas de codigo
    }

    @GetMapping("/ListaP") //localhost/proveedores
    public String ListarProducto(Model model) {
        model.addAttribute("producto", service.Listar()); //Enviamos la lista

        return carpeta3 + "listaProducto"; //le enviamos la vista de listaProveedor.html
    }

    @GetMapping("/eliminarP")
    public String EliminarProducto(@RequestParam("cod") int cod,
            Model model) {

        service.Eliminar(cod);
        return ListarProducto(model);
    }

    @GetMapping("/editarP")
    public String EditarProducto(@RequestParam("cod") int cod,
            Model model) {
        Optional<Producto> lc = service.ConsultarId(cod);
        model.addAttribute("producto", lc); //"alias", valor
        return carpeta3 + "editarProducto"; //editarCliente.html
    }

    @PostMapping("/actualizarP")
    public String ActualizarProducto(@RequestParam("codigo") int cod,
            @RequestParam("nombre") String nom,
            @RequestParam("precio") String pre,
            @RequestParam("cantidad") String can,
            @RequestParam("fecha") String fec,
            Model model) {
        Producto p = new Producto();
        p.setCodigo(cod);
        p.setNombre(nom);
        p.setPrecio(pre);
        p.setCantidad(can);
        p.setFecha(fec);
       service.Guardar(p);
        return ListarProducto(model);
    }

    @PostMapping("/buscarP")
    public String BuscarProducto(@RequestParam("desc") String desc, Model model) //desc = variable que se ingresa
    {
        
        List<Producto> lc = service.Buscar(desc);
        model.addAttribute("producto", lc);
        return carpeta3 + "listaProducto";
    }

}
