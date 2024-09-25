
package com.egg.biblioteca4.controladores;

import com.egg.biblioteca4.entidades.Editorial;
import com.egg.biblioteca4.excepciones.MiException;
import com.egg.biblioteca4.servicios.EditorialServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editorial") //localhost:8080/editorial
public class EditorialControlador {
    
    @Autowired
    private EditorialServicio editorialServicio;
    
    @GetMapping("/registrar")
    public String registrar(){
        return "editorial_form";
    }
    
    @PostMapping("/registro")
    public String registo(@RequestParam String nombre, ModelMap modelo){
        
        try {
            
            editorialServicio.crearEditorial(nombre);
            
            modelo.put("exito", "La editorial fue creada exitosamente");
            
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "editorial_form";
        }
        
        return "index";
    }
    
    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        
        List<Editorial> editoriales = editorialServicio.listarEditoriales();
        
        modelo.addAttribute("editoriales", editoriales);
        
        return "editorial_list";
    }
    
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo){
        
        modelo.put("editorial", editorialServicio.getOne(id));
        
        return "editorial_modificar";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String nombre, ModelMap modelo){
        
        try {
            editorialServicio.modificarEditorial(id, nombre);
            
            return "redirect:../lista";
            
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            
            return "editorial_modificar";
        }
        
        
    }
    
}
