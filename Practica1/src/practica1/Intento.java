/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author hp
 */
public class Intento {
    //int[] estados= new int[10];
      int[] estados= {1, 2, 3, 4, 5, 6, 7};
      int inicio=0;
      int fin=7;        
      Transicion[] t= new Transicion[8];
      int numtransiciones=0;
      
      
      
    public void agregar_transicion(int inicio, int fin, char simbolo){
        Transicion tr= new Transicion();
        
            tr.inicio=inicio;
            tr.fin=fin;
            tr.simbolo=simbolo;
            t[numtransiciones]=tr;
            numtransiciones++;
            System.out.println("Se agregó la transición");   
    }
    
    public void verifcar_cadena(String cadena){
          int ninicio= inicio;
          int x=0;
          char c;
          boolean sinerror= true;
          while(x<cadena.length() &&sinerror){
              //analiza un caracter de la cadena
              c=cadena.charAt(x);
              for(int y=0; y<numtransiciones; y++){
              //For para las transiciones
                if(t[y].inicio==ninicio){
                    if(c==t[y].simbolo){
                        System.out.println(c+ "Aceptado por E1=" + t[y].inicio + " ->E2=" + t[y].fin);
                        ninicio=t[y].fin;
                    }
                    else{
                        System.out.println("El simbolo no corresponde a E1= " + t[y].inicio + " ->E2=" + t[y].fin);
                        sinerror= false;
                    }
                }
              }
          }
    }
}

