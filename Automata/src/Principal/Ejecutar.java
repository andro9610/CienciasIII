/**Automatas:
 * Descripcion: Este programa permite añadir de forma grafica un automata y una
 * cadena de caracteres para comprobar si dicha cadena es admitida dentro del
 * conjunto de estados aceptados del automata.
 * 
 * Condiciones:
 * 
 * - La entrada del automata a evaluar sera de forma grafica
 * 
 * Elaborado por:
 * Jorge Luis Diaz Barragan - 20162020405
 * Andres Felipe Tovar Ochoa - 20142020071
 * 
 * Fecha de presentacion:
 * Miercoles, 5 de Junio de 2019
 */

package Principal;

import Vista.VentanaGrafos;
/**Clase Ejecutar: Lanzadora de aplicacion*/
public class Ejecutar {
    /**Metodo main: Funcion de lanzamiento de la aplicacion*/
    public static void main(String [] args) {
        VentanaGrafos ventana = new VentanaGrafos();
        ventana.crearVentanaGrafos();
    }
    
}
