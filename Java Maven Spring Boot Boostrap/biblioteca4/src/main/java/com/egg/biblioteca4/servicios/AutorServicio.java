
package com.egg.biblioteca4.servicios;

import com.egg.biblioteca4.entidades.Autor;
import com.egg.biblioteca4.excepciones.MiException;
import com.egg.biblioteca4.repositorios.AutorRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {
    
    @Autowired
    AutorRepositorio autorRepositorio;
    
    @Transactional
    public void crearAutor(String nombre) throws MiException{
        
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
        
        Autor autor = new Autor();
        
        autor.setNombre(nombre);
        
        autorRepositorio.save(autor);
    }
    
    public List<Autor> listarAutores(){
        
        List<Autor> autores = new ArrayList();
        
        autores = autorRepositorio.findAll();
        
        return autores;
    }
    
    public void modificarAutor(String nombre, String id) throws MiException{
        
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
        if(id.isEmpty() || id == null){
            throw new MiException("id no puede ser nulo o estar vacio");
        }
        
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        
        if (respuesta.isPresent()){
            
            Autor autor = respuesta.get();
            
            autor.setNombre(nombre);
            
            autorRepositorio.save(autor);
            
        }
    }
    
    public Autor getOne(String id){
        return autorRepositorio.getOne(id);
    }
    
    
    
}
