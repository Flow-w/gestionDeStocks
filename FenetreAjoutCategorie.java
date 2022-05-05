import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FenetreAjoutCategorie extends javax.swing.JFrame {
    
    private Connection con;
    //modif NIRA 26/04 
    final FenetrePrincipale fprincipale;
            
    public FenetreAjoutCategorie(FenetrePrincipale fp) {
        this.fprincipale=fp;
        initComponents();
        
        this.setFocusable(true);
        this.requestFocus();
        
        this.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keycode  = e.getKeyCode();             
                    //touche entrée préssée : on clique sur le bouton OK
                    if (keycode == 13 || keycode==10)btn_retour.doClick();
                    //touche Echap préssée : on ferme la fenetre
                    if (keycode==27)dispose();
                }
            }
        );
        
        txtfield_ajoutNvelleCate.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keycode  = e.getKeyCode();             
                    //touche entrée préssée : on clique sur le bouton OK
                    if (keycode == 13 || keycode==10)btn_ajoutNvelleCate.doClick();
                    //touche Echap préssée : on ferme la fenetre
                    if (keycode==27)dispose();
                }
            }
        );
       
        ConnexionBDRelaisFraternel("jdbc:mysql://localhost:3306/relaisf","root","password");    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        txtfield_ajoutNvelleCate = new javax.swing.JTextField();
        lbl_nvelleCate = new javax.swing.JLabel();
        btn_ajoutNvelleCate = new javax.swing.JButton();
        btn_retour = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter nouvelle catégorie");
        setResizable(false);

        txtfield_ajoutNvelleCate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lbl_nvelleCate.setText("Nouvelle catégorie :");

        btn_ajoutNvelleCate.setText("Ajouter");
        btn_ajoutNvelleCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ajoutNvelleCateActionPerformed(evt);
            }
        });

        btn_retour.setText("Retour");
        btn_retour.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lbl_nvelleCate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfield_ajoutNvelleCate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btn_retour)
                .addGap(49, 49, 49)
                .addComponent(btn_ajoutNvelleCate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfield_ajoutNvelleCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nvelleCate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ajoutNvelleCate)
                    .addComponent(btn_retour))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ajoutNvelleCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajoutNvelleCateActionPerformed
        String nvlleCate=(String) txtfield_ajoutNvelleCate.getText();
        
        Statement st;
        if(nvlleCate.equals("")==false){
            String query = "INSERT INTO categorie(nomCategorie) select '"+nvlleCate+"' "
                    + "where not exists (select * from categorie where nomCategorie='"+nvlleCate+"')"; //n'ajoute pas si elle exite deja
            
            try{
                st = con.createStatement();
                int nbModif=st.executeUpdate(query);
                System.out.println(nbModif+"Ajout nouvelle categorie");
                st.close();
            }catch(SQLException ex){
                Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur nouvelle categorie");//com
            }
        }else{
            FenetreErreur fe = new FenetreErreur("Vous n'avez rien saisie.");
            fe.setVisible(true); 
        }
        //modif NIRA 26/04
        fprincipale.updateComboCategorie();
        txtfield_ajoutNvelleCate.setText(null);
       
    }//GEN-LAST:event_btn_ajoutNvelleCateActionPerformed

    private void btn_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retourActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_retourActionPerformed
    
private void ConnexionBDRelaisFraternel(String url,String uname,String pass){
        
        try{
            //connexion a la BD
            this.con=DriverManager.getConnection(url,uname,pass);
            System.out.println("connexion bd OK");
        }catch(SQLException ex)
        {
            System.out.println("ERREURRR CONNEXION BD");
            System.out.println(ex);
        }
        
}
    

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreAjoutCategorie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FenetrePrincipale fpr=new FenetrePrincipale();
            new FenetreAjoutCategorie(fpr).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ajoutNvelleCate;
    private javax.swing.JButton btn_retour;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel lbl_nvelleCate;
    private javax.swing.JTextField txtfield_ajoutNvelleCate;
    // End of variables declaration//GEN-END:variables
}
