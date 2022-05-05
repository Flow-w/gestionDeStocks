import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class FenetreErreur extends javax.swing.JFrame {
    
    private String msgErreur;
    
    public FenetreErreur() {
        initComponents();
        AlerteSon();
        
        //pour que la fenetre puisse écouter les keys
        this.setFocusable(true);
        this.requestFocus();
        
        //keyListenner permettant d'effectuer des actions en fonctions des touches préssées
        //à compléter si besoin est
        this.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keycode  = e.getKeyCode();
                    if (keycode == 13 || keycode==10)OKButton.doClick();
                    if (keycode==27)dispose();
                }
            }
        );
    }
    
    public FenetreErreur(String msg) {
        initComponents();
        AlerteSon();
        this.msgErreur=msg;
        MsgErreur.setText(msg);
        
        //pour que la fenetre puisse écouter les key préssées
        this.setFocusable(true);
        this.requestFocus();
        
        //keyListenner permettant d'effectuer des actions en fonctions des touches préssées
        //à compléter si besoin est
        this.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keycode  = e.getKeyCode();

                    //touche entrée préssée : on clique sur le bouton OK
                    if (keycode == 13 || keycode==10)  {
                        OKButton.doClick();
                    }
                    //touche Echap préssée : on ferme la fenetre
                    if (keycode==27){
                        dispose();
                    }
                }
            }
        );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label = new javax.swing.JLabel();
        MsgErreur = new javax.swing.JLabel();
        OKButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Label.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label.setText("Erreur  :");

        MsgErreur.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        MsgErreur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MsgErreur.setText("Il y a eu une erreur veuillez réessayer.");
        MsgErreur.setToolTipText("");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(MsgErreur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MsgErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OKButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_OKButtonActionPerformed
        
    private void AlerteSon(){
        try{
            File sound= new File(getClass().getResource("sonAlerte1.wav").toURI());
            Clip c=AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        }
        catch(IOException | URISyntaxException | LineUnavailableException | UnsupportedAudioFileException ex){
            System.out.println(ex);
        }
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreErreur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreErreur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreErreur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreErreur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            String msgErreur1 = null;
            new FenetreErreur().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel MsgErreur;
    private javax.swing.JToggleButton OKButton;
    // End of variables declaration//GEN-END:variables
}
