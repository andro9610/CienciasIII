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
import java.util.TreeSet;

/**VentanaGrafos: clase con la implementacion puntual de la ventana principal de
 * la aplicacion*/
public class VentanaGrafos{
    /** Variable para crear toda la interfaz con mas facilidad */
    RecursosGraficos herramientas;

    /**Variables que recogen los input en pantalla */
    JTextField inputEstados;
    JTextField inputEstadosFinales;
    JTextField inputAlfabeto;
    
    JTextArea areaA;
    JTextArea areaB;

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
        z.setNombre("Autómata");

        Integer numEstados = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese número de estados"));
        z.setnumEstados(numEstados);
        z.setEstadoInicial(0);


        int estFinales = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese número de estados finales"));
        for (int i = 0; i < estFinales; i++) {
            int estadoFinal = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese estado final"));
            z.addEstadoFinal(estadoFinal);
        }

        int alf = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese cantidad de letras del alfabeto"));
        for (int i = 0; i < alf; i++) {
            z.addLetraAlfabeto(javax.swing.JOptionPane.showInputDialog("Ingrese letra"));
        }
        
        JPanel formulario = herramientas.agregarPanel(800, 177);
        formulario.setBackground(new Color(35, 35, 35));
        /** Añadido de textos */
        formulario.add(herramientas.crearTexto("Estados: ", 15, 19, 90, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto("Estados finales:", 15, 71, 169, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto("Alfabeto:", 15, 113, 99, 50, herramientas.obtenerColor("grisClaro")));
        /** Añadido de campos de texto */
        formulario.add(herramientas.crearTexto(z.getestadoFinal().toString(), 197, 71, 249, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto(numEstados.toString(), 197, 19, 249, 32, herramientas.obtenerColor("grisClaro")));
        formulario.add(herramientas.crearTexto(z.getAlfabeto().toString(), 197, 113, 249, 32, herramientas.obtenerColor("grisClaro")));

        //inputEstados = herramientas.crearInput(197, 19, 249, 32);
        //inputEstadosFinales = herramientas.crearInput(197, 71, 249, 32);
        //inputAlfabeto = herramientas.crearInput(197, 113, 249, 32);
        //formulario.add(inputEstados);
        //formulario.add(inputEstadosFinales);
        //formulario.add(inputAlfabeto);
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
            trans = new Transformador().minimizar(z);
            tabla2();
            //this.txtNumEstados1.setText(String.valueOf(trans.getnumEstados()));
            //this.txtAlfabeto1.setText(trans.getAlfabeto().toString());
            //this.txtestFinales1.setText(trans.getestadoFinal().toString());
            System.out.println(inputEstados.getText());
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
       /**Añadido de los TextArea */
       areaA = crearTablaTransiciones(5, 210, 370, 330);
       areaB = crearTablaTransiciones(400, 210, 370, 330);
       panelGrafico.add(areaA);
       panelGrafico.add(areaB);
       return panelGrafico;
   }

   private JTextArea crearTablaTransiciones(int posX, int posY, int alto, int ancho){
       Color colorTablaTransiciones = herramientas.obtenerColor("verdeClaro");
        JTextArea tablaTransiciones = herramientas.crearAreaTexto(posX, posY, alto, ancho, colorTablaTransiciones);
        return tablaTransiciones;
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
        this.areaA.setText(tabla1);
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
        this.areaB.setText(tabla2);
    }
   
    public static Automata z = new Automata();
    String tabla1 = "";
    public Automata trans = new Automata();
    String tabla2 = "";
}
