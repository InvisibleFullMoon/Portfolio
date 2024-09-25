package entidades;

import java.util.ArrayList;
import java.util.List;
import servicios.barajaServicios;

public class Baraja {

    private List<Carta> barajaEspanola = new ArrayList<>();
    private List<Carta> monton = new ArrayList<>();

    public Baraja() {
    }

    public Baraja(List<Carta> barajaEspanola, List<Carta> monton) {
        this.barajaEspanola = barajaEspanola;
        this.monton = monton;
    }

    public List<Carta> getBarajaEspanola() {
        return barajaEspanola;
    }

    public void setBarajaEspanola(List<Carta> barajaEspanola) {
        this.barajaEspanola = barajaEspanola;
    }

    public List<Carta> getMonton() {
        return monton;
    }

    public void setMonton(List<Carta> monton) {
        this.monton = monton;
    }

    public void llenarMazo() {
        String[] palos = {"Espadas", "Bastos", "Oros", "Copas"};

        for (String palo : palos) {
            for (int numero = 1; numero <= 12; numero++) {
                if (numero != 8 && numero != 9) {
                    Carta carta = new Carta(numero, palo);
                    barajaEspanola.add(carta);
                }
            }
        }
    }
}
