package sprint.pkg1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author victor
 */
public class SPRINT1 {
    public static Scanner lector = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(System.in);
                System.out.println("---- MENU CAMARERO -----");
                System.out.println("1. -- Crear Mesa");
                System.out.println("2. -- Ver Mesas");
                System.out.println("3. -- Borrar Mesa");
                switch (pideEntero(in)) {
            case 1: //Indica la ruta a una carpeta, crea/escriu al arxiu
                CrearMesa();
                break;
            case 2:                
                ListarMesas();
                break;
            case 3:
                EliminarMesa();
                break;
        }
        
    }
 

    public static void CrearMesa() {
        try{
            File fichero = new File("C:\\Users\\alumne\\Desktop\\SPRINT 1\\src\\sprint\\pkg1\\tables.txt");
            FileWriter ficheromesas = new FileWriter(fichero);
            String linea = pedirdatos();
            ficheromesas.write(linea);
            ficheromesas.close();
        } catch (Exception e){
            System.out.println("No se ha podido añadir una mesa");
        }
    }

    public static String pedirdatos(){
        String nombre, descripcion, niños, ventilador, jardin;
        int capacidad, adultos;
        boolean nenes, venti, jar;
        System.out.print("Dame el nombre de la nueva mesa: ");
        nombre = lector.next();
        System.out.print("Dame la descripcion de la mesa: ");
        descripcion = lector.next();
        System.out.print("Dame la capacidad maxima de personas en la mesa: ");
        capacidad = lector.nextInt();
        System.out.print("Hay sillas de niños en la mesa? ");
        niños = lector.next().toLowerCase();
        String linea = "\n" + nombre + "," + descripcion + "," + capacidad + "," + niños;
        return linea;
    }
    
    
    
    public static void ListarMesas() {
           System.out.println();
    }
    
    //ELIMINA UNA MESA DEL ARCHIVO TXT
    public static void EliminarMesa() {
        File fichero = new File("C:\\Users\\alumne\\Desktop\\SPRINT 1\\src\\sprint\\pkg1\\tables.txt");
        // Array para guardar todas las líneas leídas del fichero
        ArrayList<String> lineas = new ArrayList<>();

        // Abrimos el fichero de texto para leerlo en memoria
        try {
            Scanner lectorFichero = new Scanner(fichero);
            int i = 0;
            while (lectorFichero.hasNext()) {
                lineas.add(lectorFichero.nextLine());
            }
            lectorFichero.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }
        // Abrimos el fichero de texto para sobreescribirlo
        // Eliminaremos la línea 3
        try {
            FileWriter writer = new FileWriter(fichero);

            for (String linea : lineas) {
                if (!"Línea 3".equals(linea)) {
                    writer.write(linea + "\n");
                }
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/sobreescribir el fichero");
        }

    }
    
    //PEDIR ENTERO PARA EL MENú
    public static int pideEntero(Scanner in) {
        int n = 0;
        boolean correcte = false;

        do {
            if (!in.hasNextInt()) {
                System.out.println("No és un nombre enter");
            } else {
                n = in.nextInt();
                correcte = true;
            }
            in.nextLine();
        } while (!correcte);
        return n;
    }
    
}
     
   
    

