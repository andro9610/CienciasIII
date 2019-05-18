/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.JOptionPane;

/**
 *
 * @author jorge diaz
 */
public class Salida {
    private static Salida salida;
    private String string;
	
	private Salida(String string) {
		this.string = string;
		JOptionPane.showMessageDialog(null,this.string);
                
	}
	
	public static Salida mostrar(String string) {
		if (salida == null) {
			salida = new Salida(string);
                        salida = null;
		}else {
			System.out.println("El objeto ya esta creado");
		}
		return salida;
	}

	public static Salida getSalida() {
		return salida;
	}

	public static void setSalida(Salida salida) {
		Salida.salida = salida;
	}

    Salida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
