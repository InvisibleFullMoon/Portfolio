
package com.egg.NoticiasEgg.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Periodista extends Usuario {
    
    private Integer sueldoMensual;
    
    @OneToMany(mappedBy = "creador")
    private List<Noticia> misNoticias = new ArrayList<>();

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Integer sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public List<Noticia> getMisNoticias() {
        return misNoticias;
    }

    public void setMisNoticias(List<Noticia> misNoticias) {
        this.misNoticias = misNoticias;
    }
    
    
}
