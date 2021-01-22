package practica1;
import java.io.*;
/*
 *
 * @author Ximbo
 */

/* Clase Autómata: es la clase padre en las que se definen los métodos de un autómata */
public class Automata {
    
        Transicion Transiciones[]= new Transicion[100];
        int Estados[]= new int[100];
        int inicio=1;

    public Transicion[] getTransiciones() {
        return Transiciones;
    }

    public int[] getEstados() {
        return Estados;
    }

    public int getInicio() {
        return inicio;
    }

    public int getNumtransiciones() {
        return numtransiciones;
    }

    public int[] getFin() {
        return fin;
    }
        int numestados=0;
        int numtransiciones=0;
        int numfin=0;

    public int getNumestados() {
        return numestados;
    }

    public int getNumfin() {
        return numfin;
    }
        char c;
        int[] fin= new int[100];
        
       
    
    /*cargar_desde(String nombre):Método que recibe la dirección absoluta desde donde se encuentra el autómata, 
     hasta el momento carga el archivo, sin embargo no lo pasa al autómata
        */
    public void cargar_desde(String nombre) throws FileNotFoundException, IOException{
        String cadena;
        int contlineas=0;
        int h=0, j=0, g=0, i=0;
        String aux= "", aux1="", aux2="";
        boolean noencuentra= true;
        FileReader file = new FileReader(nombre);
        BufferedReader buf = new BufferedReader(file);
        while((cadena = buf.readLine())!=null) {
            //System.out.println(cadena);
            
            while(noencuentra && i<cadena.length()){
                //System.out.println("cadena: " + cadena);
                //System.out.println("Length: " + cadena.length());
                System.out.println("cadena.char at: " + cadena.charAt(i));
                if(cadena.charAt(i)==':' && contlineas==0){
                    //para inicio
                    h=i;
                    while(cadena.charAt(h)!='\n'){
                        aux= aux+ cadena.charAt(h);
                        h++;
                    }
                    inicio= Integer.parseInt(aux);
                    System.out.println("inicio: " + inicio);
                    contlineas++;
                    noencuentra=false;
                }
                if(cadena.charAt(i)==':'){
                    //para fin
                    h=i;
                    while(cadena.charAt(h)!='\n'){
                        aux= aux+ cadena.charAt(h);
                        h++;
                    }
                    fin[numfin]= Integer.parseInt(aux);
                    System.out.println("fin[n]=" +fin[numfin]);
                    numfin++;
                    noencuentra=false;
                }
                if(cadena.charAt(0)!='f' && cadena.charAt(0)!='i'){
                    j=i;
                    while(cadena.charAt(j)!='-'){
                        aux1= aux1 +cadena.charAt(j);
                        j++;
                    }
                    System.out.println("Transiciones ini= " + aux1);
                    Transiciones[numtransiciones].inicio=Integer.parseInt(aux1);
                    if(cadena.charAt(i)=='>'){
                        h=j+2;
                        System.out.println("j+2 = h= " + h);
                    }
                    while(cadena.charAt(h)!=','){
                        aux2= aux2+ cadena.charAt(h);
                        h++;
                    }
                    System.out.println("Transiciones fin= " + aux2);
                    Transiciones[numtransiciones].fin=Integer.parseInt(aux2);
                    if(cadena.charAt(i)==','){
                        g=i+1;
                        System.out.println("g=i= " + g);
                    }
                    while(cadena.charAt(g)!='\n'){
                        c=cadena.charAt(g);
                    }
                    Transiciones[numtransiciones].simbolo=c; 
                }
                //incremento
                i++;
            }
            for(i=0;i<cadena.length(); i++){
                if(cadena.charAt(i)==':' && contlineas==0){
                    h=i;
                    while(cadena.charAt(h)!='\n'){
                        aux= aux+ cadena.charAt(h);
                        h++;
                    }
                    inicio= Integer.parseInt(aux);
                }
                if(cadena.charAt(i)==':'){
                    h=i;
                    while(cadena.charAt(h)!='\n'){
                        aux= aux+ cadena.charAt(h);
                        h++;
                    }
                    fin[numfin]= Integer.parseInt(aux);
                    numfin++;
                }
                if(cadena.charAt(0)!='f' && cadena.charAt(0)!='i'){
                    j=i;
                    while(cadena.charAt(j)!='-'){
                        aux1= aux1 +cadena.charAt(j);
                        j++;
                    }
                    Transiciones[numtransiciones].inicio=Integer.parseInt(aux1);
                    if(cadena.charAt(i)=='>'){
                        h=j+1;
                        System.out.println("j+1 = h= " + h);
                    }
                    while(cadena.charAt(h)!=','){
                        aux2= aux2+ cadena.charAt(h);
                        h++;
                    }
                    Transiciones[numtransiciones].fin=Integer.parseInt(aux2);
                    if(cadena.charAt(i)==','){
                        g=i+1;
                        System.out.println("g=i= " + g);
                    }
                    while(cadena.charAt(g)!='\n'){
                        c=cadena.charAt(g);
                    }
                    Transiciones[numtransiciones].simbolo=c;
                    
                    
                }
            }//for
        }
        
        file.close();
    }
    /*guardar_en(String nombre): Método que guarda el autómata en la dirección específica dada en el parámetro de entrada,
    se debe incluir el nombre del archivo en formato .af
    */
    public void guardar_en(String nombre){
        try {
            
            String contenido = crear_contenido();
            File file = new File(nombre);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /*obtener_inicial(): Método que devuelve el estado inicial del autómata,
    en caso de no haberlo declarado, da como default que el estado inicial es 1.
    */
    
    public int obtener_inicial(){
        int aux=1;
        if(inicio==1){
            System.out.println("No existe el inicio aún, es 1 por default");
        }
        else{
            aux=inicio;
        }
        return aux;
    }
    
    /*obtener_finales(): Método que devuelve los estados finales del autómata,
    en caso de no haberlos declarado, manda un mensaje a través de la consola.
    */
    
    public int[] obtener_finales(){
        if(fin==null){
            System.out.println("No hay estados finales po el momento");
        }
        return fin;
    }
    
    /*establecer_inicial(int estado): Metodo que permite establecer el estado inicial del autómata */
    
    public void establecer_inicial(int estado){
        if(estado!=inicio){
            inicio= estado;
        }
        else{
            System.out.println("Ya existe un inicio");
        }
    }
    
    /*establecer_final(int estado): Metodo que permite establecer los estados finales del autómata */
    
    public void establecer_final(int estado){
        boolean noesta = true;
        int i=0;
        while(i<numfin && noesta){
            if(estado==fin[i]){
                noesta=false;
            }
            else
                i++;
        }
        if(noesta){
            fin[numfin]=estado;
            numfin++;
        }
        
    }
    /*acepta(String cadena): Método que sigue la trayectoria de las transiciones del autómata y que
    si al llegar al estado final los símbolos coinciden con los del recorrido, acepta la cadena dada y devuelve
    un valor booleano de true o false. Tiene fallas.*/
    public boolean acepta(String cadena){
          int ninicio= inicio;
          int x=0, aux=0, w=0;
          char c;
          boolean sinerror= true;
          boolean noesfin=true;
          System.out.println("cadena. length= " +cadena.length()+ " num trans= " + numtransiciones);
          while(x<cadena.length() &&sinerror){
              //analiza un caracter de la cadena
              c=cadena.charAt(x);
              
              for(int y=0; y<numtransiciones; y++){
              //For para las transiciones
                if(Transiciones[y].inicio==ninicio){
                    if(c==Transiciones[y].simbolo){
                        System.out.println(c+ " Aceptado por " + Transiciones[y].inicio + " ->" + Transiciones[y].fin);
                     
                        if(x!=cadena.length()-1){
                           ninicio=Transiciones[y].fin;
                            x++;
                            c=cadena.charAt(x);
                            System.out.println("x= " + x);
                        }
                        else{
                            System.out.println("Terminó");
                            aux=y;
                            sinerror= false;                        
                        }
                    }
                    else{
                        System.out.println("El simbolo " + c+" no corresponde a " + Transiciones[y].inicio + " ->" + Transiciones[y].fin);
                        //------------CAMBIÉ ESTO--------------------------
                        /*x++;
                        c=cadena.charAt(x);*/
                        if(x!=cadena.length()-1){
                           sinerror= false;
                           System.out.println("x= " + x);
                            System.out.println("No he terminado");
                        }
                        else{
                            System.out.println("Terminó");
                            aux=y;
                            System.out.println("aux= "+ aux);
                        }
                    }
                } //if
              } //for
          } //while
          //saber si aux se encuentra en el arreglo de estados finales
          while(w<fin.length && noesfin){
            if(fin[w]==aux)
                noesfin=false;   
            else
            w++;
          }
          return !noesfin;
    }
    
    /* generar_cadena(): Método que sigue la trayectoria del autómata para dar una cadena aceptada por el mismo.
    */
    
    public String generar_cadena(){
        int ninicio= inicio;
          int  aux=0, w=0;
          String cadena="";
          boolean noesfin=true;
          int numchar = (int) (Math.random()*8);
          
          System.out.println("numchar= " + numchar);
              //analiza un caracter de la cadena
              for(int y=0; y<numchar; y++){
              //For para las transiciones
                //if(Transiciones[y].inicio==ninicio){
                    System.out.println("Transiciones en y es ninicio");
                    cadena=cadena+ Transiciones[y].simbolo;  
                    System.out.println("c=" + cadena);
                    ninicio=Transiciones[y].fin;  
                
                if(y==numchar-1){
                    aux=y;
                }
              }
        System.out.println("y=" +aux);      
        while(w<fin.length && noesfin){
            if(fin[w]==aux)
                noesfin=false;   
            else
            w++;
          }
        if(!noesfin){
            System.out.println("generaria otra cadena");
            return generar_cadena();
        }
        else{
            System.out.println("...");
            return cadena;
        }
        
    }
    /*crear_contenido(): Método auxiliar que es usado por el método guardar_en() para que sea formada la sintaxis del archivo .af
    */
    
    public String crear_contenido(){
        String contenido;
        String trans="";
        String ini= "inicial:"+String.valueOf(inicio) + "\n";
        String fins= "finales:";
        for(int y=0; y<numfin; y++){
            if(y==numfin-1){
                fins= fins + String.valueOf(fin[y]) + "\n";
            }
            else{
                fins= fins + String.valueOf(fin[y]) + ", ";
            }
        }
        
        for(int w=0; w<numtransiciones; w++){
            trans= trans + (String.valueOf(Transiciones[w].inicio)+ "->" + String.valueOf(Transiciones[w].fin) + ", " + String.valueOf(Transiciones[w].simbolo) + "\n");
        
        }
        contenido=ini+fins+trans;
        return contenido;
    }
    
    /* verificar_estado(int estado): Método auxiliar que verifica si un estado existe ya o no*/
    public boolean verificar_estado(int estado){
        boolean noexiste= true;
        int x=0;
        while(x<numestados && noexiste){
            if(estado==Estados[x]){
                noexiste=false;
            }
            else{
                x++;
            }
        }
        return noexiste;
    }
    
    
}
