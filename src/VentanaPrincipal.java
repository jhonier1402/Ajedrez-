import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;

public class VentanaPrincipal extends JFrame {
    private Clip musicaClip;

    // Constructor normal
    public VentanaPrincipal() {
        inicializar();
        reproducirMusicaDesdeSegundo("/Music_1.wav", 10);
    }

    // Constructor que recibe un Clip existente (desde otra ventana)
    public VentanaPrincipal(Clip clipExistente) {
        this.musicaClip = clipExistente;
        inicializar();

        if (musicaClip != null && !musicaClip.isRunning()) {
            musicaClip.start(); // Reanuda música si estaba pausada
        }
    }

    private void inicializar() {
        setTitle("Chess Master");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());

        // Fondo con imagen
        PanelConFondo fondo = new PanelConFondo();
        fondo.setLayout(new BorderLayout());
        setContentPane(fondo);

        // Panel superior con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(34, 34, 34));
        JLabel titulo = new JLabel("Chess Master");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        panelTitulo.add(titulo);
        fondo.add(panelTitulo, BorderLayout.NORTH);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(true);
        panelBotones.setBackground(new Color(255, 255, 255, 210));
        panelBotones.setPreferredSize(new Dimension(800, 120));
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 25));

        // Botones
        JButton btnJugar = crearBoton("Jugar", new Color(255, 183, 3)); // Dorado
        JButton btnSalir = crearBoton("Salir", new Color(44, 44, 44));  // Negro

        btnJugar.addActionListener(e -> {
            new VentanaOpciones(musicaClip);  // Pasa música a la siguiente ventana
            dispose(); // Cierra esta ventana
        });

        btnSalir.addActionListener(e -> {
            detenerMusica();
            System.exit(0);
        });

        panelBotones.add(btnJugar);
        panelBotones.add(btnSalir);
        fondo.add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JButton crearBoton(String texto, Color colorFondo) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(180, 45));
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return boton;
    }

    private void reproducirMusicaDesdeSegundo(String ruta, int segundoInicio) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(ruta));
            musicaClip = AudioSystem.getClip();
            musicaClip.open(audio);
            long microsegundos = segundoInicio * 1_000_000L;
            musicaClip.setMicrosecondPosition(microsegundos);
            musicaClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicaClip.start();
        } catch (Exception e) {
            System.out.println("Error al reproducir música: " + e.getMessage());
        }
    }

    private void detenerMusica() {
        if (musicaClip != null && musicaClip.isRunning()) {
            musicaClip.stop();
            musicaClip.close();
        }
    }

    // Panel con imagen de fondo
    class PanelConFondo extends JPanel {
        private Image fondo;

        public PanelConFondo() {
            try {
                fondo = new ImageIcon(getClass().getResource("/icon.png")).getImage();
            } catch (Exception e) {
                System.out.println("No se encontró la imagen de fondo.");
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

