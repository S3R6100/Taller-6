import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilaGUI {
    private JPanel pGeneral;
    private JTextField inputField;
    private JTextArea textArea1;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JButton busquedaLinealButton;

    private Pila pila=new Pila();;

    /**
     * Constructor de la GUI de la pila.
     * Configura los botones con sus respectivas acciones.
     */
    public PilaGUI() {

        // Botón "Apilar": Agrega un nuevo elemento a la pila.
        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    pila.apilar(valor,textArea1);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }

        });

        // Botón "Desapilar": Elimina el elemento en la cima de la pila.
        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pila.desapilar(textArea1);
            }
        });

        // Botón "Busqueda Lineal": Busca un elemento en la pila utilizando búsqueda lineal.
        busquedaLinealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();

                try{
                    int valor= Integer.parseInt(input);
                    int posicion= pila.buscarLineal(valor, textArea1);

                    if(posicion ==-1){
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado en la pila.");
                    } else {
                        posicion++;
                        JOptionPane.showMessageDialog(null, "Elemento "+ valor +" encontrado en la posicion "+ posicion);
                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PilaGUI");
        frame.setContentPane(new PilaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
