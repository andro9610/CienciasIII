package Logica;

import Logica.Salida;
import Vista.VentanaEmergente;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comparador {
    /**Metodos que permiten pasar datos de la Capa Vista a la capa logica*/
    public static void ejecutarAlgoritmo(String alfabetoIngresado, String expresionRegularIngresada, String cadenaIngresada){
        String expresionRegular = expresionRegularIngresada;
        String cadena = cadenaIngresada;
        String alfabeto = alfabetoIngresado;
        boolean band = true, exist=false;
        int cont = 0;
        int i=1;
        while(i<=cadena.length() && band==true){
            String letter = cadena.substring(cont, i);
            int q=1;
            int cont1=0;
            band=false;
            while(q<=alfabeto.length() && band==false){   
                if(letter.equals(alfabeto.substring(cont1, q))){
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
            Pattern patron = Pattern.compile(expresionRegular);
            Matcher m = patron.matcher(cadena);
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

