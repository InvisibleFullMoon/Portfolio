package guiarelacionesej3;

import entidades.Baraja;
import entidades.Carta;
import java.util.Scanner;
import servicios.barajaServicios;

public class GuiaRelacionesEj3 {

    public static void main(String[] args) {

        Baraja b = new Baraja();
        barajaServicios bs = new barajaServicios();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creando la baraja...");
        b.llenarMazo();
        System.out.println("Listo.");

        bs.mostrarBaraja(b.getBarajaEspanola());

        System.out.println("Ahora barajamos las cartas...");
        bs.barajar(b.getBarajaEspanola());
        System.out.println("Listo.");

        bs.mostrarBaraja(b.getBarajaEspanola());

        bs.cartasDisponibles(b.getBarajaEspanola());

        bs.siguienteCarta(b.getBarajaEspanola(), b.getMonton());
        
        bs.cartasMonton(b.getMonton());

        bs.mostrarBaraja(b.getBarajaEspanola());

        bs.cartasDisponibles(b.getBarajaEspanola());

        System.out.println("Eliga una cantidad de cartas que quiere sacar...");
        bs.darCartas(b.getBarajaEspanola(), scanner.nextInt(), b.getMonton());

        bs.cartasDisponibles(b.getBarajaEspanola());

        bs.mostrarBaraja(b.getBarajaEspanola());
        
        bs.cartasMonton(b.getMonton());
    }
}
