package servicios;

import entidades.Baraja;
import entidades.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class barajaServicios {

    public void barajar(List<Carta> baraja) {
        Collections.shuffle(baraja);
    }

    public void cartasDisponibles(List<Carta> baraja) {
        System.out.println("Cantidad de cartas disponibles: " + baraja.size());
    }

    public void cartasMonton(List<Carta> monton) {
        System.out.println("----------------------");
        System.out.println("Cartas en el monton: ");
        for (Carta carta : monton) {
            System.out.println(carta.getNumero() + " de " + carta.getPalo());
        }
    }

    public void mostrarBaraja(List<Carta> baraja) {
        System.out.println("----------------------");
        for (Carta carta : baraja) {
            System.out.println(carta.getNumero() + " de " + carta.getPalo());
        }
        System.out.println("----------------------");
    }

    public void siguienteCarta(List<Carta> baraja, List<Carta> monton) {
        if (baraja.isEmpty()) {
            System.out.println("No hay mas cartas para repartir");
        } else {
            Carta objetoMovido = baraja.remove(0);
            System.out.println("Sacas una carta de la pila...");
            System.out.println("Sacaste: " + objetoMovido.getNumero() + " de " + objetoMovido.getPalo());
            System.out.println("y ahora se va al monton...");
            monton.add(objetoMovido);
        }
    }

    public void darCartas(List<Carta> baraja, int limite, List<Carta> monton) {
        if (limite > baraja.size()) {
            System.out.println("----------------------");
            System.out.println("No hay suficientes cartas para entregar...");
            System.out.println("----------------------");
        } else {
            System.out.println("----------------------");
            System.out.println("Salieron las siguientes cartas: ");
            for (int i = limite - 1; i >= 0; i--) {
                Carta elemento = baraja.remove(i);
                monton.add(elemento);
                System.out.println("Sacaste: " + elemento.getNumero() + " de " + elemento.getPalo());
            }
            System.out.println("----------------------");
        }
    }

}
