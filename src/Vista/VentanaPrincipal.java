package Vista;

import java.awt.Cursor;
import java.awt.LayoutManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.function.Function;
import javax.swing.SwingConstants;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class VentanaPrincipal extends javax.swing.JFrame {

    private int X, Y;

    public VentanaPrincipal() {
        initComponents();

        setLocationRelativeTo(null);

//        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnOpciones = new javax.swing.JPopupMenu();
        mnCrearCarpeta = new javax.swing.JMenu();
        dskPrincipal = new javax.swing.JDesktopPane();

        mnCrearCarpeta.setText("Crear Carpeta");
        mnCrearCarpeta.setToolTipText("");
        mnCrearCarpeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnCrearCarpetaMouseClicked(evt);
            }
        });
        pmnOpciones.add(mnCrearCarpeta);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dskPrincipal.setComponentPopupMenu(pmnOpciones);
        dskPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                dskPrincipalMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout dskPrincipalLayout = new javax.swing.GroupLayout(dskPrincipal);
        dskPrincipal.setLayout(dskPrincipalLayout);
        dskPrincipalLayout.setHorizontalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        dskPrincipalLayout.setVerticalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dskPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnCrearCarpetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnCrearCarpetaMouseClicked
        String nombreCarpeta = JOptionPane.showInputDialog(null, "Nombre de la carpeta");

        JLabel lblCarpeta = new JLabel(nombreCarpeta);
        lblCarpeta.setBounds(X, Y, 100, 100);

        lblCarpeta.setIcon(setIconInLabel("/Imagenes/carpeta.png"));

        dskPrincipal.add(lblCarpeta);

        lblCarpeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == 1) {
                    Carpeta carpeta = new Carpeta(nombreCarpeta, new Point(e.getPoint().x + 100, e.getPoint().y + 30));

                    dskPrincipal.add(carpeta);
                    carpeta.show();
                }
                
                if(e.getButton()==3){
                    System.out.println("XD");
                    pmnOpciones.disable();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }

    
        });
        dskPrincipal.updateUI();
    }//GEN-LAST:event_mnCrearCarpetaMouseClicked

    private void dskPrincipalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dskPrincipalMouseMoved
        X = evt.getPoint().x;
        Y = evt.getPoint().y;
    }//GEN-LAST:event_dskPrincipalMouseMoved

    public ImageIcon setIconInLabel(String path) {
        return new ImageIcon(getClass().getResource(path));
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JMenu mnCrearCarpeta;
    private javax.swing.JPopupMenu pmnOpciones;
    // End of variables declaration//GEN-END:variables
}
