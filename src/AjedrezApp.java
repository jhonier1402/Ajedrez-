import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjedrezApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}

// Ventana Principal con "Ajedrez" y botón "Jugar"
class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Ajedrez");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Ajedrez", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 36));
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        add(titulo, BorderLayout.CENTER);

        JButton botonJugar = new JButton("Jugar");
        botonJugar.setFont(new Font("Arial", Font.PLAIN, 20));
        botonJugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaOpciones();
                dispose();
            }
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonJugar);
        add(panelBoton, BorderLayout.SOUTH);

        setVisible(true);
    }
}

// Ventana con "Iniciar sesión" y "Registrarse"
class VentanaOpciones extends JFrame {
    public VentanaOpciones() {
        setTitle("Opciones de Juego");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel mensaje = new JLabel("Selecciona una opción", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 18));
        add(mensaje);

        JButton botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.setFont(new Font("Arial", Font.PLAIN, 16));
        add(botonIniciarSesion);

        JButton botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setFont(new Font("Arial", Font.PLAIN, 16));
        add(botonRegistrarse);

        setVisible(true);
    }
}
