package Vista;

import javax.swing.JOptionPane;

public class VentanaEmergente {
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void mostrarAlerta(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,
                              "Error", JOptionPane.WARNING_MESSAGE);
    }
    
}
