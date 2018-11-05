package explorador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Sistemas Operativos
 */
public class Interfaz extends JFrame implements MouseListener, ActionListener {

    private JPanel ventana, menu, contenido;
    private JButton buscar, atrasl, atras, abrir, crearArchivo, crearDirectorio, copiar, cortar, pegar, eliminar, editar, cerrarSesion;
    private JTextField tbuscar;
    private JScrollPane jsp;
    public static JPanel ultimoClickeado;

    public Interfaz() {
        super("Explorador de archivos");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xx = screenSize.width;
        int yy = screenSize.height;
        this.setSize(1360, 720);
        this.setLocation((xx - 1360) / 2, (yy - 720) / 2);

        ventana = new JPanel();
        ventana.setLayout(new BoxLayout(ventana, BoxLayout.Y_AXIS));
        ventana.setSize(1360, 720);
        ventana.setBackground(Color.WHITE);

        menu = new JPanel();
        menu.setMaximumSize(new Dimension(1360, 50));
        menu.setBackground(new Color(187, 211, 249));
        contenido = new JPanel(new GridLayout(0, 10));
        contenido.setBackground(Color.WHITE);
        jsp = new JScrollPane();
        jsp.setViewportView(contenido);

        atras = new JButton("Atrás");
        atras.setIcon(new ImageIcon("src/Imagenes/Atras.png"));
        atras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atras.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        crearArchivo = new JButton("Crear archivo");
        crearArchivo.setIcon(new ImageIcon("src/Imagenes/CrearArchivo.png"));
        crearArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crearArchivo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        crearDirectorio = new JButton("Crear directorio");
        crearDirectorio.setIcon(new ImageIcon("src/Imagenes/CrearDirectorio.png"));
        crearDirectorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crearDirectorio.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        abrir = new JButton("Abrir");
        abrir.setIcon(new ImageIcon("src/Imagenes/Abrir.png"));
        abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        copiar = new JButton("Copiar");
        copiar.setIcon(new ImageIcon("src/Imagenes/Copiar.png"));
        copiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copiar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cortar = new JButton("Cortar");
        cortar.setIcon(new ImageIcon("src/Imagenes/Cortar.png"));
        cortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cortar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pegar = new JButton("Pegar");
        pegar.setIcon(new ImageIcon("src/Imagenes/Pegar.png"));
        pegar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pegar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tbuscar = new JTextField("", 15);
        buscar = new JButton("Buscar");
        buscar.setIcon(new ImageIcon("src/Imagenes/Buscar.png"));
        buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        eliminar = new JButton("Eliminar");
        eliminar.setIcon(new ImageIcon("src/Imagenes/Eliminar.png"));
        eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        editar = new JButton("Editar");
        editar.setIcon(new ImageIcon("src/Imagenes/Editar.png"));
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cerrarSesion = new JButton("Cerrar Sesion");
        cerrarSesion.setIcon(new ImageIcon("src/Imagenes/LogOut.png"));
        cerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        abrir.setEnabled(false);
        copiar.setEnabled(false);
        cortar.setEnabled(false);
        pegar.setEnabled(Explorador.estadoPegar);
        eliminar.setEnabled(false);
        editar.setEnabled(false);
        atras.addActionListener(this);
        crearArchivo.addActionListener(this);
        crearDirectorio.addActionListener(this);
        pegar.addActionListener(this);
        abrir.addActionListener(this);
        copiar.addActionListener(this);
        cortar.addActionListener(this);
        buscar.addActionListener(this);
        eliminar.addActionListener(this);
        editar.addActionListener(this);
        cerrarSesion.addActionListener(this);
        menu.add(atras);
        menu.add(crearArchivo);
        menu.add(crearDirectorio);
        menu.add(abrir);
        menu.add(copiar);
        menu.add(cortar);
        menu.add(pegar);
        menu.add(eliminar);
        menu.add(editar);
        menu.add(tbuscar);
        menu.add(buscar);
        menu.add(cerrarSesion);

        pintar();

        ventana.add(menu);
        ventana.add(jsp);

        this.add(ventana);

        this.setResizable(false);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Interfaz(Element a) {
        super("Explorador de archivos");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xx = screenSize.width;
        int yy = screenSize.height;
        this.setSize(1360, 720);
        this.setLocation((xx - 1360) / 2, (yy - 720) / 2);

        ventana = new JPanel();
        ventana.setLayout(new BoxLayout(ventana, BoxLayout.Y_AXIS));
        ventana.setSize(1360, 720);
        ventana.setBackground(Color.WHITE);

        menu = new JPanel();
        menu.setMaximumSize(new Dimension(1360, 50));
        menu.setBackground(new Color(187, 211, 249));
        contenido = new JPanel(new GridLayout(0, 10));
        contenido.setBackground(Color.WHITE);
        jsp = new JScrollPane();
        jsp.setViewportView(contenido);

        atrasl = new JButton("Atrás");
        atrasl.setIcon(new ImageIcon("src/Imagenes/Atras.png"));
        atrasl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atrasl.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        crearArchivo = new JButton("Crear archivo");
        crearArchivo.setIcon(new ImageIcon("src/Imagenes/CrearArchivo.png"));
        crearArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crearArchivo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        crearDirectorio = new JButton("Crear directorio");
        crearDirectorio.setIcon(new ImageIcon("src/Imagenes/CrearDirectorio.png"));
        crearDirectorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crearDirectorio.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        abrir = new JButton("Abrir");
        abrir.setIcon(new ImageIcon("src/Imagenes/Abrir.png"));
        abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        copiar = new JButton("Copiar");
        copiar.setIcon(new ImageIcon("src/Imagenes/Copiar.png"));
        copiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copiar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cortar = new JButton("Cortar");
        cortar.setIcon(new ImageIcon("src/Imagenes/Cortar.png"));
        cortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cortar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pegar = new JButton("Pegar");
        pegar.setIcon(new ImageIcon("src/Imagenes/Pegar.png"));
        pegar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pegar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tbuscar = new JTextField("", 15);
        buscar = new JButton("Buscar");
        buscar.setIcon(new ImageIcon("src/Imagenes/Buscar.png"));
        buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        eliminar = new JButton("Eliminar");
        eliminar.setIcon(new ImageIcon("src/Imagenes/Eliminar.png"));
        eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        editar = new JButton("Editar");
        editar.setIcon(new ImageIcon("src/Imagenes/Editar.png"));
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cerrarSesion = new JButton("Cerrar Sesion");
        cerrarSesion.setIcon(new ImageIcon("src/Imagenes/LogOut.png"));
        cerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        abrir.setEnabled(false);
        copiar.setEnabled(false);
        cortar.setEnabled(false);
        pegar.setEnabled(Explorador.estadoPegar);
        eliminar.setEnabled(false);
        editar.setEnabled(false);
        atrasl.addActionListener(this);
        crearArchivo.addActionListener(this);
        crearDirectorio.addActionListener(this);
        pegar.addActionListener(this);
        abrir.addActionListener(this);
        copiar.addActionListener(this);
        cortar.addActionListener(this);
        buscar.addActionListener(this);
        eliminar.addActionListener(this);
        editar.addActionListener(this);
        cerrarSesion.addActionListener(this);
        menu.add(atrasl);
        menu.add(crearArchivo);
        menu.add(crearDirectorio);
        menu.add(abrir);
        menu.add(copiar);
        menu.add(cortar);
        menu.add(pegar);
        menu.add(eliminar);
        menu.add(editar);
        menu.add(tbuscar);
        menu.add(buscar);
        menu.add(cerrarSesion);

        pintarele(a);

        ventana.add(menu);
        ventana.add(jsp);

        this.add(ventana);

        this.setResizable(false);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void pintar() {

        NodeList listaNodos = Explorador.currentDir.getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {

            JLabel icono = new JLabel();

            if (listaNodos.item(i).getNodeName().equals("directorio")) {
                icono.setIcon(new ImageIcon("src/Imagenes/Directorio.png"));
            } else {
                icono.setIcon(new ImageIcon("src/Imagenes/Archivo.png"));
            }

            Panel panel = new Panel(listaNodos.item(i).getNodeName(), listaNodos.item(i).getAttributes().getNamedItem("nombre").getTextContent(),
                     icono);
            JPanel elemento = panel.crear();
            elemento.addMouseListener(this);
            contenido.add(elemento);
        }
    }

    public void pintarele(Element a) {
        NodeList listaNodos = Explorador.currentDir.getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            if (a == listaNodos.item(i)) {
                JLabel icono = new JLabel();
                if (listaNodos.item(i).getNodeName().equals("directorio")) {
                    icono.setIcon(new ImageIcon("src/Imagenes/Directorio.png"));
                } else {
                    icono.setIcon(new ImageIcon("src/Imagenes/Archivo.png"));
                }

                Panel panel = new Panel(listaNodos.item(i).getNodeName(),listaNodos.item(i).getAttributes().getNamedItem("nombre").getTextContent(),icono);
                JPanel elemento = panel.crear();
                elemento.addMouseListener(this);
                contenido.add(elemento);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (ultimoClickeado != null) {
            ultimoClickeado.setBackground(Color.WHITE);
        }
        me.getComponent().setBackground(new Color(187, 211, 249));
        ultimoClickeado = (JPanel) me.getComponent();
        JLabel tipoComponente = (JLabel) ultimoClickeado.getComponent(0);
        if (tipoComponente.getText().equals("directorio")) {
            abrir.setEnabled(true);
        } else {
            abrir.setEnabled(false);
        }
        cortar.setEnabled(true);
        copiar.setEnabled(true);
        eliminar.setEnabled(true);
        editar.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == crearArchivo) {
            new InterfazCrearElemento("Archivo", this);
        }
        if (ae.getSource() == crearDirectorio) {
            new InterfazCrearElemento("Directorio", this);
        }
        if (ae.getSource() == abrir) {
            JLabel nombreDirectorio = (JLabel) ultimoClickeado.getComponent(1);
            Element ultimo = Directorio.obtenerNodoHijo(nombreDirectorio.getText());
            if (ultimo.getAttribute("lectura").equals("Público") || ultimo.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                Explorador.currentDir = Directorio.obtenerNodoHijo(nombreDirectorio.getText());
                this.dispose();
                new Interfaz();
                Explorador.setCurrentLevel(Explorador.getCurrentLevel() + 1);
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos de lectura de este fichero", "Error de acceso", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == atras) {
            if (Explorador.getCurrentLevel() > 1) {
                Explorador.currentDir = (Element) Explorador.currentDir.getParentNode();
                this.dispose();
                new Interfaz();
                Explorador.setCurrentLevel(Explorador.getCurrentLevel() - 1);
            }
        }
        if (ae.getSource() == atrasl) {
            this.dispose();
            new Interfaz();
        }
        if (ae.getSource() == copiar) {
            JLabel nombreElemento = (JLabel) ultimoClickeado.getComponent(1);
            JLabel tipoElemento = (JLabel) ultimoClickeado.getComponent(0);
            if (tipoElemento.getText().equals("archivo")) {
                Explorador.elementoaPegar = Archivo.obtenerNodoHijo(nombreElemento.getText());
            } else {
                Explorador.elementoaPegar = Directorio.obtenerNodoHijo(nombreElemento.getText());
            }
            if (Explorador.elementoaPegar.getAttribute("escritura").equals("Público") || Explorador.elementoaPegar.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                pegar.setEnabled(true);
                Explorador.estadoPegar = true;
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos para copiar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == cortar) {
            JLabel nombreElemento = (JLabel) ultimoClickeado.getComponent(1);
            JLabel tipoElemento = (JLabel) ultimoClickeado.getComponent(0);
            if (tipoElemento.getText().equals("archivo")) {
                Explorador.elementoaPegar = Archivo.obtenerNodoHijo(nombreElemento.getText());
            } else {
                Explorador.elementoaPegar = Directorio.obtenerNodoHijo(nombreElemento.getText());
            }
            if (Explorador.elementoaPegar.getAttribute("escritura").equals("Público") || Explorador.elementoaPegar.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                int id_removido = Integer.parseInt(Explorador.elementoaPegar.getAttribute("id"));
                Elemento removido = new Elemento(id_removido, nombreElemento.getText(), tipoElemento.getText());
                removido.eliminar();
                pegar.setEnabled(true);
                Explorador.estadoPegar = true;
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos para cortar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == pegar) {
            System.out.println(Explorador.elementoaPegar);
            if (Explorador.elementoaPegar.getNodeName().equals("archivo")) {
                Archivo archivo = new Archivo(Explorador.getCurrentId(), Explorador.elementoaPegar.getAttribute("nombre"), "Archivo", "Lorem", true, true, "adm");
                archivo.agregar();
                this.dispose();
                new Interfaz();
            } else {
                Directorio directorio = new Directorio(Explorador.getCurrentId(), Explorador.elementoaPegar.getAttribute("nombre"), "directorio", true, true, "Adm");
                directorio.clonar();
                this.dispose();
                new Interfaz();
            }
        }
        if (ae.getSource() == buscar) {
            String aux = tbuscar.getText();
            boolean encontrado = false;
            NodeList listaNodos = Explorador.currentDir.getChildNodes();
            for (int i = 0; i < listaNodos.getLength(); i++) {
                Element a = (Element) listaNodos.item(i);
                if (a.getAttribute("nombre").equalsIgnoreCase(aux)) {
                    pintarele(a);
                    this.dispose();
                    new Interfaz(a);
                    encontrado = true;
                }
            }
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "El archivo o directorio " + aux + " no se encuentra");
            }
        }
        
        if (ae.getSource() == eliminar) {
            JLabel nombreElemento = (JLabel) ultimoClickeado.getComponent(1);
            JLabel tipoElemento = (JLabel) ultimoClickeado.getComponent(0);
            if (tipoElemento.getText().equals("archivo")) {
                Element removido = Archivo.obtenerNodoHijo(nombreElemento.getText());
                if (removido.getAttribute("escritura").equals("Público") || removido.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                    Archivo a = new Archivo(Integer.parseInt(removido.getAttribute("id")), removido.getAttribute("nombre"), removido.getNodeName(), "Lorem", true, true, "adm");
                    a.eliminar();
                    pegar.setEnabled(false);
                    Explorador.estadoPegar = false;
                    ultimoClickeado = null;
                    this.dispose();
                    new Interfaz();
                } else {
                    JOptionPane.showMessageDialog(null, "No tienes permisos para eliminar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                Element removido = Directorio.obtenerNodoHijo(nombreElemento.getText());
                if (removido.getAttribute("escritura").equals("Público") || removido.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                    Directorio d = new Directorio(Integer.parseInt(removido.getAttribute("id")), removido.getAttribute("nombre"), removido.getNodeName(), true, true, "admn");
                    d.eliminar();
                    pegar.setEnabled(false);
                    Explorador.estadoPegar = false;
                    ultimoClickeado = null;
                    this.dispose();
                    new Interfaz();
                } else {
                    JOptionPane.showMessageDialog(null, "No tienes permisos para eliminar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (ae.getSource() == editar) {
            JLabel nombreDirectorio = (JLabel) ultimoClickeado.getComponent(1);
            JLabel tipoElemento = (JLabel) ultimoClickeado.getComponent(0);
            Element ultimo;
            if (tipoElemento.getText().equals("directorio")) {
                ultimo = Directorio.obtenerNodoHijo(nombreDirectorio.getText());
            } else {
                ultimo = Archivo.obtenerNodoHijo(nombreDirectorio.getText());
            }
            if (ultimo.getAttribute("escritura").equals("Público") || ultimo.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                new InterfazEditarElemento(tipoElemento.getText(), this);
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos para editar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == cerrarSesion) {
            Usuario.cerrarSesion();
            this.dispose();
            new InterfazInicio();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    class Panel {

        private final String tipo, nombre;
        private final JLabel icono;

        public Panel(String tipo, String nombre, JLabel icono) {
            this.tipo = tipo;
            this.nombre = nombre;
            this.icono = icono;
        }

        public JPanel crear() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel nombre = new JLabel(this.nombre);

            JLabel tipo = new JLabel(this.tipo);

            panel.add(tipo);
            panel.add(nombre);
            panel.add(icono);

            panel.setBackground(Color.WHITE);
            return panel;
        }
    }
}
