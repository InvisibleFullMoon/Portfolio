
package com.egg.NoticiasEgg.repositorios;

import com.egg.NoticiasEgg.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, Long>{
    
}