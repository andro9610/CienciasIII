/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaEmergente;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author jorge diaz
 */
public class Comparador {
    /**Metodos que permiten pasar datos de la Capa Vista a la capa logica*/
    public static void ejecutarAlgoritmo(String alfabeto, String expresionRegular, String cadena){
        /**Codigo que llama a la funcionalidad logica del programa aqui*/
        
       // mostrarMensaje("error","Aun no existe la logica de la aplicacion");
       String regex = expresionRegular;
       String F = cadena;
       String L = alfabeto;
       boolean band = true, exist=false;
        int cont = 0;
       int i=1;
       while(i<=F.length() && band==true){
           String letter = F.substring(cont, i);
           int q=1;
           int cont1=0;
           band=false;
           while(q<=L.length() && band==false){   
               if(letter.equals(L.substring(cont1, q))){
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
           
               Pattern patron = Pattern.compile(regex);
               Matcher m = patron.matcher(F);
               
               boolean coincidencia = m.matches();
               
               Salida s1;
		if(coincidencia==true){
                    s1 = Salida.mostrar("La frase hace parte de la expresion regular");    
                }else{
                    s1 = Salida.mostrar("La frase no hace parte de la expresion regular");
                }
               
           
       }
       
    }
    
    
    /**Metodos que permiten pasar informacion de la capa logica a la capa vista
     * mostrarMensaje: envia una ventana emergente que le avisa al usuario sobre
     * diferentes situaciones del programa
     * 
     * @param : String tipoMensaje, String mensaje
    */
    
}

