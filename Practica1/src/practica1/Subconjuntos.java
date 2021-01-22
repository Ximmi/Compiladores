package practica1;

/*
Clase Subconjuntos: Clase que hereda de la clase AFN y cuyos métodos en conjunto tienen el objetivo de pasar
el AFN a otro objeto AFD (de la clase AFD) por medio del algoritmo de los subconjuntos
*/

public class Subconjuntos extends AFN{
    //int[] Destados;
    int contnuevosEst=0;
    Transicion Transiciones[]=getTransiciones();
    int contTrans=0;
    DEstados Destados[]= new DEstados[100];
    int contDE=0;
    char[] simbolos= getSimbolos();
    AFD afd=new AFD();
    
    /*
        void pasar_AFN_a_AFD():
    Método que llama a los métodos que realizarán las operaciones para pasar el AFN a AFD y 
    realiza e-cerradura para el subconjunto que contiene el estado inicial.
    */
    
    public void pasar_AFN_a_AFD(){
        int[] inicial={getInicio()};
        int[] T;
        T= e_cerradura(inicial);
        Destados[contDE].estadosAnteriores=T;
        Destados[contDE].id=contDE;
        agregar_ini();
        construir_subconjuntos();
        agregar_aceptacion();
    }
    
    /*
        int[] e_cerradura(int[] estado):
    Método que recibe un conjunto de estados y devuelve otro conjunto de estados. Los estados
    que se retornan son el resultado de analizar todas las trasciciones de los estados "enviados"
    cuyo símbolo es Épsilon (E). Los estados finales de este análisis son los que se retornan.
    */
    
    public int[] e_cerradura(int[] estado){
        int[] subconjunto=estado;
        int i=0, j, ultimapos=0;
        //recorre todo el subconjunto
        while(i<subconjunto.length){
            //recorre por transiciones
            for(j=0; j<getNumtransiciones(); j++){
                if(Transiciones[j].inicio==subconjunto[i]){
                    if(Transiciones[j].simbolo=='E'){
                        subconjunto[subconjunto.length]=Transiciones[j].fin;
                        ultimapos=j+1;
                    }
                }
            }
            i++;          
        }
        return subconjunto;
    }
    /*
        construir_subconjuntos():
    Método que construye los subconjuntos a partir de los estados generados para el AFD. Se obtienen 
    principalmente de la asignación U=e_cerradura(mover(T,simbolos[i])). Además, se van agregando
    las transiciones al AFD.
    */
    public void construir_subconjuntos(){
        int contadorestados=0;
        int[] U;
        int T[];
        //Se analizan todos los nuevos estados
        while(contadorestados<Destados.length){
            /*T será el subconjunto de estados del AFN que están almacenados como Estados anteriores de
            un objeto DEstados*/
            T=Destados[contadorestados].estadosAnteriores;
            //Se analizan todos los símbolos con los cuales el subconjunto T puede trasladarse
            for(int i=0; i<simbolos.length; i++){
                U=e_cerradura(mover(T,simbolos[i]));
                //Si no se encuentra ese conjunto de estados U entonces se agrega un nuevo DEstado
                if(no_esta(U)){
                    Destados[contDE].id=contDE;
                    Destados[contDE].estadosAnteriores=U;
                    contDE++;
                }
                //Se asignan las nuevas transiciones
                afd.agregar_transicion(Destados[contadorestados].id, buscar_Destado_U(U), simbolos[i]);                
            }
            contadorestados++;
        }     
    }
    
    /*
        int[] mover(int T[], char a):
    Método que recibe un conjunto de estados y un símbolo del alfabeto y devuelve otro conjunto de estados.
    Los estados que se retornan son el resultado de analizar todas las trasciciones de los estados "enviados"
    cuyo símbolo es el enviado. Los estados finales de este análisis son los que se retornan.
    */
    
    public int[] mover(int T[], char a){
        int[] subconjunto={};
        int contsub=0;
        for(int i=0; i<T.length; i++){
                for(int j=0; j<Transiciones.length; j++){
                    if(Transiciones[j].simbolo==a &Transiciones[j].inicio==T[i]){
                        subconjunto[contsub]=Transiciones[j].fin;
                    }
                }
            
        }
        return subconjunto;
    }
    
    /*
        boolean no_esta(int[] U):
    Método que analiza si el subconjunto enviado como parámetro ya forma parte del conjunto de
    estados del afd, si no es así retorna que "no está" para que pueda ser agregado.
    */
    
    public boolean no_esta(int[] U){
        boolean ne=true;
        int i=0;
        while(i<Destados.length & ne){
            if(Destados[i].estadosAnteriores==U){
                //si está
                ne=false;
            }
            i++;
        }
        return ne;
    }
    
    /*
        buscar_Destado_U(int[] U):
    Métdodo que recibe un conjunto de estados del AFN y retorna el estado que le identifica en el afd.
    */
    
    public int buscar_Destado_U(int[] U){
        int estado=0;
        for(int i=0; i<Destados.length; i++){
            if(Destados[i].estadosAnteriores==U){
                estado=Destados[i].id;
            }
        }
        return estado;
    }
    
    /*
        void agregar_aceptacion():
    Método que agrega el estado de aceptación del afd a partir de los estados de aceptación del AFN.
    */
    
    public void agregar_aceptacion(){
        for(int i=0; i<Destados.length; i++){
            for(int j=0; j<getFin().length; j++){
                for(int k=0; k<Destados[i].estadosAnteriores.length; k++){
                    if(Destados[i].estadosAnteriores[k]==getFin()[j]){
                        Destados[i].nofinal=false;
                        afd.establecer_final(Destados[i].estadosAnteriores[k]);
                    }
                }
            }
        }
    }
    
    /*
        void agregar_ini():
    Método que agrega los estados iniciales del afd a partir del estado inicial del AFN.
    */
    
    public void agregar_ini(){
        for(int i=0; i<Destados.length; i++){
                for(int k=0; k<Destados[i].estadosAnteriores.length; k++){
                    if(Destados[i].estadosAnteriores[k]==getInicio()){
                        afd.establecer_inicial(Destados[i].estadosAnteriores[k]);
                    }
                }
        }
    }
}
