package com.egg.NoticiasEgg.servicios;

import com.egg.NoticiasEgg.entidades.Periodista;
import com.egg.NoticiasEgg.entidades.Usuario;
import com.egg.NoticiasEgg.enumeraciones.Rol;
import com.egg.NoticiasEgg.excepciones.MiException;
import com.egg.NoticiasEgg.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws MiException {

        validar(nombre, email, password, password2);

        Usuario usuario = new Usuario();

        usuario.setNombreUsuario(nombre);
        usuario.setEmail(email);

        usuario.setPassword(new BCryptPasswordEncoder().encode(password));

        usuario.setRol(Rol.USER);

        usuarioRepositorio.save(usuario);
    }

    public void darDeAlta(String id, Date fechaDeAlta, Integer sueldoMensual) {
        Optional<Usuario> optionalUser  = usuarioRepositorio.findById(id);

        if (optionalUser.isPresent()) {
        Usuario usuario = optionalUser.get();

        // Crear una nueva instancia de Periodista con los datos del usuario
        Periodista periodista = new Periodista();
        periodista.setId(usuario.getId());
        periodista.setEmail(usuario.getEmail());
        periodista.setNombreUsuario(usuario.getNombreUsuario());
        periodista.setPassword(usuario.getPassword());
        periodista.setFechaDeAlta(fechaDeAlta);
        periodista.setActivo(true);
        periodista.setRol(Rol.PERIODISTA);
        periodista.setSueldoMensual(sueldoMensual);

        // Guardar el nuevo periodista y eliminar el antiguo usuario
        usuarioRepositorio.save(periodista);
        usuarioRepositorio.delete(usuario);
    } else {
        throw new IllegalArgumentException("Usuario no encontrado.");
    }

    }

    @Transactional
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = new ArrayList();

        usuarios = usuarioRepositorio.findAll();

        return usuarios;
    }

    public void eliminarUsuario(String id) {
        usuarioRepositorio.deleteById(id);
    }

    public Usuario getOne(String id) {
        return usuarioRepositorio.getOne(id);
    }

    private void validar(String nombre, String email, String password, String password2) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede estar nulo o vacio");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("El email no puede ser nulo o vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacia y debe tener mas de 5 digitos");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            HttpSession session = attr.getRequest().getSession(true);

            session.setAttribute("usuariosession", usuario);

            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else {
            return null;
        }
    }
}
