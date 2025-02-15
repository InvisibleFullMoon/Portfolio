
package com.egg.biblioteca4.controladores;

import com.egg.biblioteca4.entidades.Autor;
import com.egg.biblioteca4.entidades.Editorial;
import com.egg.biblioteca4.entidades.Libro;
import com.egg.biblioteca4.excepciones.MiException;
import com.egg.biblioteca4.servicios.AutorServicio;
import com.egg.biblioteca4.servicios.EditorialServicio;
import com.egg.biblioteca4.servicios.LibroServicio;
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
@RequestMapping("/libro")
public class LibroControlador {
    
    @Autowired
    private LibroServicio libroServicio;
    @Autowired
    private AutorServicio autorServicio;
    @Autowired
    private EditorialServicio editorialServicio;
    
    
    @GetMapping("/registrar") //localhost:8080/libro/registrar
    public String registrar(ModelMap modelo){
        List<Autor> autores = autorServicio.listarAutores();
        List<Editorial> editoriales = editorialServicio.listarEditoriales();
        
        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);
        
        return "libro_form";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo,
            @RequestParam(required = false) Integer ejemplares, @RequestParam String idAutor,
            @RequestParam String idEditorial, ModelMap modelo) {

        try {

            libroServicio.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);

            modelo.put("exito", "El libro fue cargado correctamente!");

        } catch (MiException ex) {
            List<Autor> autores = autorServicio.listarAutores();
            List<Editorial> editoriales = editorialServicio.listarEditoriales();

            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
            
            modelo.put("error", ex.getMessage());

            return "libro_form";
        }
        return "index";
    }
    
    
    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        List<Libro> libros = libroServicio.listarLibros();
        modelo.addAttribute("libros", libros);
        
        return "libro_list";
    }
    
    @GetMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn, ModelMap modelo){
        
        modelo.put("libro", libroServicio.getOne(isbn));
        
        List<Autor> autores = autorServicio.listarAutores();
        List<Editorial> editoriales = editorialServicio.listarEditoriales();
        
        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);
        
        return "libro_modificar";
    }
    
    @PostMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial, ModelMap modelo){
        
        try {
            List<Autor> autores = autorServicio.listarAutores();
            List<Editorial> editoriales = editorialServicio.listarEditoriales();
            
            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
            
            libroServicio.modificarLibro(isbn, titulo, idAutor, idEditorial, ejemplares);
            
            return "redirect:../lista";
            
        } catch (MiException ex) {
            List<Autor> autores = autorServicio.listarAutores();
            List<Editorial> editoriales = editorialServicio.listarEditoriales();
            
            modelo.put("error", ex.getMessage());
            
            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
            
            return "libro_modificar";
        }
        
    }
    

}
