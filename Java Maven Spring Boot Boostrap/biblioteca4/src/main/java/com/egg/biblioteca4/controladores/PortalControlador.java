
package com.egg.biblioteca4.controladores;

import com.egg.biblioteca4.entidades.Usuario;
import com.egg.biblioteca4.excepciones.MiException;
import com.egg.biblioteca4.servicios.UsuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class PortalControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/")
    public String index(){
        
        return "index";
    }
    
    @GetMapping("/registrar")
    public String registrar(){
        return "registro";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, 
            @RequestParam String password, @RequestParam String password2, ModelMap modelo, MultipartFile archivo){
        
        try {
            usuarioServicio.registrar(archivo, nombre, email, password, password2);
            
            modelo.put("exito", "Usuario registrado correctamente.");
            
            return "index";
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            
            return "registro";
        }
        
    }
    
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo){
        
        if (error!=null){
            modelo.put("error", "Usuario o contraseña invalida");
        }
        
        return "login";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session){
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        
        if(logueado.getRol().toString().equals("ADMIN")){
            return "redirect:/admin/dashboard";
        }
        
                return "inicio";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/perfil")
    public String perfil(ModelMap modelo, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        modelo.put("usuario", usuario);
        return "usuario_modificar";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/perfil/{id}")
    public String actualizar(MultipartFile archivo, @PathVariable String id, @RequestParam String nombre,@RequestParam String email,
            @RequestParam String password, @RequestParam String password2, ModelMap modelo){
        
        try {
            
            usuarioServicio.actualizar(archivo, password2, nombre, email, password, password2);
            
            modelo.put("exito", "Usuario actualizado correctamente");
            
            return "inicio";
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            
            return "usuario_modificar";
        }
    }
}
