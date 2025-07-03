import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.Clip;

public class VentanaOpciones extends JFrame {
    private Clip musicaClip;

    public VentanaOpciones(Clip musicaClip) {
        this.musicaClip = musicaClip;

        setTitle("Opciones");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/Icon.png")).getImage());

        // Fondo
        PanelConFondo fondo = new PanelConFondo();
        fondo.setLayout(new BorderLayout());
        setContentPane(fondo);

        // Panel central transparente con botones
        JPanel panelCentral = new JPanel();
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(80, 150, 80, 150));

        // Botones estilizados
        JButton btnIniciar = crearBoton("Iniciar Sesión", new Color(255, 183, 3));
        JButton btnRegistro = crearBoton("Registrarse", new Color(255, 183, 3));
        JButton btnSalir = crearBoton("Salir", new Color(0, 0, 0));

        btnSalir.addActionListener(e -> {
            if (musicaClip != null && musicaClip.isRunning()) {
                musicaClip.stop();
                musicaClip.close(); // Solo al salir completamente
            }
            new VentanaPrincipal().setVisible(true);
            dispose();
        });



        // Separación entre botones
        panelCentral.add(btnIniciar);
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(btnRegistro);
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(btnSalir);

        fondo.add(panelCentral, BorderLayout.CENTER);
        setVisible(true);
    }

    private JButton crearBoton(String texto, Color colorFondo) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(200, 40));
        boton.setMaximumSize(new Dimension(200, 40));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return boton;
    }

    class PanelConFondo extends JPanel {
        private Image fondo;

        public PanelConFondo() {
            try {
                fondo = new ImageIcon(getClass().getResource("/d4ebdf21-64e9-494a-a417-e8079fc29b0e.png")).getImage();
            } catch (Exception e) {
                System.out.println("No se pudo cargar el fondo.");
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (fondo != null) {
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
