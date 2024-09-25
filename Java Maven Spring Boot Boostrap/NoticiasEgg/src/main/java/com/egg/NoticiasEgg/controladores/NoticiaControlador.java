package com.egg.NoticiasEgg.controladores;

import com.egg.NoticiasEgg.entidades.Noticia;
import com.egg.NoticiasEgg.entidades.Usuario;
import com.egg.NoticiasEgg.excepciones.MiException;
import com.egg.NoticiasEgg.servicios.NoticiaServicio;
import com.egg.NoticiasEgg.servicios.UsuarioServicio;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticias")
public class NoticiaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PERIODISTA')")
    @GetMapping("/admin")
    public String panelAdmin() {
        return "panelAdmin";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/usuarios")
    public String listarUsuario(ModelMap modelo) {

        List<Usuario> usuarios = usuarioServicio.listarUsuarios();

        modelo.addAttribute("usuarios", usuarios);

        return "usuario_list";
    }

    @PostMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable String id) {

        usuarioServicio.eliminarUsuario(id);

        return "redirect:/noticias/usuarios";
    }
    
    @PostMapping("/dardealta")
    public String darDeAlta(@RequestParam String id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDeAlta, ModelMap modelo, @RequestParam Integer sueldoMensual ){
        usuarioServicio.darDeAlta(id, fechaDeAlta, sueldoMensual);
        modelo.put("exito", "Periodista dado de alta exitosamente");
        
        return "redirect:/noticias/usuarios";
    }

    @GetMapping("/creador")
    public String crear() {
        return "noticia_crear";
    }

    @PostMapping("/crear")
    public String crearNoticia(@RequestParam String titulo, @RequestParam String cuerpo, ModelMap modelo) {
        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            modelo.put("exito", "La noticia fue creada exitosamente!");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "noticia_crear";
        }

        return "redirect:/";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PERIODISTA')")
    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Noticia> noticias = noticiaServicio.listarNoticias();

        modelo.addAttribute("noticias", noticias);

        return "noticia_list";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, ModelMap modelo) {

        modelo.put("noticia", noticiaServicio.getOne(id));

        return "noticia_modificar";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, String titulo, String cuerpo, ModelMap modelo) {

        try {
            noticiaServicio.modificarNoticia(id, titulo, cuerpo);
            return "redirect:../lista";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());

            return "noticia_modificar";
        }

    }

    @PostMapping("/eliminar/{id}")
    public String eliminarNoticia(@PathVariable Long id) {
        noticiaServicio.eliminarNoticia(id);

        return "redirect:/noticias/lista";
    }

}
