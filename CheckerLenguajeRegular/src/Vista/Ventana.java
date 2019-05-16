package Vista;
        
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Ventana {
    /**crearVentana: Crea una ventana*/
    public void crearVentana(){
        /**Creacion del objeto ventana*/
        JFrame ventana = new JFrame("CheckerLenguajeRegular");
        /**Parametros basicos de la ventana*/
        ventana.setSize(600,400);
        ventana.setUndecorated(false);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        
        /**Personalizacion de la ventana*/
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("../Recursos/iconoPrograma.png"));
        Image Image = ImageIcon.getImage();
        ventana.setIconImage(Image);
        /**Añadido de paneles a la ventana*/
        ventana.add(this.añadirElementos());
        
        /**Mostrar la ventana*/
        ventana.setVisible(true);
    }
    
    /**añadirElementos: Añade JButtons JLabels y textFields a La ventan
     * @return panel*/
    private JPanel añadirElementos(){
        JPanel panel = new JPanel();
        /**añadido de elementos al Panel*/
        panel.add(crearTexto("Ingrese el alfabeto, separado por comas"));
        panel.add(crearInput());
        panel.add(crearBoton("Comprobar"));
        return panel;
    }
    
    /**crearBoton: utilidad para crear botones
     * parametros: String textoBoton
     * @return JButton;
     */
    private JButton crearBoton(String textoBoton){
        JButton boton = new JButton(textoBoton);
        return boton;
    }
    
    /**crearTexto: Utilidad para crear texto
     * parametros: String mensaje
     * @return: JLabel;
     */
    private JLabel crearTexto(String mensaje){
        JLabel texto = new JLabel(mensaje);
        return texto;
    }
    
    private JTextField crearInput(){
        JTextField campoTexto = new JTextField();
        return campoTexto;
    }
}
