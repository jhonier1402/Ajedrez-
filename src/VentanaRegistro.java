import javax.swing.*;
import java.awt.*;
import java.io.*;

public class VentanaRegistro extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private final String ARCHIVO_USUARIOS = "usuarios.txt";

    public VentanaRegistro() {
        setTitle("Registro de Usuario");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Nombre de usuario
        add(new JLabel("Nombre de Usuario:"));
        campoUsuario = new JTextField();
        add(campoUsuario);

        // Contraseña
        add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        add(campoContrasena);

        // Botón Registrar
        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.addActionListener(e -> registrarUsuario());
        add(botonRegistrar);

        // Botón Cancelar
        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(e -> dispose());
        add(botonCancelar);

        setVisible(true);
    }

    private void registrarUsuario() {
        String usuario = campoUsuario.getText().trim();
        String contrasena = new String(campoContrasena.getPassword());

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        if (contrasena.length() < 4) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 4 caracteres.");
            return;
        }

        if (!nombreUnico(usuario)) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS, true))) {
            writer.write(usuario + "," + contrasena);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Registro exitoso.");
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el usuario.");
        }
    }

    private boolean nombreUnico(String usuario) {
        File archivo = new File(ARCHIVO_USUARIOS);
        if (!archivo.exists()) return true;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 0 && partes[0].equalsIgnoreCase(usuario)) {
                    return false;
                }
            }
        } catch (IOException ex) {
            return true;
        }

        return true;
    }
}
