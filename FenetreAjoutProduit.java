import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.text.DefaultFormatter;

public class FenetreAjoutProduit extends javax.swing.JFrame {
    private Connection con;
    //modif NIRA 26/04 
    
    private int i=0;
    
    FenetrePrincipale fp;
    
    public FenetreAjoutProduit(FenetrePrincipale fp) {
        this.fp=fp;
        initComponents();
        ConnexionBDRelaisFraternel("jdbc:mysql://localhost:3306/relaisf","root","password");
        updateComboCategorieDansAjoutProduit();
        
        //Jspinner conditions
        JFormattedTextField field=((JSpinner.DefaultEditor)spinner_quantiteDAlerte.getEditor()).getTextField();
        ((DefaultFormatter)field.getFormatter()).setAllowsInvalid(false);
        
        this.setFocusable(true);
        this.requestFocus();
        
        txtField_nveauProduit.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keycode  = e.getKeyCode();             
                    //quand la touche Entrée est préssée on clique sur le bouton entrée
                    if (keycode == 13 || keycode==10)btn_entreeStock.doClick();
                    //quand la touche Echap est préssée la fenêtre se ferme
                    if (keycode==27)dispose();
                    //if(keycode==127)
                }
            }
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_cate = new javax.swing.JLabel();
        txtField_nveauProduit = new javax.swing.JTextField();
        lbl_nveauProduit = new javax.swing.JLabel();
        btn_entreeStock = new javax.swing.JButton();
        cmb_categorie = new javax.swing.JComboBox<>();
        lbl_qteDAlerte = new javax.swing.JLabel();
        spinner_quantiteDAlerte = new javax.swing.JSpinner();
        btn_retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter nouveau produit");
        setResizable(false);

        lbl_cate.setText("Catégorie :");

        lbl_nveauProduit.setText("Nouveau produit :");

        btn_entreeStock.setBackground(new java.awt.Color(51, 255, 51));
        btn_entreeStock.setFont(new java.awt.Font("Elephant", 1, 12)); // NOI18N
        btn_entreeStock.setText("Entrée en stock");
        btn_entreeStock.setMaximumSize(new java.awt.Dimension(113, 25));
        btn_entreeStock.setMinimumSize(new java.awt.Dimension(113, 25));
        btn_entreeStock.setPreferredSize(new java.awt.Dimension(113, 25));
        btn_entreeStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entreeStockActionPerformed(evt);
            }
        });

        cmb_categorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_categorieActionPerformed(evt);
            }
        });

        lbl_qteDAlerte.setText("Quantité d'alerte : ");

        spinner_quantiteDAlerte.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

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
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_retour, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(btn_entreeStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_qteDAlerte, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinner_quantiteDAlerte, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_cate)
                                    .addComponent(lbl_nveauProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtField_nveauProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_categorie, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_categorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cate))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtField_nveauProduit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nveauProduit))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_qteDAlerte)
                    .addComponent(spinner_quantiteDAlerte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_retour)
                    .addComponent(btn_entreeStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        //modif Nira 26/04 
    private void btn_entreeStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entreeStockActionPerformed
        Statement st ;
        ResultSet rs;
        
        String choixCategorie=(String) cmb_categorie.getSelectedItem();       
        String nomProduit=(String) txtField_nveauProduit.getText();
        int qtéAlerte= (int) spinner_quantiteDAlerte.getValue();
        int numCate=0;
        
        if(!"".equals(nomProduit) && choixCategorie!=null){               
            //ETAPE 1 : METTRE A JOUR LA TABLE STOCK
            String queryNumCate="SELECT numCategorie FROM categorie WHERE nomCategorie='"+choixCategorie+"'";           
            
            try {
                st = con.createStatement();
                rs=st.executeQuery(queryNumCate);
                rs.next();
                numCate=(int)rs.getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur entree stock nveau produit");//com
            }
            
            if(numCate!=0){
                String query="INSERT INTO stock(nomProduit,refCategorie,quantiteDAlerte,quantiteDisponible) VALUES('"+nomProduit+"',"+numCate+","+qtéAlerte+",0)";
                try {
                    st = con.createStatement();
                    int nbModif=st.executeUpdate(query);
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("erreur entree stock nouveau produit");//com
                }
            }else{
                FenetreErreur fe = new FenetreErreur();
                fe.setVisible(true); 
            }        
        }else{
            FenetreErreur fe = new FenetreErreur("Veuillez entrez des valeurs.");
            fe.setVisible(true); 
            System.out.println("ERREUR : CHOISIEZ CATEGORIE ET NOM DU PRODUIT");
        }
        
        //NOTE : on fait pas de modification dans la table enregistrement car imaginons ils savent qu'ils vont recevoir des nouveaux
        //produit, et qu'ils veulent deja creer l'espace de ce nouveau produit : dans le cas où dans cette methode y a modif de la table 
        //"enregistrement" on aura un pb (car ils ont pas encore recu le produit en soit; alors que "enregistrement" c'est pour enregistrer
        //les produits reçus. donc il est préférable de séparer "ajout nouveau produit" et "enregistrement" et initialisé ducoup quantité initial 
        //à 0.
        
        //update tableau Stock et Alerte dans l'interface
        fp.ajoutTableStock(fp.getJtabelStock());
        fp.ajoutTableAlerte(fp.getJtabelAlerte());
        
       
        cmb_categorie.setSelectedItem(null);       
        txtField_nveauProduit.setText(null);
        spinner_quantiteDAlerte.setValue(0);
        
    }//GEN-LAST:event_btn_entreeStockActionPerformed

    private void cmb_categorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_categorieActionPerformed
        System.out.println("i vaut "+i);
        if(i==0){
            cmb_categorie.setSelectedItem(null);
            i++;
        }
        else{
            String selected=(String) cmb_categorie.getSelectedItem();
            System.out.println("selected : "+selected);
        }
    }//GEN-LAST:event_cmb_categorieActionPerformed

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
    
    private void updateComboCategorieDansAjoutProduit(){
        cmb_categorie.removeAllItems();
        
        Statement st;
        ResultSet rs;
        
        String sql ="select * from categorie";
        try{
            st=this.con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                cmb_categorie.addItem(rs.getString("nomCategorie"));
            }
        }
        catch (SQLException ex){
            System.out.println("ERREURR UPDATECOMBOCATEGORIE");
            System.out.println(ex);
        }
        
        cmb_categorie.setSelectedItem(null);
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
            java.util.logging.Logger.getLogger(FenetreAjoutProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FenetrePrincipale fpr=new FenetrePrincipale();
            new FenetreAjoutProduit(fpr).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entreeStock;
    private javax.swing.JButton btn_retour;
    private javax.swing.JComboBox<String> cmb_categorie;
    private javax.swing.JLabel lbl_cate;
    private javax.swing.JLabel lbl_nveauProduit;
    private javax.swing.JLabel lbl_qteDAlerte;
    private javax.swing.JSpinner spinner_quantiteDAlerte;
    private javax.swing.JTextField txtField_nveauProduit;
    // End of variables declaration//GEN-END:variables
}
