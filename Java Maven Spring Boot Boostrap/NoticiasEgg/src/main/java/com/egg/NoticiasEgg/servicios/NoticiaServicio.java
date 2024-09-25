package com.egg.NoticiasEgg.servicios;

import com.egg.NoticiasEgg.entidades.Noticia;
import com.egg.NoticiasEgg.entidades.Periodista;
import com.egg.NoticiasEgg.entidades.Usuario;
import com.egg.NoticiasEgg.enumeraciones.Rol;
import com.egg.NoticiasEgg.excepciones.MiException;
import com.egg.NoticiasEgg.repositorios.NoticiaRepositorio;
import com.egg.NoticiasEgg.repositorios.UsuarioRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class NoticiaServicio {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Noticia> listarNoticias() {
        return noticiaRepositorio.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Noticia crearNoticia(String titulo, String cuerpo) throws MiException {

        validar(titulo, cuerpo);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);

        if (usuario.getRol() == Rol.PERIODISTA) {
            Periodista creador = (Periodista) usuario;

            Noticia noticia = new Noticia();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticia.setCreador(creador);
            
            creador.getMisNoticias().add(noticia);
            
            usuarioRepositorio.save(creador);

            return noticiaRepositorio.save(noticia);
        } else if (usuario.getRol() == Rol.ADMIN) {
            
            Noticia noticia = new Noticia();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticia.setCreador(null); // O setear un creador genérico o distinto tratamiento para ADMIN

            return noticiaRepositorio.save(noticia);
        } else {
            throw new MiException("Solo periodistas y administradores pueden crear noticias.");
        }
    }

    public Noticia modificarNoticia(Long id, String titulo, String cuerpo) throws MiException {

        validar(titulo, cuerpo);

        if (id == null) {
            throw new MiException("el id no puede ser nulo");
        }

        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            return noticiaRepositorio.save(noticia);
        } else {
            throw new MiException("No se encontró una noticia con el id proporcionado");
        }
    }

    public void eliminarNoticia(Long id) {
        noticiaRepositorio.deleteById(id);
    }

    public Noticia obtenerNoticiaPorId(Long id) throws MiException {
        return noticiaRepositorio.findById(id)
                .orElseThrow(() -> new MiException("No se encontró una noticia con el id proporcionado"));
    }

    private void validar(String titulo, String cuerpo) throws MiException {

        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("el titulo no puede ser nulo o estar vacio");
        }
        if (cuerpo.isEmpty() || cuerpo == null) {
            throw new MiException("el cuerpo no puede ser nulo o estar vacio");
        }
    }

    public Noticia getOne(Long id) {
        return noticiaRepositorio.getOne(id);
    }

}
