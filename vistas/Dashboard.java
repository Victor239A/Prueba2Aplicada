package vistas;

import panel.BannerPanel;
import modulo.ModuloProducto;
import modulo.Producto;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    
    public Dashboard() {
        setTitle("Tienda en Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2100, 1500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

       
        BannerPanel banner = new BannerPanel();
        add(banner.getBanner(), BorderLayout.WEST);

        JPanel panelDerecha = new JPanel(new BorderLayout());

        JLabel lblProducto = new JLabel("Producto");
        lblProducto.setForeground(Color.BLACK);
        lblProducto.setFont(new Font("Arial", Font.BOLD, 22));
        lblProducto.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelDerecha.add(lblProducto, BorderLayout.NORTH);

        Producto[] productos = {
            new Producto("Camiseta", 150.00),
            new Producto("Pantalón", 250.50),
            new Producto("Zapatos", 400.00),
            new Producto("Gorra", 90.00),
            new Producto("Chaqueta", 600.00),
            new Producto("Reloj", 1200.00),
            new Producto("Lentes", 300.00),
            new Producto("Mochila", 350.00)
        };

        ModuloProducto modulo = new ModuloProducto(productos);
        panelDerecha.add(modulo.getPanel(), BorderLayout.CENTER);

        add(panelDerecha, BorderLayout.CENTER);

        setVisible(true);
    }

   }