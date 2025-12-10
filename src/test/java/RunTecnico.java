/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jesús
 */
import com.mycompany.tallerreparacioncelular.JFames.TecnicoPanel;
import javax.swing.JFrame;

public class RunTecnico {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba Técnico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TecnicoPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
