/**
 * Código generado para el curso de 
 * "Introducción  a los microprocesadores"
 * Laboratorio de Cómputo de Alto Rendimiento 
 * Universidad Veracruzana
 * @version 22 de octubre de 2017
 * @author Dr. Alfredo Cristóbal Salas.
 */
package microprocesador;

/**
 * Esta clase implementa el diseño de un microprocesador simple genérico
 * que corresponde a un diseño teórico del comportamiento de un microprocesador
 * el cual está preparado para realizar operaciones simple. 
 * 
 */
public class Microprocesador {
    /**MEMORIA, es la clase que implementa una memoria fuera del microprocesador. */
     static memoria MEMORIA;  
     /** UC, es la clase que implementa la funcionalidad de una Unidad de Control. */
     static unidadControl  UC;
     /** ALU, es la clase que implementa una unidad aritmética-lógica. */
     static unidadAritmeticaLogica  ALU;
     
     /** numeroOperaciones, es el atributo que cuenta el número de operaciones realizadas. */
     int numeroOperaciones;
     /** numeroNucleos, es el atributo que cuenta el número de núcleos en el microprocesador. */
     int numeroNucleos;
     /** usoHilos, este atributo decide que la implementación usa hilos o no. */
     int usoHilos;
     
     /**
      * Este es el método constructor de la clase que inicia los atributos de
      * la misma para llevar una estadística de las operaciones realizadas. 
      */
     public Microprocesador(){
         numeroOperaciones=0;
         numeroNucleos=0;
         usoHilos=0;
     }
     
     
    /**
     * Este método controla un ciclo de reloj en el microprocesador ejecutando
     * las instrucciones Instruction fetch, decode, data fetch, execute y store
     * sin aplicar técnicas de alto rendimiento. 
     * @return salida, es la variable que detecta el fin de programa.
     */
    public static int cicloDeComputo(){
        /** salida, es una variable que declara si el microprocesador debe terminar o no. */
        int salida;
        
            UC.instructionFetch();
            UC.decode();
            UC.dataFetch();
            salida=UC.execute();
            UC.store();
            return salida;
    }
    
    /**
     * Este método es para uso de depuración del programa. 
     * @return salida, es para saber cuando el microprocesador debe detenerse. 
     */
    public static int cicloDeComputoDEBUG(){
        /** salida, es una variable que declara si el microprocesador debe terminar o no. */
        int salida;
        
            System.out.println("INICIA---------------------");
            System.out.println("---------------------");
            System.out.println("INSTRUCTION FETCH");
            System.out.println("---------------------");
            UC.instructionFetch();
            UC.muestraUC();
            ALU.muestraALU();
        
            System.out.println("---------------------");
            System.out.println("DECODE");
            System.out.println("---------------------");
            UC.decode();
            UC.muestraUC();
            ALU.muestraALU();
        
            System.out.println("---------------------");
            System.out.println("DATA FETCH");
            System.out.println("---------------------");
            UC.dataFetch();
            UC.muestraUC();
            ALU.muestraALU();
        
            System.out.println("---------------------");
            System.out.println("EXECUTE");
            System.out.println("---------------------");
            salida=UC.execute();
            UC.muestraUC();
            ALU.muestraALU();
            MEMORIA.muestraMemoria();
            
            System.out.println("---------------------");
            System.out.println("STORE");
            System.out.println("---------------------");
            UC.store();
            UC.muestraUC();
            ALU.muestraALU();
            MEMORIA.muestraMemoria();
            System.out.println("FINALIZA---------------------");
            return salida;
    }
    
    
    
    
    /**
     * Esta es la función principal del código donde se controla el llamado 
     * a las demás funciones del microprocesador. 
     * @param args, el parámetro tomado desde la línea de comandos. 
     */
    
    public static void main(String[] args) {
        MEMORIA=new memoria();
        UC= new unidadControl();
        ALU= new unidadAritmeticaLogica();
        int i;
        int salida;
   
        UC.contadorPrograma=10;
        
        //MEMORIA.iniciaMemoria();
        MEMORIA.enlaceCodigo();
        
        do{
            salida=microprocesador.Microprocesador.cicloDeComputo();
        }while(salida==0);
    }   
}
