package practica1;
import java.io.*;
/**
 *
 * @author hp
 */
public class AFD extends Automata{
    
    
    char[] Alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
    /* Método  agregar_transicion(int inicial, int fin, char simbolo): agrega una transición de acerdo a los parámetros dados*/
    
    public void agregar_transicion(int inicial, int fin, char simbolo){
        Transicion tr= new Transicion();
        if(verificar_simbolo(simbolo)){
            System.out.println("El símbolo no pertenece al Alfabeto");
        }
        else{
            if(verificar_estado(inicial)){
                Estados[numestados+1]=inicial;
                numestados++;
            }
            if(verificar_estado(fin)){
                Estados[numestados+1]=fin;
                numestados++;
            }
            tr.inicio=inicial;
            tr.fin=fin;
            tr.simbolo=simbolo;
            Transiciones[numtransiciones]=tr;
            numtransiciones++;
            System.out.println("Se agregó la transición");
        }
      
    }
    
    /*  eliminar_transicion(int inicial, int fin, char simbolo): Método que 
    elimina una transición y recorre el arreglo de transiciones del autómata. Los resultados de esta acción son diversos. */
    
    public void eliminar_transicion(int inicial, int fin, char simbolo){
        Transicion aux= new Transicion();
        boolean encontro_trans =false;
        for(int j=0; j<numtransiciones; j++){
            if(Transiciones[j].inicio==inicial && Transiciones[j].fin==fin && Transiciones[j].simbolo==simbolo){
                encontro_trans=true;
                for(int k=j+1; k<numtransiciones; k++){
                    Transiciones[k-1]= Transiciones[k];
                }
                Transiciones[numtransiciones]=null;
                numtransiciones--;
            }
        }
        
        if(!encontro_trans){
            System.out.println("No se encontró la transición");
        }
    }
    public boolean esAFN(){
        boolean es=false;
        
        return es;
    }
    
    public boolean esAFD(){
        boolean es=false;
        
        return es;
    }
    
    /* verificar_simbolo(char simbolo): Método auxiliar que indica si el símbolo indicado
    se encuentra o no en el alfabeto*/
    
    boolean verificar_simbolo(char simbolo){
        int i=0;
        boolean noesta = true; 
        while(i<Alfabeto.length && noesta){
            if(simbolo==Alfabeto[i]){
                noesta=false;
            }
            else{
                i++;
            }
        }    
        return noesta;
    }
    
}
