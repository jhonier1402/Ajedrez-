import javax.swing.*;
import java.awt.*;

public class VentanaJuegos extends JFrame {

    public VentanaJuegos() {
        setTitle("Selecciona un Juego");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1, 10, 10));

        JButton botonDamas = new JButton("Damas");
        botonDamas.setFont(new Font("Arial", Font.PLAIN, 18));
        botonDamas.addActionListener(e -> JOptionPane.showMessageDialog(this, "Juego de Damas aún no disponible."));
        add(botonDamas);

        JButton botonAjedrez = new JButton("Ajedrez");
        botonAjedrez.setFont(new Font("Arial", Font.PLAIN, 18));
        botonAjedrez.addActionListener(e -> JOptionPane.showMessageDialog(this, "Juego de Ajedrez aún no disponible."));
        add(botonAjedrez);

        setVisible(true);
    }
}
