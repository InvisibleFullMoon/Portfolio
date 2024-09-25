package Service;

import java.util.HashMap;
import java.util.Scanner;


public class tiendaService {
    
    
    public static HashMap<String, Integer> crearProducto(){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> listaProductos = new HashMap<>();
        
        while(true){
            System.out.println("\nMenú de la Tienda:");
            System.out.println("1) Agregar un producto");
            System.out.println("2) Modificar el precio de un producto");
            System.out.println("3) Eliminar un producto");
            System.out.println("4) Mostrar productos y precios");
            System.out.println("5) Salir");
            System.out.println("Elija una opcion...");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre del producto: ");
                    String producto = scanner.nextLine();
                    System.out.println("Ingrese el precio del producto: ");
                    Integer precio = scanner.nextInt();
                    listaProductos.put(producto, precio);
                    break;
                    
                    
                case 2:
                    System.out.println("Ingrese el nombre del producto que desea modificar: ");
                    String productoMod = scanner.nextLine();
                    if(listaProductos.containsKey(productoMod)){
                        System.out.println("Ingrese el nuevo precio: ");
                        Integer nuevoPrecio = scanner.nextInt();
                        listaProductos.put(productoMod, nuevoPrecio);
                        System.out.println("Producto modificado con exito.");
                    }else{
                        System.out.println("El producto ingresado no existe en el inventario...");
                    }
                    break;
                    
                case 3:
                    System.out.println("Ingrese el nombre del producto que desea eliminar: ");
                    String productoEliminar = scanner.nextLine();
                    if(listaProductos.containsKey(productoEliminar)){
                        listaProductos.remove(productoEliminar);
                        System.out.println("Producto eliminado con exito.");
                    }else{
                        System.out.println("El producto no existe en el inventario");
                    }
                    break;
                
                case 4: 
                    System.out.println("Productos en el inventario: ");
                    for(HashMap.Entry<String, Integer> entry : listaProductos.entrySet()){
                        System.out.println(entry.getKey() + ": $"+entry.getValue());
                    }
                    break;
                    
                case 5:
                    System.out.println("Gracias por usar la aplicacion, finalizando...");
                    scanner.close();
                    System.exit(0);
                
                default:
                    System.out.println("Opcion no valida, por favor eliga una opcion valida.");
                    break;
            }
        }
    }
}