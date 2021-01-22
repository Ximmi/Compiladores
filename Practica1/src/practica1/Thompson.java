package practica1;

import java.util.Stack;

public class Thompson {
    Stack pila= new Stack();
    String subexpresion="";
    int counter=0;
    char[] abecedario={'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] cerraduras={'+', '*'};
    AFN afn= new AFN();
    public void convertir(String expresion_regular){
        validar_parentesis(expresion_regular);
    }
    public void validar_parentesis(String expresion){
        
        if(expresion.length()!=1){
            for(int i=0; i<expresion.length(); i++){
               if(expresion.charAt(i)=='('){
                   pila.push(new Character(')'));
                   if(subexpresion!=""){
                   System.out.println("subexpresion en ) = " + subexpresion);
                   }
                   subexpresion="";
               }
                else if (expresion.charAt(i) == ')'){
                    subexpresion=verifica(')');
                    //System.out.println("subexpresion en ( = " + subexpresion);
                   //subexpresion="";
                }
                else if(pertenece_lenguaje(expresion.charAt(i), 1)){
                    subexpresion= subexpresion+expresion.charAt(i);
                    
                    
                }
                else if(pertenece_lenguaje(expresion.charAt(i), 2)){
                    System.out.println("subexpresion cuando encuentra + o * = " + subexpresion);
                    crear_cerradura(subexpresion);
                    subexpresion="";
                }
            }
        }
        if(pila.empty()){
            System.out.println("Parentesis balanceados");
        }
        else{
            System.out.println("Paréntesis NO balanceados");
        }
        
    }
    
    private String verifica(char c){
        String retorno;
        if(pila.empty()){
            //System.out.println("Paréntesis NO balanceados de verifica");
            retorno="";
        }
        else{
            Character s=(Character)pila.pop();
            if(c!= s.charValue()){
                //System.out.println("Paréntesis NO balanceados si c es distinto de s");
                retorno="";
            }
            else{
                System.out.println("Subexpresion = "  + subexpresion);
                retorno=subexpresion;
                //subexpresion="";
                
            }
        }
        return retorno;
    }
    
    private boolean pertenece_lenguaje(char c, int opc){
        
        int i=0;
        boolean bandera=false;
        char aux[]={};
        
        if(opc==1){
            aux= abecedario;
        }
        else if(opc==2){
            aux= cerraduras;
        }
        while( i<aux.length && bandera==false){
            if(c==aux[i]){
                bandera=true;
            }
            else{
                i++;
            }
        }
        return bandera;
    }
    
    public void crear_cerradura(String subexpresion){
        System.out.println("Es cerradura");
        System.out.println("sub= " + subexpresion);
    }
    public void concatenar(char c){
        if(counter==0){
            System.out.println("Numestados= " + afn.getNumestados());
        }
    }
}
