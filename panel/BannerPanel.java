package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BannerPanel {
    private JPanel panelBanner;

    public BannerPanel() {
        this.panelBanner = new JPanel();
        panelBanner.setPreferredSize(new Dimension(300, 200));
        panelBanner.setOpaque(true);
        panelBanner.setBackground(Color.RED);

      
        panelBanner.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.NORTHWEST; 
        gbc.fill = GridBagConstraints.NONE;

     
        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        panelBanner.add(lblBuscar, gbc);

       
        JTextField entradaCorreo = new JTextField();
        entradaCorreo.setPreferredSize(new Dimension(200, 30));
        entradaCorreo.setText("Usuario");
        entradaCorreo.setForeground(Color.GRAY);

        entradaCorreo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (entradaCorreo.getText().equals("Usuario")) {
                    entradaCorreo.setText("");
                    entradaCorreo.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (entradaCorreo.getText().isEmpty()) {
                    entradaCorreo.setForeground(Color.GRAY);
                    entradaCorreo.setText("Usuario");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelBanner.add(entradaCorreo, gbc);

        JButton btnBuscar = new JButton("Buscar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelBanner.add(btnBuscar, gbc);

      
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 1; 
        gbc.fill = GridBagConstraints.VERTICAL;
        panelBanner.add(new JLabel(), gbc); 
    }

    public JPanel getBanner() {
        return panelBanner;
    }
}
