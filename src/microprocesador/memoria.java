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
 * Esta clase implementa el funcionamiento básico de una celda de memoria. 
 */
public class memoria {
    /** direccionMaxima, es el máximo de registros en la memoria. */
    int direccionMaxima=20;
    /** vector, es el vector donde se almacenan los datos. */
    String[] vector=new String[direccionMaxima];
    
    
    /**
     * Este es el método constructor de la clase donde se inicia todas las celdas
     * de memoria en ceros. 
     */
    public  memoria(){
        int i;
        
        for (i=0; i<this.direccionMaxima; i++){
            this.vector[i]="000000000000";
        }
    }
     
    /**
     * se ejecuta en este método de la clase el enlazamiento del código a 
     * ejecutarse. En este método se almacenan los datos y las instrucciones
     * a ejecutarse en el microprocesador. 
     */
    public void enlaceCodigo(){
        // e=a+b+c+d
        this.escritura(0,  "000000000101");  // a=5
        this.escritura(1,  "000000000011");  // b=3
        this.escritura(2,  "000000000111");  // c=7
        this.escritura(3,  "000000001001");  // d=9
        this.escritura(4,  "000000000000");  // e
        this.escritura(5,  "000000000000");
        this.escritura(6,  "000000000000");
        this.escritura(7,  "000000000000");
        this.escritura(8,  "000000000000");
        this.escritura(9,  "000000000000");
        this.escritura(10, "000100000001");  // a+b
        this.escritura(11, "000100010010");  // (a+b)+c
        this.escritura(12, "000100100011");  // (a+b+c)+d
        this.escritura(13, "001100110100");  
        this.escritura(14, "111100000000");  
        this.escritura(15, "000000000000");
    }
    
    /**
     * Este método ejecuta una operación de lectura sobre la memoria.
     * @param direccion, es la dirección de memoria que se quiere recuperar. 
     * @return regresa el valor almancenado en la dirección solicitada. 
     */
    public String lectura(int direccion){
        return this.vector[direccion];
    }
    
    /**
     * Este método ejecuta la operación escritura sobre la memoria de la computadora. 
     * @param direccion, es la dirección donde se va almacenar el dato
     * @param valor, es el valor del dato que se quiere almacenar. 
     */
    public void escritura(int direccion, String valor){
        this.vector[direccion]=valor;
    }
    
    /**
     * Este método es solo para escribir en la línea de comando los valores internos de la memoria. 
     */
    public void muestraMemoria(){
        int i;
        String salida;
        for (i=0; i<this.direccionMaxima; i++){
            salida="["+i+"]="+this.vector[i];
            System.out.println(salida);
        }
    }
    
}
