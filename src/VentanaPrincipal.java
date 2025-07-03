import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Ajedrez");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Establecer icono
        ImageIcon icono = new ImageIcon(getClass().getResource("/icon.png"));
        setIconImage(icono.getImage());

        JLabel titulo = new JLabel("Ajedrez", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 40));
        add(titulo, BorderLayout.NORTH);

        JButton botonJugar = new JButton("Jugar");
        botonJugar.setFont(new Font("Arial", Font.PLAIN, 22));
        botonJugar.setPreferredSize(new Dimension(150, 50));
        botonJugar.addActionListener(e -> {
            new VentanaOpciones();
            dispose();
        });

        JPanel panelCentro = new JPanel(new GridBagLayout());
        panelCentro.add(botonJugar);
        add(panelCentro, BorderLayout.CENTER);

        setVisible(true);
    }
}
