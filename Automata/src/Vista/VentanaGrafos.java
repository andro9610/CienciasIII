package Vista;

import Logica.Automata;
import Logica.Transformador;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Vista.RecursosGraficos;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JLabel;

/**VentanaGrafos: clase con la implementacion puntual de la ventana principal de
 * la aplicacion */
public class VentanaGrafos{
    /** Variable para crear toda la interfaz con mas facilidad */
    RecursosGraficos herramientas;

    /**Variables que recogen los input en pantalla */    
    JLabel textoEstados;
    JLabel textoEstadosFinales;
    JLabel textoAlfabeto;
    
    JTextArea areaNoDeterminista;
    JTextArea areaDeterminista;

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
        automataIngresado.setNombre("Autómata");

        Integer numEstados = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese número de estados"));
        automataIngresado.setnumEstados(numEstados);
        automataIngresado.setEstadoInicial(0);


        int estFinales = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese número de estados finales"));
        for (int i = 0; i < estFinales; i++) {
            int estadoFinal = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese estado final"));
            automataIngresado.addEstadoFinal(estadoFinal);
        }

        int alf = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese cantidad de letras del alfabeto"));
        for (int i = 0; i < alf; i++) {
            automataIngresado.addLetraAlfabeto(javax.swing.JOptionPane.showInputDialog("Ingrese letra"));
        }
        
        JPanel formulario = herramientas.agregarPanel(800, 177);
        formulario.setBackground(new Color(35, 35, 35));
        /** Añadido de textos */
        formulario.add(herramientas.crearTexto("Estados: ", 15, 19, 90, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto("Estados finales:", 15, 71, 169, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto("Alfabeto:", 15, 113, 99, 50, herramientas.obtenerColor("grisClaro")));
        /** Añadido de campos de texto */
        formulario.add(herramientas.crearTexto(automataIngresado.getestadoFinal().toString(), 197, 71, 249, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto(numEstados.toString(), 197, 19, 249, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto(automataIngresado.getAlfabeto().toString(), 197, 113, 249, 32, herramientas.obtenerColor("grisClaro")));

        textoEstados = herramientas.crearTexto(Integer.toString(automataIngresado.getnumEstados()), 197, 19, 249, 32, Color.black);
        textoEstadosFinales = herramientas.crearTexto("",197, 71, 249, 32, Color.black);
        textoAlfabeto = herramientas.crearTexto("",197, 113, 249, 32, Color.black);
        formulario.add(textoEstados);
        formulario.add(textoEstadosFinales);
        formulario.add(textoAlfabeto);
        /*** Añadido de los botones */
        formulario.add(crearBotonAgregarTransicion());
        formulario.add(crearBotonTransformar());
        
        return formulario;
    }

    /**crearBotonTransformar: crea el boton verde de transformacion, y le da funcionalidad
     * @return botonTransformar (JButton)
     */
    private JButton crearBotonTransformar() {
        JButton botonTransformar = herramientas.crearBoton("Transformar", 491, 95, 260, 54, new Color(0, 170, 72));
        /** Añadido de ActionListener */
        botonTransformar.addActionListener((ActionEvent e) -> {
            /** Ejecucion del algoritmo */
            trans = new Transformador().minimizar(automataIngresado);
            tabla2();
        });
       return botonTransformar;
   }

   /**crearBotonAgregarTransicion: crea el boton de agregar transicion, y le da funcionalidad
    * @return botonTransicion (JButton)
    */
   private JButton crearBotonAgregarTransicion(){
        JButton botonTransicion = herramientas.crearBoton("Agregar transicion", 491, 24, 260, 54, new Color(172, 0, 184));
        /** Añadido de ActionListener */
        botonTransicion.addActionListener((ActionEvent e) -> {
            /** Ejecucion del algoritmo */
            int ei = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese estado inicial"));
            String transi = javax.swing.JOptionPane.showInputDialog("Ingrese transición");
            int ef = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese estado final"));
            automataIngresado.addTransicion(ei, transi, ef);
            tabla1();
        });
        return botonTransicion;
   }

   /**crearPanelGrafico: crea un panel para la insercion del grafo */
   private JPanel crearPanelGrafico(){
       JPanel panelGrafico = herramientas.agregarPanel(800, 412);
       panelGrafico.setBackground(herramientas.obtenerColor("grisClaro"));
       /**Añadido de los TextArea */
       areaNoDeterminista = crearTablaTransiciones(5, 210, 370, 330);
       areaDeterminista = crearTablaTransiciones(400, 210, 370, 330);
       panelGrafico.add(areaNoDeterminista);
       panelGrafico.add(areaDeterminista);
       return panelGrafico;
   }

   private JTextArea crearTablaTransiciones(int posX, int posY, int alto, int ancho){
       Color colorTablaTransiciones = herramientas.obtenerColor("verdeClaro");
        JTextArea tablaTransiciones = herramientas.crearAreaTexto(posX, posY, alto, ancho, colorTablaTransiciones);
        return tablaTransiciones;
   }
   
   public void tabla1() {
        tabla1 = "\t" + automataIngresado.getAlfabeto().toString() + "\n";

        for (int i = 0; i < automataIngresado.getTablaTransiciones().length; i++) {
            for (int j = 0; j < automataIngresado.getTablaTransiciones()[i].length; j++) {
                if (j == 0) {
                    tabla1 = tabla1 + i + "\t" + (automataIngresado.getTablaTransiciones()[i][j].toString());
                } else {

                    tabla1 = tabla1 + (automataIngresado.getTablaTransiciones()[i][j].toString());
                }
            }
            tabla1 = tabla1 + "\n";
        }
        this.areaNoDeterminista.setText(tabla1);
    }
   
   public void tabla2() {
        tabla2 = "\t" + trans.getAlfabeto().toString() + "\n";
        TreeSet<Integer> table = new TreeSet<Integer>();
        table.add(0);

        for (int i = 0; i < trans.getTablaTransiciones().length; i++) {
            for (int j = 0; j < trans.getTablaTransiciones()[i].length; j++) {
                if (trans.getTablaTransiciones()[i][j].isEmpty()) {
                    trans.getTablaTransiciones()[i][j] = table;
                }
            }
        }


        for (int i = 0; i < trans.getTablaTransiciones().length; i++) {
            for (int j = 0; j < trans.getTablaTransiciones()[i].length; j++) {
                if (j == 0) {
                    tabla2 = tabla2 + i + "\t" + (trans.getTablaTransiciones()[i][j].toString());
                } else {

                    tabla2 = tabla2 + (trans.getTablaTransiciones()[i][j].toString());
                }
            }
            tabla2 = tabla2 + "\n";
        }
        this.areaDeterminista.setText(tabla2);
    }
   
    public static Automata automataIngresado = new Automata();
    String tabla1 = "";
    public Automata trans = new Automata();
    String tabla2 = "";
    
    private String imprimirTreeSet(TreeSet elVector){
        String textoTreeSet = null;
        for( Iterator it = elVector.iterator(); it.hasNext();) {      
            textoTreeSet = textoTreeSet+", "+elVector.iterator();
            System.out.println(textoTreeSet);
        }
        return textoTreeSet;
    }
}
