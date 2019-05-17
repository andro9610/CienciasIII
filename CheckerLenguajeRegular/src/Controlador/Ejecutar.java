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
}
