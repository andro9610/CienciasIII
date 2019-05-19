package Logica;

import javax.swing.JOptionPane;

public class Salida {
    private static Salida salida;
    private String string;
    
    /**Salida: Constructor de objetos Salida.
     * parametros: String string
     * @return Mensaje en JOptionPane.;
     */
	private Salida(String string) {
		this.string = string;
		JOptionPane.showMessageDialog(null,this.string);           
	}
        
    /** * Mostrar: Metodo cuya funcionalidad es mostrar todas las salidas de 
    * mensajes en el programa.parametros: String string
     * @param string
     * @return Salida salida;
     */
	public static Salida mostrar(String string) {
		if (salida == null) {
			salida = new Salida(string);
                        salida = null;
		}else {
			System.out.println("El objeto ya esta creado");
		}
		return salida;
	}
    
    /**getSalida: Metodo cuya funcionalidad es obtener el estado de objetos 
     * Salida.
     * @return Salida salida;
     */
	public static Salida getSalida() {
		return salida;
	}
    /** * setSalida: Metodo cuya funcionalidad es modificar el estado dl obejto
         * Salida.parametros: String string
     * @param salida
     */
	public static void setSalida(Salida salida) {
		Salida.salida = salida;
	}

        Salida() {
             throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        }	
}
