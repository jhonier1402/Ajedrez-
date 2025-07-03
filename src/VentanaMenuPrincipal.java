import javax.swing.*;
import java.awt.*;

public class VentanaMenuPrincipal extends JFrame {

    public VentanaMenuPrincipal() {
        setTitle("Menú Principal");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Bienvenido", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        JButton botonJugar = new JButton("Jugar");
        botonJugar.setFont(new Font("Arial", Font.PLAIN, 18));
        botonJugar.addActionListener(e -> new VentanaJuegos());
        panelBotones.add(botonJugar);

        JButton botonSalir = new JButton("Salir");
        botonSalir.setFont(new Font("Arial", Font.PLAIN, 18));
        botonSalir.addActionListener(e -> System.exit(0));
        panelBotones.add(botonSalir);

        add(panelBotones, BorderLayout.CENTER);

        setVisible(true);
    }
}
