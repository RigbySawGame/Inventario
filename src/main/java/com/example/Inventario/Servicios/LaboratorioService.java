/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Inventario.Servicios;

import com.example.Inventario.Clase.Laboratorio;
import com.example.Inventario.Interfaces.ILaboratorioService;
import com.example.Inventario.Repositorios.ILaboratorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratorioService implements ILaboratorioService{
    
    @Autowired
    private ILaboratorio data;

    @Override
    public List<Laboratorio> Listar() {
       return (List<Laboratorio>)data.findAll(); 
    }

    @Override
    public Optional<Laboratorio> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Laboratorio c) {
        data.save(c);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Laboratorio> Buscar(String desc) {
        return data.findForAll(desc);
    }
    
}
