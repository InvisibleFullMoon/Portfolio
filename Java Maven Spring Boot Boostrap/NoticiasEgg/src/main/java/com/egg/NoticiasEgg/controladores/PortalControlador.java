
package com.egg.NoticiasEgg.controladores;

import com.egg.NoticiasEgg.entidades.Noticia;
import com.egg.NoticiasEgg.excepciones.MiException;
import com.egg.NoticiasEgg.servicios.NoticiaServicio;
import com.egg.NoticiasEgg.servicios.UsuarioServicio;
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
public class PortalControlador {
    
    @Autowired
    private NoticiaServicio noticiaServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/")
    public String inicio(ModelMap modelo){
        List<Noticia> noticias = noticiaServicio.listarNoticias();
        modelo.addAttribute("noticias", noticias);
        return "inicio";
    }
    
    @GetMapping("/noticias/detalle/{id}")
    public String mostrarNoticia(@PathVariable("id") Long id, ModelMap modelo) {
        try {
            Noticia noticia = noticiaServicio.obtenerNoticiaPorId(id);

            modelo.addAttribute("noticia", noticia);

            return "noticia";

        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());

            return "inicio";
        }
    }
    
    //metodo para mostrar la pagina de registro para usuarios
    @GetMapping("/registrar")
    public String registrar(){
        return "registro";
    }
    
    //metodo que recibe los datos del registro
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, 
            @RequestParam String password, @RequestParam String password2, ModelMap modelo){
        
        try {
            usuarioServicio.registrar(nombre, email, password, password2);
            
            modelo.put("exito", "Usuario registrado correctamente.");
            return "redirect:/";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            
            return "registro";
        }
    }
    
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo){
        if (error != null){
            modelo.put("error", "Usuario o contraseña invalida");
        }
        
        return "login";
    }
    
    
}
