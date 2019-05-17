package Controlador;
        
import Vista.Ventana;
import Vista.VentanaEmergente;
import javax.swing.JTextField;
/**
 * CheckerLenguajeRegular
 * 
 * Presentado por:
 * 
 * Jorge Diaz
 * Andres Tovar
 * 
 * Descripcion:
 * 
 * Este programa permite insertar un lenguaje y una expresion regular, despues
 * permite ingresar una cadena y comprueba si esa cadena pertenece al lenguaje
 * regular en cuestion.
 */
public class Ejecutar {
    /**Grito de guerra: Pone el programa a funciona
     * @param argsr*/
    public static void main(String[] args) {
        Ventana ventanaPrincipal = new Ventana();
        ventanaPrincipal.crearVentana();
    }
    
    /**Metodos que permiten pasar datos de la Capa Vista a la capa logica*/
    public String retornarAlfabeto(){
        return Vista.Ventana.alfabeto.getText();
    }
    
    public String retornarExpresionRegular(){
        return Vista.Ventana.expresionRegular.getText();
    }
    
    public String retornarCadena(){
        return Vista.Ventana.cadena.getText();
    }
    
    /**Metodos que permiten pasar informacion de la capa logica a la capa vista
     * mostrarMensaje: envia una ventana emergente que le avisa al usuario sobre
     * diferentes situaciones del programa
     * 
     * @param : String tipoMensaje, String mensaje
    */
    public void mostrarMensaje(String tipoMensaje, String mensaje){
        VentanaEmergente aviso = new VentanaEmergente();
        switch(tipoMensaje){
            case "informacion":
                aviso.mostrarInformacion(mensaje);
            case "error":
                aviso.mostrarAlerta(mensaje);
        }
    }
}
