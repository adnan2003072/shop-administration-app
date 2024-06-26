/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestionClients;

import java.util.List;
import java.util.TimerTask;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Lenoovo
 */
public class GestionBD extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    //public static final DBConnect connexion = new DBConnect();
    public static Main gbd = new Main();
    private static DBConnect conn = Main.getConnexion();
    public GestionBD() {
        initComponents();
        gbd.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBG = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        loginPnl = new javax.swing.JPanel();
        closeLoginBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        loginBtn = new java.awt.Button();
        forgotPasswordBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        loader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        pnlBG.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new java.awt.CardLayout());

        loginPnl.setBackground(new java.awt.Color(255, 255, 255));
        loginPnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 151, 177), 2));
        loginPnl.setName(""); // NOI18N

        closeLoginBtn.setBackground(new java.awt.Color(0, 0, 0));
        closeLoginBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        closeLoginBtn.setForeground(new java.awt.Color(0, 0, 0));
        closeLoginBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeLoginBtn.setText("x");
        closeLoginBtn.setAlignmentY(0.0F);
        closeLoginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        closeLoginBtn.setIconTextGap(0);
        closeLoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeLoginBtnMousePressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contacts_18px.png"))); // NOI18N

        idInput.setBackground(new java.awt.Color(255, 255, 255));
        idInput.setForeground(new java.awt.Color(45, 118, 232));
        idInput.setText("ID Administrateur");
        idInput.setBorder(null);
        idInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                idInputFocusLost(evt);
            }
        });
        idInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(45, 118, 232));
        jSeparator1.setForeground(new java.awt.Color(45, 118, 232));
        jSeparator1.setFocusable(true);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unlock_18px.png"))); // NOI18N

        passwordInput.setBackground(new java.awt.Color(255, 255, 255));
        passwordInput.setForeground(new java.awt.Color(45, 118, 232));
        passwordInput.setText("Password");
        passwordInput.setBorder(null);
        passwordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordInputFocusLost(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(45, 118, 232));
        jSeparator2.setForeground(new java.awt.Color(45, 118, 232));
        jSeparator2.setFocusable(true);

        loginBtn.setBackground(new java.awt.Color(45, 118, 232));
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setLabel("Connexion");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        forgotPasswordBtn.setBackground(new java.awt.Color(255, 255, 255));
        forgotPasswordBtn.setForeground(new java.awt.Color(51, 51, 51));
        forgotPasswordBtn.setText("mot de passe oublié ?");
        forgotPasswordBtn.setBorder(null);
        forgotPasswordBtn.setBorderPainted(false);
        forgotPasswordBtn.setContentAreaFilled(false);
        forgotPasswordBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        forgotPasswordBtn.setFocusPainted(false);
        forgotPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordBtnActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Connexion");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_este (1).png"))); // NOI18N

        javax.swing.GroupLayout loginPnlLayout = new javax.swing.GroupLayout(loginPnl);
        loginPnl.setLayout(loginPnlLayout);
        loginPnlLayout.setHorizontalGroup(
            loginPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPnlLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(loginPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPnlLayout.createSequentialGroup()
                        .addComponent(forgotPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addComponent(idInput, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(passwordInput)
                    .addComponent(jLabel5))
                .addGap(118, 118, 118))
        );
        loginPnlLayout.setVerticalGroup(
            loginPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPnlLayout.createSequentialGroup()
                .addGroup(loginPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(loginPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(loginPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(loginPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgotPasswordBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel1.add(loginPnl, "card2");

        loader.setBackground(new java.awt.Color(255, 255, 255));
        loader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 151, 177), 2));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blueRing.gif"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 118, 232));
        jLabel2.setText("Loging in...");

        javax.swing.GroupLayout loaderLayout = new javax.swing.GroupLayout(loader);
        loader.setLayout(loaderLayout);
        loaderLayout.setHorizontalGroup(
            loaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loaderLayout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addGroup(loaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(loaderLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        loaderLayout.setVerticalGroup(
            loaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loaderLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jPanel1.add(loader, "card3");

        javax.swing.GroupLayout pnlBGLayout = new javax.swing.GroupLayout(pnlBG);
        pnlBG.setLayout(pnlBGLayout);
        pnlBGLayout.setHorizontalGroup(
            pnlBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBGLayout.setVerticalGroup(
            pnlBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputActionPerformed

    private void idInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idInputFocusGained
        String currentText = idInput.getText().trim();
        if (currentText.equals("ID Administrateur"))
            idInput.setText("");
    }//GEN-LAST:event_idInputFocusGained

    private void idInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idInputFocusLost
        String currentText = idInput.getText().trim();
        if (currentText.isEmpty() || currentText.equals("ID Administrateur"))
            idInput.setText("ID Administrateur");
    }//GEN-LAST:event_idInputFocusLost

    private void passwordInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordInputFocusGained
        String currentText = new String(passwordInput.getPassword());
        if (currentText.equals("Password"))
            passwordInput.setText("");
    }//GEN-LAST:event_passwordInputFocusGained

    private void passwordInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordInputFocusLost
        String currentText = new String(passwordInput.getPassword());
        if (currentText.isEmpty() || currentText.equals("Password"))
            passwordInput.setText("Password");
    }//GEN-LAST:event_passwordInputFocusLost

    private void closeLoginBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLoginBtnMousePressed
        conn.quitter();
        System.exit(0);
    }//GEN-LAST:event_closeLoginBtnMousePressed
    
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        //validating user input
        
        List<List> gestData = conn.getData("GESTIONNAIRES");
        String id = idInput.getText().trim();
        String password = new String(passwordInput.getPassword());
        
        if(!isNumber(id)){
            javax.swing.JOptionPane.showMessageDialog(this, "Erreur de connexion:\nID doit etre un nombre!", "Erreur", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else if(id.equals("ID Administrateur") || password.equals("Password")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erreur de connexion:\nid/Veuillez entrer vos informations!", "Erreur", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else if (conn.verifyAdminPassword(password, Integer.parseInt(id))) {
            // show loader and hide login panel
            conn = null;
            loader.show();
            loginPnl.hide(); 
            // lets add timeout
            new java.util.Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    // after validating let's show the main Jframe and close the login window
                    // call:
                    gbd.setVisible(true);
                    dispose();
                }
            },1000*3);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Erreur de connexion:\nVerifiez vos informations !\nID ou Mot de passe incorrecte !", "Erreur", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void forgotPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotPasswordBtnActionPerformed
    int xx, xy;
    
    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == false)
                return false;
 
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the look and feel */
        try {
            FlatLightLaf.setup();
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e){
            e.printStackTrace();
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            GestionBD gbd1 = new GestionBD();
            gbd1.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeLoginBtn;
    private javax.swing.JButton forgotPasswordBtn;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loader;
    private java.awt.Button loginBtn;
    private javax.swing.JPanel loginPnl;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JPanel pnlBG;
    // End of variables declaration//GEN-END:variables
}
