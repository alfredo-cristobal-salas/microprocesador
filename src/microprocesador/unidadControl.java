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
 * Esta clase es para definir las acciones que realiza una unidad de control
 * de un microprocesador simple sin modificaciones de alto rendimiento. 
 */
public class unidadControl {
    /** simula el registro de instrucción del microprocesador. */
     String registroInstruccion=new String();
     /** es el registro que sabe la instrucción que se está ejecutando. */
     int contadorPrograma;
     /** esta variable es parte del decodificador y almacena la instrucción a ejecutarse. */
     String decodificarInstruccion=new String();
     /** esta variable es parte del decodificador y almacena la dirección del primer dato de la instruccion. */
     String decodificarDato1=new String();
     /** esta variable es parte del decodificador y almacena la dirección del segundo dato de la instruccion. */
     String decodificarDato2=new String();
     /** es la variable que contiene la dirección de donde se debe almacenar el resultado. */
     String decodificarResultado=new String();
    
     /**
      * Esta es el método constructor que se encarga de iniciar los atributos
      * de la clase. 
      */
    public  unidadControl(){
        registroInstruccion="";
        contadorPrograma=0;
        decodificarInstruccion="";
        decodificarDato1="";
        decodificarDato2="";
        decodificarResultado="";
    }
    
    /**
     * Este método muestra el contenido de los atributos de la clase y las 
     * imprime en la línea de comandos. 
     */
    public void muestraUC(){
        System.out.println("Registro de Instruccion="+this.registroInstruccion);
        System.out.println("contadorPrograma="+this.contadorPrograma);
        System.out.println("decodificarInstruccion="+this.decodificarInstruccion);
        System.out.println("decodificarDato1="+this.decodificarDato1);
        System.out.println("decodificarDato2="+this.decodificarDato2);
        System.out.println("decodificarResultado="+this.decodificarResultado);
    }
    
    /**
     * Este método recupera la instrucción siguiente apuntada por el "contador
     * de programa" y lo pasa al registro de instrucción como lo indica la 
     * teoría del concepto de microprocesador. 
     */
     public void instructionFetch(){         
         microprocesador.Microprocesador.UC.registroInstruccion=microprocesador.Microprocesador.MEMORIA.lectura(this.contadorPrograma);
    }
     
     /**
      * Este método recupera de memoria los datos necesarios para completar
      * la instrucción en funciones y los valores son pasados a la ALU para que
      * sean procesados. 
      */
     public void dataFetch(){
         int tmp;
         
         tmp= Integer.parseInt(this.decodificarDato1,2);
         microprocesador.Microprocesador.ALU.registroEntrada1=microprocesador.Microprocesador.MEMORIA.lectura(tmp);
         microprocesador.Microprocesador.ALU.banderas[1]=1;
         tmp= Integer.parseInt(this.decodificarDato2,2);
         microprocesador.Microprocesador.ALU.registroEntrada2=microprocesador.Microprocesador.MEMORIA.lectura(tmp);
         microprocesador.Microprocesador.ALU.banderas[2]=1;
     }
    
     /**
      * Este método sirve para realizar las acciones del decodificador de instrucciones de la memoria. 
      */
    public void decode(){
        this.decodificarInstruccion=this.registroInstruccion.substring(0, 4);
        this.decodificarDato1=this.registroInstruccion.substring(4,8);
        this.decodificarDato2=this.registroInstruccion.substring(8,12);
        this.decodificarResultado=this.decodificarDato2;
        microprocesador.Microprocesador.ALU.operacion=Integer.parseInt(this.decodificarInstruccion,2);
        microprocesador.Microprocesador.ALU.banderas[0]=1;
    }
    
    /**
     * Este método implementa la ejecución de la instrucción de una instrucción en el microprocesador. 
     * @return salida, es una variable que sirve para detectar cuando el microprocesador debe terminar.
     */
    public int execute(){
        int salida;
        salida=microprocesador.Microprocesador.ALU.ejecutarInstruccion();
        return salida;
    }
    
    /**
     * Este método almacena el resultado de la ejecución de una instrucción en la memoria donde diga el Registro decodificador.
     */
    public void store(){
        int tmp;
        int direccion;
        String dato;
        
        tmp=microprocesador.Microprocesador.ALU.acumulador;
        dato=Integer.toBinaryString(tmp);
        direccion=Integer.parseInt(microprocesador.Microprocesador.UC.decodificarResultado,2);
        microprocesador.Microprocesador.MEMORIA.escritura(direccion, dato);
        microprocesador.Microprocesador.UC.contadorPrograma++;
    }
    
}
