package Vista;

import Logica.Automata;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Vista.RecursosGraficos;

/**VentanaGrafos: clase con la implementacion puntual de la ventana principal de
 * la aplicacion*/
public class VentanaGrafos{
    /** Variable para crear toda la interfaz con mas facilidad */
    RecursosGraficos herramientas;

    /**Variables que recogen los input en pantalla */
    JTextField inputEstados;
    JTextField inputEstadosFinales;
    JTextField inputAlfabeto;

    /**VentanaGrafos: Agrega todos los elementos a la ventana para su funcionamiento*/
    public void crearVentanaGrafos() {
        herramientas = new RecursosGraficos();
        JFrame ventanaGrafos = herramientas.crearVentana("Automatas", "../Recursos/Icono.png", 800, 600);
        ventanaGrafos.setBackground(new Color(35, 35, 35));
        ventanaGrafos.add(crearFormulario());
        ventanaGrafos.add(crearPanelGrafico());
        ventanaGrafos.setVisible(true);
    }

    /**crearFormulario: retorna un panel con los elementos de la parte superior de la pantalla*/
    private JPanel crearFormulario() {
        JPanel formulario = herramientas.agregarPanel(800, 177);
        formulario.setBackground(new Color(35, 35, 35));
        /** Añadido de textos */
        formulario.add(herramientas.crearTexto("Estados: ", 15, 19, 90, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto("Estados finales:", 15, 71, 169, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto("Alfabeto:", 15, 113, 99, 50, herramientas.obtenerColor("grisClaro")));
        /** Añadido de campos de texto */
        inputEstados = herramientas.crearInput(197, 19, 249, 32);
        inputEstadosFinales = herramientas.crearInput(197, 71, 249, 32);
        inputAlfabeto = herramientas.crearInput(197, 123, 249, 32);
        formulario.add(inputEstados);
        formulario.add(inputEstadosFinales);
        formulario.add(inputAlfabeto);
        /*** Añadido de los botones */
        formulario.add(crearBotonTransformar());
        formulario.add(crearBotonAgregarTransicion());
        return formulario;
    }

    /**crearBotonTransformar: crea el boton verde de transformacion, y le da funcionalidad
     * @return botonTransformar (JButton)
     */
    private JButton crearBotonTransformar() {
        JButton botonTransformar = herramientas.crearBoton("Transformar", 491, 24, 260, 54, new Color(0, 170, 72));
        /** Añadido de ActionListener */
        botonTransformar.addActionListener((ActionEvent e) -> {
            /** Ejecucion del algoritmo */
            System.out.println(inputEstados.getText());
        });
       return botonTransformar;
   }

   /**crearBotonAgregarTransicion: crea el boton de agregar transicion, y le da funcionalidad
    * @return botonTransicion (JButton)
    */
   private  JButton crearBotonAgregarTransicion(){
        JButton botonTransicion = herramientas.crearBoton("Agregar transicion", 491, 95, 260, 54, new Color(172, 0, 184));
        /** Añadido de ActionListener */
        botonTransicion.addActionListener((ActionEvent e) -> {
            /** Ejecucion del algoritmo */
            int ei = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese estado inicial"));
            String transi = javax.swing.JOptionPane.showInputDialog("Ingrese transición");
            int ef = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese estado final"));
            z.addTransicion(ei, transi, ef);
            tabla1();
            System.out.println("Accion de transicion");
        });
        return botonTransicion;
   }

   /**crearPanelGrafico: crea un panel para la insercion del grafo */
   private JPanel crearPanelGrafico(){
       JPanel panelGrafico = herramientas.agregarPanel(800, 412);
       panelGrafico.setBackground(herramientas.obtenerColor("grisClaro"));
       return panelGrafico;
   }
   
   public void tabla1() {
        tabla1 = "\t" + z.getAlfabeto().toString() + "\n";

        for (int i = 0; i < z.getTablaTransiciones().length; i++) {
            for (int j = 0; j < z.getTablaTransiciones()[i].length; j++) {
                if (j == 0) {
                    tabla1 = tabla1 + i + "\t" + (z.getTablaTransiciones()[i][j].toString());
                } else {

                    tabla1 = tabla1 + (z.getTablaTransiciones()[i][j].toString());
                }
            }
            tabla1 = tabla1 + "\n";
        }
        //this.jTextArea1.setText(tabla1);
    }
   
   public static Automata z = new Automata();
   String tabla1 = "";
   public Automata trans = new Automata();
   String tabla2 = "";
}
