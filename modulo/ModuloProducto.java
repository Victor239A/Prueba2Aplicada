package modulo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modulo.Producto;

public class ModuloProducto {
    private final JPanel panelProducto;
    private static final DecimalFormat DF = new DecimalFormat("Q0.00");

   
    public ModuloProducto() {
        this(crearDemo());
    }

   
    public ModuloProducto(Producto[] productos) {
        panelProducto = new JPanel();
        panelProducto.setOpaque(true);
        panelProducto.setBackground(Color.WHITE);
        panelProducto.setPreferredSize(new Dimension(600, 800));
        panelProducto.setLayout(new GridLayout(0, 4, 15, 15));

        for (Producto p : productos) {
            panelProducto.add(crearProducto(p.getNombre(), DF.format(p.getPrecio())));
        }
    }

    private JPanel crearProducto(String nombre, String precio) {
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(Color.WHITE);

       
        JPanel cuadro = new JPanel();
        cuadro.setPreferredSize(new Dimension(90, 110)); 
        cuadro.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        cuadro.setBackground(Color.WHITE);
        contenedor.add(cuadro, BorderLayout.CENTER);

       
        JPanel abajo = new JPanel(new BorderLayout());
        abajo.setBackground(Color.WHITE);

        JLabel lblNombre = new JLabel(nombre, SwingConstants.LEFT);
        JLabel lblPrecio = new JLabel(precio, SwingConstants.RIGHT);

        abajo.add(lblNombre, BorderLayout.WEST);
        abajo.add(lblPrecio, BorderLayout.EAST);

        contenedor.add(abajo, BorderLayout.SOUTH);
        return contenedor;
    }

    public JPanel getPanel() { return panelProducto; }

    
    private static Producto[] crearDemo() {
        return new Producto[] {
            new Producto("Camiseta", 150.00),
            new Producto("Pantalón", 250.50),
            new Producto("Zapatos", 400.00),
            new Producto("Gorra", 90.00),
            new Producto("Chaqueta", 600.00),
            new Producto("Reloj", 1200.00),
            new Producto("Lentes", 300.00),
            new Producto("Mochila", 350.00)
        };
    }
}
