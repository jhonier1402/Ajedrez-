import javax.swing.*;
import java.awt.*;

public class VentanaOpciones extends JFrame {

    public VentanaOpciones() {
        setTitle("Opciones");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 🌟 Icono de la ventana (arriba a la izquierda)
        ImageIcon iconoVentana = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconoVentana.getImage());

        // 🌟 Imagen decorativa
        JLabel imagenLabel = new JLabel(new ImageIcon(getClass().getResource("/Icon.png")));
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);

        // 🌟 Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 1, 15, 15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 50));  // Margen

        JButton botonIniciarSesion = new JButton("Iniciar Sesión");
        JButton botonRegistrarse = new JButton("Registrarse");

        // 🌟 Estilo de los botones (redondeado visual)
        Color colorBoton = new Color(10, 20, 105);
        botonIniciarSesion.setBackground(colorBoton);
        botonIniciarSesion.setForeground(Color.WHITE);
        botonIniciarSesion.setFont(new Font("Arial", Font.BOLD, 16));
        botonIniciarSesion.setFocusPainted(false);

        botonRegistrarse.setBackground(colorBoton);
        botonRegistrarse.setForeground(Color.WHITE);
        botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 16));
        botonRegistrarse.setFocusPainted(false);

        // Acciones
        botonIniciarSesion.addActionListener(e -> new VentanaLogin());
        botonRegistrarse.addActionListener(e -> new VentanaRegistro());

        panelBotones.add(botonIniciarSesion);
        panelBotones.add(botonRegistrarse);

        // 🌟 Agregar todo a la ventana
        add(imagenLabel, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);

        setVisible(true);
    }
}

