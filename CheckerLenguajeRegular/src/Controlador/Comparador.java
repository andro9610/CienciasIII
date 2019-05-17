/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaEmergente;

/**
 *
 * @author jorge diaz
 */
public class Comparador {
    /**Metodos que permiten pasar datos de la Capa Vista a la capa logica*/
    public static void ejecutarAlgoritmo(String alfabeto, String expresionRegular, String cadena){
        /**Codigo que llama a la funcionalidad logica del programa aqui*/
        mostrarMensaje("error","Aun no existe la logica de la aplicacion");
    }
    
    /**Metodos que permiten pasar informacion de la capa logica a la capa vista
     * mostrarMensaje: envia una ventana emergente que le avisa al usuario sobre
     * diferentes situaciones del programa
     * 
     * @param : String tipoMensaje, String mensaje
    */
    public static void mostrarMensaje(String tipoMensaje, String mensaje){
        VentanaEmergente aviso = new VentanaEmergente();
        switch(tipoMensaje){
            case "informacion":
                aviso.mostrarInformacion(mensaje);
            case "error":
                aviso.mostrarAlerta(mensaje);
        }
    }
}
