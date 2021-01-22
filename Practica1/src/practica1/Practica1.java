package practica1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ximbo
 */
public class Practica1 {

    public static void main(String[] args) throws IOException {
        AFN afn= new AFN();
        AFD afd= new AFD();
        Scanner scan=new Scanner(System.in);
        int elec=0;
        Thompson th= new Thompson();
        th.convertir("(ba)+a(ca)");
        
        //Aquí se indican los métodos con sus parámetros a ejecutar
        
       /* do{
           System.out.println("Selecciona alguna de las siguientes opciones");
           System.out.println("0.-  salir"); 
           System.out.println("1.- Cargar autómata");
            System.out.println("2.- Guardar autómata");
            System.out.println("3.- Obtener estado inicial");
            System.out.println("4.- Obtener estados finales");
            System.out.println("5.- Establecer estado inicial");
            System.out.println("6.- Establecer estado final");
            System.out.println("7.- Validar si se acepta cadena");
            System.out.println("8.- Generar cadena aleatoria");
            System.out.println("9.- Saber si es AFD");
            System.out.println("10.- Saber si es AFN");
            elec = scan.nextInt();
            switch(elec){
                case 1:
                    System.out.println("Teclea la ruta del archivo .af");
                    String aux= scan.nextLine();
                    afn.cargar_desde(aux);
                    break;
                case 2:
                    System.out.println("Teclea la ruta donde se guardará el archivo .af");
                    String aux2= scan.nextLine();
                    afn.guardar_en(aux2);
                    break;
                case 3:
                    System.out.println("El estado inicial es " + afn.obtener_inicial());
                    break;
                case 4:
                    System.out.println("Los estados finales son:");
                    int[] aux4= afn.obtener_finales();
                    for(int i=0; i<afn.getNumfin(); i++){
                        System.out.println("fin[" + i + "]= " + aux4[i]);
                    }
                    break;
                case 5:
                    System.out.println("Teclea el estado inicial");
                    int aux5=scan.nextInt();
                    afn.establecer_inicial(aux5);
                    break;
                case 6:
                    System.out.println("Teclea el estado final");
                    int aux6=scan.nextInt();
                    afn.establecer_final(aux6);
                    break;
                case 7:
                    System.out.println("Teclea la cadena a validar");
                    String aux7=scan.nextLine();
                    System.out.println(afn.acepta(aux7));
                    
                    break;
                case 8:
                    System.out.println("La cadena random es: " + afn.generar_cadena());
                    break;
                case 9:
                    System.out.println("Opción no disponible");
                    break;
                case 10:
                    System.out.println("Opción no disponible");
                    break;
                case 0:
                    System.out.println("Acabó");
                    break;
                default:
                    System.out.println("No es una opción valida");
                    //break;    
            }
        }while(elec!=0);
        
        */
    }  
}
