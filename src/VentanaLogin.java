import javax.swing.*;
import java.awt.*;
import java.io.*;

public class VentanaLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private final String ARCHIVO_USUARIOS = "usuarios.txt";

    public VentanaLogin() {
        setTitle("Iniciar Sesión");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Nombre de Usuario:"));
        campoUsuario = new JTextField();
        add(campoUsuario);

        add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        add(campoContrasena);

        JButton botonLogin = new JButton("Iniciar Sesión");
        botonLogin.addActionListener(e -> verificarCredenciales());
        add(botonLogin);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(e -> dispose());
        add(botonCancelar);

        setVisible(true);
    }

    private void verificarCredenciales() {
        String usuario = campoUsuario.getText().trim();
        String contrasena = new String(campoContrasena.getPassword());

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return;
        }

        boolean encontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2 && partes[0].equals(usuario) && partes[1].equals(contrasena)) {
                    encontrado = true;
                    break;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer los usuarios.");
            return;
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
            new VentanaMenuPrincipal();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
        }
    }
}
