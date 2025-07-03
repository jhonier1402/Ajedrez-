import javax.swing.*;
import java.awt.*;

public class VentanaOpciones extends JFrame {

    public VentanaOpciones() {
        setTitle("Opciones de Juego");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel mensaje = new JLabel("Selecciona una opción", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 20));
        add(mensaje);

        JButton botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.setFont(new Font("Arial", Font.PLAIN, 16));
        add(botonIniciarSesion);

        JButton botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setFont(new Font("Arial", Font.PLAIN, 16));
        botonRegistrarse.addActionListener(e -> new VentanaRegistro());
        add(botonRegistrarse);

        setVisible(true);
    }
}

