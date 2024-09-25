
package com.egg.biblioteca4.servicios;

import com.egg.biblioteca4.entidades.Editorial;
import com.egg.biblioteca4.excepciones.MiException;
import com.egg.biblioteca4.repositorios.EditorialRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {
    
    @Autowired
    EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void crearEditorial(String nombre) throws MiException{
        
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
        
        Editorial editorial = new Editorial();
        
        editorial.setNombre(nombre);
        
        editorialRepositorio.save(editorial);
    }
    
    public List<Editorial> listarEditoriales(){
        
        List<Editorial> editoriales = new ArrayList();
        
        editoriales = editorialRepositorio.findAll();
        
        return editoriales;
    }
    
    public void modificarEditorial(String id, String nombre) throws MiException{
        
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
        if(id.isEmpty() || id == null){
            throw new MiException("id no puede ser nulo o estar vacio");
        }
        
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            Editorial editorial = respuesta.get();
            
            editorial.setNombre(nombre);
            
            editorialRepositorio.save(editorial);
        }
    }
    
    public Editorial getOne (String id){
        return editorialRepositorio.getOne(id);
    }
    
}
