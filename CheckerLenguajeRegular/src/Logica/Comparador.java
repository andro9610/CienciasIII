package Logica;

import Logica.Salida;
import Vista.VentanaEmergente;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comparador {
    /**Metodos que permiten pasar datos de la Capa Vista a la capa logica*/

/**ejecutarAlgoritmo: Metodo dedicado a la comprobacion de cadenas de texto.
     * parametros: String alfabetoIngresado, String expresionRegularIngresada,
     * String cadenaIngresada,boolean Band, boolean exist,int cont, int i, int q,
     * int cont1, Pattern patron, Matcher m, Salida s1.
     * @return void;
     */
    public static void ejecutarAlgoritmo(String alfabetoIngresado, 
            String expresionRegularIngresada, String cadenaIngresada){
       boolean band = true, exist=false;

        int cont = 0;
        int i=1;
        while(i<=cadenaIngresada.length() && band==true){
            String letter = cadenaIngresada.substring(cont, i);
            int q=1;
            int cont1=0;
            band=false;
            while(q<=alfabetoIngresado.length() && band==false){   
                if(letter.equals(alfabetoIngresado.substring(cont1, q))){
                    band=true;
                }else{
                    band=false;
                }
                cont1+=2;
               q+=2;
            }
        i+=1;  
        cont+=1;   
        }
        if(band==false){
            Salida s1;
            s1 = Salida.mostrar("No hace parte del lenguaje");
        }else{
            Salida s1;
            s1 = Salida.mostrar("Hace parte del lenguaje");
            exist=true;

        }
        /**Hace comprobacion de coincidencia entre expresion logica y la frase ingresada*/
        if(exist == true){
            Pattern patron = Pattern.compile(expresionRegularIngresada);
            Matcher m = patron.matcher(cadenaIngresada);
            boolean coincidencia = m.matches();
            Salida s1;
            if(coincidencia==true){
                s1 = Salida.mostrar("La frase hace parte de la expresion regular");    
            }else{
                s1 = Salida.mostrar("La frase no hace parte de la expresion regular");
            } 
       }     

    }
}

