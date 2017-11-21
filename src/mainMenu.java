/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Azizi
 */
public class mainMenu extends javax.swing.JFrame {

    /**
     * Creates new form mainMenu
     */
    public mainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReservation = new javax.swing.JButton();
        btnManageReservation = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Island Hopping Reservation System");
        setMaximumSize(new java.awt.Dimension(1100, 520));
        setMinimumSize(new java.awt.Dimension(1100, 520));
        setPreferredSize(new java.awt.Dimension(1100, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        btnReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/reservationButton.png"))); // NOI18N
        btnReservation.setContentAreaFilled(false);
        btnReservation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservationMouseClicked(evt);
            }
        });
        getContentPane().add(btnReservation);
        btnReservation.setBounds(430, 420, 150, 50);

        btnManageReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/manageReservationButton.png"))); // NOI18N
        btnManageReservation.setContentAreaFilled(false);
        btnManageReservation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManageReservationMouseClicked(evt);
            }
        });
        getContentPane().add(btnManageReservation);
        btnManageReservation.setBounds(600, 420, 250, 50);

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/adminstratorButton.png"))); // NOI18N
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdminMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdmin);
        btnAdmin.setBounds(880, 20, 200, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/mainMenuBG.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageReservationMouseClicked
        
        dispose();
        
        manageReservation mng = new manageReservation();
        mng.setVisible(true);
        mng.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnManageReservationMouseClicked

    private void btnReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservationMouseClicked
        dispose();
        
        reservationMenu revMenu = new reservationMenu();
        revMenu.setVisible(true);
        revMenu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnReservationMouseClicked

    private void btnAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseClicked
        dispose();
        
        loginMenu login = new loginMenu();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAdminMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnManageReservation;
    private javax.swing.JButton btnReservation;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}