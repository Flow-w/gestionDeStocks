//Projet réalisé par :
//RAVIMOHAN Niraiksan
//PHILIPPE Florine
//MEHARI Fanuel 

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultFormatter;
import net.proteanit.sql.DbUtils;

//version 25/04
public final class FenetrePrincipale extends javax.swing.JFrame {
    
    private Connection con;    
    private int i=0; //compteur juste pour bien excétuer le cas 0

    public FenetrePrincipale() {
        //initialisation des compsants
        initComponents();
        
        //connexion à la Base de Données
        ConnexionBDRelaisFraternel("jdbc:mysql://localhost:3306/relaisf","root","password");
        
        //pour que la fenetre puisse écouter les key préssées
        this.setFocusable(true);
        this.requestFocus();
        
       
        //à compléter si besoin est
        //fenetre : keyListenner permettant d'effectuer des actions en fonctions des touches préssées
        this.addKeyListener(
        new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keycode  = e.getKeyCode();
                //si la touche "Echap"est préssée on ferme la fentre
                if (keycode == 27)System.exit(0);
            }
        });
        
        //ComboBox Catégorie : initialisation
        updateComboCategorie();
        
        //tables : intégration des tables SQL
        ajoutTableEnregistrement (tableEnregistrement);
        ajoutTableStock (tableStock);
        ajoutTableAlerte(tableAlerte);
        
        //empecher l'édition des tables : modif 26/04 FLO
        tableEnregistrement.setDefaultEditor(Object.class, null);
        tableStock.setDefaultEditor(Object.class, null);
        tableAlerte.setDefaultEditor(Object.class, null);
        
        //autorisation de la sélection multiple / MODIF 26/04 FLO
        tableEnregistrement.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tableStock.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tableAlerte.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        //interdiction de la reorganisation des colonnes 28/04
        tableEnregistrement.getTableHeader().setReorderingAllowed(false);
        tableStock.getTableHeader().setReorderingAllowed(false);
        tableAlerte.getTableHeader().setReorderingAllowed(false);
                
        //groupement des boutons 
        groupeBoutonsRecherche.add(boutonRechercheCategorie);
        groupeBoutonsRecherche.add(boutonRechercheProduit);
        groupeBoutonsRecherche.add(boutonRechercheDateEnregistrement);
        
        //backgroung color 
        getContentPane().setBackground(new Color(205, 226, 236));
    
       //boutons de recherche : initialisation des valeurs
       boutonRechercheCategorie.setActionCommand("categorie");
       boutonRechercheProduit.setActionCommand("produit");
       boutonRechercheDateEnregistrement.setActionCommand("enregistrement");

       //Jspinner conditions
        JFormattedTextField field=((JSpinner.DefaultEditor)choixQuantité.getEditor()).getTextField();
        ((DefaultFormatter)field.getFormatter()).setAllowsInvalid(false);
        
        //keyListenner permettant d'effectuer des recherches en fonctions des touches préssées
        //à compléter si besoin est
        rechercheTextField.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keycode  = e.getKeyCode();
                    //touche "entree" -> action rechercher
                    if (keycode == 13 || keycode==10)rechercheBouton.doClick();
                    //touche "Echap" -> action reset recherche
                    if (keycode==127)resetButon.doClick();
                }
            }
        );
       
        //on ferme la connection
        /*
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        groupeBoutonsRecherche = new javax.swing.ButtonGroup();
        bouttonSortieStock = new javax.swing.JButton();
        bouttonAjoutProduit = new javax.swing.JButton();
        deuxTables = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEnregistrement = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableStock = new javax.swing.JTable();
        bouttonAjoutCategorie = new javax.swing.JButton();
        labelCategorie = new javax.swing.JLabel();
        listeCategorie = new javax.swing.JComboBox<>();
        labelProduit = new javax.swing.JLabel();
        listeProduit = new javax.swing.JComboBox<>();
        labelQuantite = new javax.swing.JLabel();
        choixQuantité = new javax.swing.JSpinner();
        bouttonEntréeStock = new javax.swing.JButton();
        rechercheTextField = new javax.swing.JTextField();
        boutonRechercheCategorie = new javax.swing.JRadioButton();
        boutonRechercheProduit = new javax.swing.JRadioButton();
        boutonRechercheDateEnregistrement = new javax.swing.JRadioButton();
        titreGestionStocks = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAlerte = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        supprimerBouton = new javax.swing.JButton();
        boutonImprimer = new javax.swing.JButton();
        labelAlerte = new javax.swing.JLabel();
        provenanceTexte = new javax.swing.JTextField();
        labelProvenance = new javax.swing.JLabel();
        rechercheBouton = new javax.swing.JButton();
        resetButon = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion des stocks");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        bouttonSortieStock.setBackground(new java.awt.Color(255, 51, 51));
        bouttonSortieStock.setFont(new java.awt.Font("Elephant", 1, 12)); // NOI18N
        bouttonSortieStock.setForeground(new java.awt.Color(255, 255, 255));
        bouttonSortieStock.setText("Sortie de stock");
        bouttonSortieStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonSortieStockActionPerformed(evt);
            }
        });

        bouttonAjoutProduit.setText("+ Ajouter nouveau produit");
        bouttonAjoutProduit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bouttonAjoutProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonAjoutProduitActionPerformed(evt);
            }
        });

        deuxTables.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableEnregistrement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableEnregistrement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero Enregistrement", "Date Enregistrement", "Produit", "Stockage/Déstockage", "Quantité enregistrée"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableEnregistrement);
        tableEnregistrement.getAccessibleContext().setAccessibleName("tableEnregistrement");

        deuxTables.addTab("Enregistrement", jScrollPane1);

        tableStock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nom Produit", "Catégorie", "Quantité disponible en stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableStock);
        tableStock.getAccessibleContext().setAccessibleName("tableStock");

        deuxTables.addTab("Stock", jScrollPane3);

        bouttonAjoutCategorie.setText("+ Ajouter nouvelle catégorie ");
        bouttonAjoutCategorie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bouttonAjoutCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonAjoutCategorieActionPerformed(evt);
            }
        });

        labelCategorie.setText("Catégorie :");

        listeCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeCategorieActionPerformed(evt);
            }
        });

        labelProduit.setText("Produit : ");

        labelQuantite.setText("Quantité :");

        choixQuantité.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        bouttonEntréeStock.setBackground(new java.awt.Color(51, 255, 51));
        bouttonEntréeStock.setFont(new java.awt.Font("Elephant", 1, 12)); // NOI18N
        bouttonEntréeStock.setText("Entrée en stock");
        bouttonEntréeStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonEntréeStockActionPerformed(evt);
            }
        });

        boutonRechercheCategorie.setText("Catégorie");

        boutonRechercheProduit.setText("Produit");

        boutonRechercheDateEnregistrement.setText("Date enregistrement");

        titreGestionStocks.setBackground(new java.awt.Color(102, 153, 255));
        titreGestionStocks.setFont(new java.awt.Font("Yu Gothic UI", 1, 50)); // NOI18N
        titreGestionStocks.setForeground(new java.awt.Color(255, 255, 255));
        titreGestionStocks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titreGestionStocks.setText("GESTION DES STOCKS");
        titreGestionStocks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titreGestionStocks.setVerifyInputWhenFocusTarget(false);

        tableAlerte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableAlerte);

        jButton1.setText("Modifier");

        supprimerBouton.setText("Supprimer");
        supprimerBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerBoutonActionPerformed(evt);
            }
        });

        boutonImprimer.setText("Imprimer");
        boutonImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonImprimerActionPerformed(evt);
            }
        });

        labelAlerte.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        labelAlerte.setForeground(new java.awt.Color(255, 0, 0));
        labelAlerte.setText("Alertes disponibilités ");

        provenanceTexte.setText("Non renseigné");

        labelProvenance.setText("Provenance :");

        rechercheBouton.setText("rechercher");
        rechercheBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheBoutonActionPerformed(evt);
            }
        });

        resetButon.setText("Reset");
        resetButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boutonRechercheCategorie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boutonRechercheProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(boutonRechercheDateEnregistrement)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rechercheTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rechercheBouton, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetButon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(supprimerBouton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boutonImprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(listeProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(listeCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(labelQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelProvenance, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(provenanceTexte)
                                            .addComponent(choixQuantité, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bouttonEntréeStock, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(bouttonSortieStock, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bouttonAjoutCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bouttonAjoutProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(titreGestionStocks, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(labelAlerte, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(74, Short.MAX_VALUE))))
                    .addComponent(deuxTables)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(bouttonAjoutCategorie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bouttonAjoutProduit))
                            .addComponent(titreGestionStocks, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listeCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCategorie))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(listeProduit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelProduit))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(choixQuantité, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelQuantite)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bouttonSortieStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bouttonEntréeStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(provenanceTexte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelProvenance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boutonRechercheCategorie)
                            .addComponent(boutonRechercheProduit)
                            .addComponent(boutonRechercheDateEnregistrement)
                            .addComponent(rechercheTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rechercheBouton)
                            .addComponent(resetButon)
                            .addComponent(supprimerBouton)
                            .addComponent(boutonImprimer)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAlerte)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(deuxTables, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     //ouverture de la fenetre d'ajout de produits
    private void bouttonAjoutProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonAjoutProduitActionPerformed
        FenetreAjoutProduit fap = new FenetreAjoutProduit(this);
        fap.setVisible(true);    
    }//GEN-LAST:event_bouttonAjoutProduitActionPerformed

    
    //modfi nira 26/04
    private void bouttonAjoutCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonAjoutCategorieActionPerformed
        FenetreAjoutCategorie fac = new FenetreAjoutCategorie(this);
        fac.setVisible(true);   
    }//GEN-LAST:event_bouttonAjoutCategorieActionPerformed
    
    
    private void listeCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeCategorieActionPerformed
        System.out.println("i vaut "+i);
        if(i==0){
            listeCategorie.setSelectedItem(null);
            i++;
        }
        else{
            String selected=(String) listeCategorie.getSelectedItem();
            System.out.println("selected : "+selected);

            listeProduit.removeAllItems();
            updateComboProduit(selected);
            listeProduit.setSelectedItem(null);
        }
    }//GEN-LAST:event_listeCategorieActionPerformed

    //mofication 19/04/2022 Nira
    //entrée en stock des produits dans la base sql et sur l'interface
    private void bouttonEntréeStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonEntréeStockActionPerformed
        String nomProduit=(String) listeProduit.getSelectedItem();
        String provenance=(String)provenanceTexte.getText();
        
        if(nomProduit!=null){    
            int valeurQuantité= (int) choixQuantité.getValue();

            System.out.println("la valeur sur la litse deroulante : "+valeurQuantité);//com

            //ETAPE 1 : METTRE A JOUR LA TABLE STOCK
            String query="update stock set quantiteDisponible=quantiteDisponible+"+valeurQuantité+" where nomProduit='"+nomProduit+"'";
            try {
                Statement st = con.createStatement();
                int nbModif=st.executeUpdate(query);
                System.out.println("nb d'entree :"+nbModif);//com
            } catch (SQLException ex) {
                Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur3");//com
            }
            
            
            //ETAPE 2 : Mettre à  jour la table ENNREGISTREMENT
            String q2="insert into enregistrement(dateEnregistrement,nomProduit,entree,quantiteEnregistre,provenance) values (curdate(),'"+nomProduit+"','OUI',"+valeurQuantité+",'"+provenance+"')";

            try {
                Statement st = con.createStatement();
                int nbEnregi=st.executeUpdate(q2);
                System.out.println("nb enregistrement entree :"+nbEnregi);//com
            } catch (SQLException ex) {
                Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur3");//com
            }     
        }
        else{
            FenetreErreur fe = new FenetreErreur("Entrez un produit.");
            fe.setVisible(true); 
        } 
        
        //update des valeurs
        ajoutTableEnregistrement (tableEnregistrement);
        ajoutTableStock (tableStock);
        ajoutTableAlerte(tableAlerte);
    }//GEN-LAST:event_bouttonEntréeStockActionPerformed

    //mofication 19/04/2022 Nira
    //entrée en stock des produits dans la base sql et sur l'interface
    private void bouttonSortieStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonSortieStockActionPerformed
        String nomProduit =(String) listeProduit.getSelectedItem();   
        String provenance=(String)provenanceTexte.getText();
        
        if(nomProduit!=null){
            //ETAPE 1 : METTRE A JOUR LA TABLE STOCK
            int valeurQuantité=(int) choixQuantité.getValue();

            System.out.println("la valeur sur la litse deroulante : "+valeurQuantité);//com

            String query="update stock set quantiteDisponible=quantiteDisponible-"+valeurQuantité+" where nomProduit='"+nomProduit+"'";

            if(QuantitéProduitDejaDansStock()>0 && QuantitéProduitDejaDansStock()>=valeurQuantité){
                try {
                    Statement st = con.createStatement();
                    int nbModif=st.executeUpdate(query);
                    System.out.println("nb de sortie :"+nbModif);//com
                } catch (SQLException ex) {
                    Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("erreur3");//com
                }      

                //ETAPE 2 : Mettre à  jour la table ENNREGISTREMENT
                String q2="insert into enregistrement(dateEnregistrement,nomProduit,entree,quantiteEnregistre,provenance) values (curdate(),'"+nomProduit+"','NON',"+valeurQuantité+",'"+provenance+"')";

                try {
                    Statement st = con.createStatement();
                    int nbEnregi=st.executeUpdate(q2);
                    System.out.println("nb enregistrement sortie :"+nbEnregi);//com
                } catch (SQLException ex) {
                    Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("erreur3");//com
                }
            }
            else{
                FenetreErreur fe = new FenetreErreur("Attention quantitée stockée insuffiante.");
                fe.setVisible(true); 
            } 
        }    
        else{
            FenetreErreur fe = new FenetreErreur("Entrez un produit.");
            fe.setVisible(true); 
        } 
        
        //update des valeurs
        ajoutTableEnregistrement (tableEnregistrement);
        ajoutTableStock (tableStock);
        ajoutTableAlerte(tableAlerte);
    }//GEN-LAST:event_bouttonSortieStockActionPerformed

    //25/04 Flo
    //recherche de produits dans les différentes tables de la base (enregistrements et stocks)
    private void rechercheBoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheBoutonActionPerformed
      
      String recherche=null;
      if(groupeBoutonsRecherche.getSelection()!=null){  
        recherche = groupeBoutonsRecherche.getSelection().getActionCommand();
      }
      String query;
      Statement st;  
      ResultSet rs;     
      
      String textRecherche=(String) rechercheTextField.getText();

      if(!"".equals(textRecherche) && recherche!=null){
        if ("categorie".equals(recherche)){
            try{
            //recherche dans table Stock
            query="select nomProduit, nomCategorie, quantiteDAlerte, quantiteDisponible from stock as s inner join categorie as c on c.numCategorie=s.refCategorie where nomCategorie like '%"+textRecherche+"%'";         
            st=this.con.createStatement();
            rs=st.executeQuery(query);         
            tableStock.setModel(DbUtils.resultSetToTableModel(rs));
            
            //recherche dans table Enregistrement
            query="select enregistrement.* from enregistrement natural join (stock as s inner join categorie as c on c.numCategorie=s.refCategorie) where nomCategorie like '%"+textRecherche+"%'" ;
            st=this.con.createStatement();
            rs=st.executeQuery(query); 
            tableEnregistrement.setModel(DbUtils.resultSetToTableModel(rs));
            
          } catch(SQLException e) {
              System.out.println(e);
          }
        }
        if("produit".equals(recherche)){
            try{
                //recherche dans table Stock
              query="select nomProduit, nomCategorie, quantiteDAlerte, quantiteDisponible from stock as s inner join categorie as c on c.numCategorie=s.refCategorie where nomProduit like '%"+textRecherche+"%'";                        
              st=this.con.createStatement();
              rs=st.executeQuery(query);
              tableStock.setModel(DbUtils.resultSetToTableModel(rs));
                
                //recherche dans table Stock
              query="select enregistrement.* from enregistrement where nomProduit like '%"+textRecherche+"%'";
              st=this.con.createStatement();
              rs=st.executeQuery(query);
              tableEnregistrement.setModel(DbUtils.resultSetToTableModel(rs));
          } catch(SQLException e) {
              System.out.println(e);
          }                               
        }
        if("enregistrement".equals(recherche)){          
            try{
            query ="select enregistrement.* from enregistrement where dateEnregistrement like '%"+textRecherche+"%'";
            st=this.con.createStatement();
            rs=st.executeQuery(query);
            tableEnregistrement.setModel(DbUtils.resultSetToTableModel(rs));
            
            query="select distinct nomProduit, nomCategorie, quantiteDAlerte, quantiteDisponible from enregistrement natural join stock as s inner join categorie as c "
            + "on c.numCategorie=s.refCategorie where dateEnregistrement like '%"+textRecherche+"%'"
            + " group by nomProduit";
            st=this.con.createStatement();
            rs=st.executeQuery(query);
            tableStock.setModel(DbUtils.resultSetToTableModel(rs));
            
          } catch(SQLException e) {
              System.out.println(e);
          }
        }     
      } 
      else {
        ajoutTableEnregistrement (tableEnregistrement);
        ajoutTableStock (tableStock);
        if(recherche==null){
            FenetreErreur fe = new FenetreErreur("Selectionnez un bouton de recherche.");
            fe.setVisible(true);
        }
        if("".equals(textRecherche)){
            FenetreErreur fe = new FenetreErreur("Veuillez entrer votre recherche.");
            fe.setVisible(true); 
        }        
        
      }
    }//GEN-LAST:event_rechercheBoutonActionPerformed

    //réinitialisation de la recherche : text field et bouttons
    private void resetButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButonActionPerformed
        //réinitialisation des tables après recherche
        ajoutTableEnregistrement( tableEnregistrement);
        ajoutTableStock(tableStock);
        ajoutTableAlerte(tableAlerte);
        
        //réinitialisation du textField après recherche
        rechercheTextField.setText("");
        
        //aucun boutons visible sélectionné après recherche
        groupeBoutonsRecherche.clearSelection();      
    }//GEN-LAST:event_resetButonActionPerformed

    //déselectionne les lignes sélectionnées lorsque l'on clique ailleursque sur le tableau
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        tableEnregistrement.clearSelection();
        tableStock.clearSelection();
        tableAlerte.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    //bouton permettant de supprimer les lignes sélectionnées dans la table et dans la base SQL
    private void supprimerBoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerBoutonActionPerformed
        if (tableStock.getSelectedRowCount()==0){
            FenetreErreur fe= new FenetreErreur("Veuillez sélectionner des lignes à supprimer");
            fe.setVisible(true);
        }
        else{
            int retour = JOptionPane.showOptionDialog(null, "Voulez-vous vraiment supprimer un élément ?", "Erreur",
                     //JOptionPane yes no
                    JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,null, null, null);
            
            if (retour!=1){
                DefaultTableModel model = (DefaultTableModel) this.tableStock.getModel();
                int[] rows = tableStock.getSelectedRows();
                System.out.println("test "+rows[0]);
                String nomProduit;
                String query;

                for(i=0;i<rows.length;i++){
                    System.out.println(i);
                  //model.removeRow(rows[i]-i);
                  nomProduit=(String)model.getValueAt(rows[i], 0);
                  System.out.println("test "+nomProduit);

                  query="delete from stock where nomProduit='"+nomProduit+"'";

                  try {
                          Statement st = con.createStatement();
                          int nbModif=st.executeUpdate(query);
                          System.out.println("nb de suppression :"+nbModif);//com
                      } catch (SQLException ex) {
                          Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                          System.out.println("erreur3");//com
                      }   


                }
                ajoutTableStock(tableStock);
                ajoutTableAlerte(tableAlerte);
            }
        }
    }//GEN-LAST:event_supprimerBoutonActionPerformed

    private void boutonImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonImprimerActionPerformed
    if(tableEnregistrement.getSelectedRowCount()==0){

        MessageFormat headerEnregistrement = new MessageFormat("Liste des produits enregistrés :");
        //MessageFormat headerStock = new MessageFormat("Liste des produits en stock :");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");


        try{
            tableEnregistrement.print(JTable.PrintMode.NORMAL, headerEnregistrement, footer);
            //tableStock.print(JTable.PrintMode.NORMAL, headerStock, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Erreur d'impression", e.getMessage());
        }
       }
       else{
        MessageFormat headerEnregistrement = new MessageFormat("Liste des produits enregistrés :");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");   
        
        try {
            DefaultTableModel viewModel = (DefaultTableModel) tableEnregistrement.getModel();
            DefaultTableModel printModel = new DefaultTableModel(0, viewModel.getColumnCount());
            for (int row : tableEnregistrement.getSelectedRows()) {
                printModel.addRow(/*(Vector)*/ viewModel.getDataVector().get(row));
            }
            JTable toPrint = new JTable(printModel);
            toPrint.getColumnModel().getColumn(0).setHeaderValue("numEnregistrement");
            toPrint.getColumnModel().getColumn(1).setHeaderValue("dateEnregistrement");
            toPrint.getColumnModel().getColumn(2).setHeaderValue("nomProduit");
            toPrint.getColumnModel().getColumn(3).setHeaderValue("entree");
            toPrint.getColumnModel().getColumn(4).setHeaderValue("quantiteEnregistree");
            toPrint.getColumnModel().getColumn(5).setHeaderValue("provenance");
            toPrint.setSize(toPrint.getPreferredSize());
            JTableHeader tableHeader = toPrint.getTableHeader();
            tableHeader.setSize(tableHeader.getPreferredSize());
            toPrint.print(JTable.PrintMode.NORMAL, headerEnregistrement, footer);
         } catch (PrinterException e) {
             System.err.format("Erreur d'impression", e.getMessage());
         }
       }
    }//GEN-LAST:event_boutonImprimerActionPerformed
       
    //methode pour connecter la base de donnée 
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

    //methode pour récupérer la quantité disponible d'un produit déjà en stock
    private int QuantitéProduitDejaDansStock(){
        String produitSelected=(String) listeProduit.getSelectedItem();
        int quantitéStockProduit=-99999;
        
        Statement st;
        ResultSet rs;        
        
        String sql="select quantiteDisponible from stock where nomProduit='"+produitSelected+"'";
        try{
            st=this.con.createStatement();
            rs=st.executeQuery(sql);
            rs.next();
            quantitéStockProduit=rs.getInt(1);
            
        }
        catch (SQLException ex){
            System.out.println("ERREURR UPDATECOMBOCATEGORIE");
            System.out.println(ex);
        }
        return quantitéStockProduit;
    }   
    
    //update comboBox de categorie
    //intégration des champs dans le combobox catégorie
    // note: MODIFICATION NIRA 26/04 POUR FAIRE FONCTIONNER FAC LIE AVEC MAJ DU COMBO
    public void updateComboCategorie(){
        listeCategorie.removeAllItems();
        
        Statement st;
        ResultSet rs;
        
        String sql ="select * from categorie";
        try{
            st=this.con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                listeCategorie.addItem(rs.getString("nomCategorie"));
            }
        }
        catch (SQLException ex){
            System.out.println("ERREURR UPDATECOMBOCATEGORIE");
            System.out.println(ex);
        }
        
        listeCategorie.setSelectedItem(null);
    }
            
    //update comboBox de produit
    //intégration des champs de produits en fonction du champs sélectionné dans categorie
    private void updateComboProduit(String selected){
        Statement st;
        ResultSet rs;
        
        String sql ="select nomProduit from stock as s inner join categorie as c on c.numCategorie=s.refCategorie where nomCategorie='"+selected+"' order by nomProduit";
        try{
            st=this.con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                listeProduit.addItem(rs.getString("nomProduit"));
            }
        }
        catch (SQLException ex){
            System.out.println("ERREURR UPDATECOMBOPRODUIT");
            System.out.println(ex);
        }      
    }
        
    //réinitialisation de la table stock en fonction de la base sql
    public void ajoutTableStock (javax.swing.JTable jtable){
        PreparedStatement ps;
        ResultSet rs;
        
        String querry = "select nomProduit, nomCategorie, quantiteDAlerte, quantiteDisponible from stock "
                + "inner join categorie on numCategorie=refCategorie";
        try {
            ps=con.prepareStatement(querry);
            rs=ps.executeQuery();
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex){
            System.out.println("ERREURR UPDATECOMBOPRODUIT");
            System.out.println(ex);
        }   
    }
    
     //réinitialisation de la table enregistrement en fonction de la base sql
    private void ajoutTableEnregistrement (javax.swing.JTable jtable){
        PreparedStatement ps;
        ResultSet rs;
        
        String querry = "select * from enregistrement ";
        try {
            ps=con.prepareStatement(querry);
            rs=ps.executeQuery();
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex){
            System.out.println("ERREURR UPDATECOMBOPRODUIT");
            System.out.println(ex);
        }   
    }
        
    //réinitialisation de la table alerte en fonction de la base sql
    public void ajoutTableAlerte ( javax.swing.JTable jtable){
        PreparedStatement ps;
        ResultSet rs;
        
        String querry = "select s.nomProduit, s.quantiteDisponible, c.nomCategorie from stock s inner join categorie c on s.refCategorie=c.numCategorie where quantiteDisponible<=quantiteDAlerte";
        try {
            ps=con.prepareStatement(querry);
            rs=ps.executeQuery();
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex){
            System.out.println("ERREURR UPDATECOMBOPRODUIT");
            System.out.println(ex);
        }   
    }
    
    
    //Nira 05/01 méthode pour get Jtable
    public javax.swing.JTable getJtabelStock(){
        return tableStock;
    }
    
    public javax.swing.JTable getJtabelAlerte(){
        return tableAlerte;
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
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FenetrePrincipale().setVisible(true);
        });
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonImprimer;
    private javax.swing.JRadioButton boutonRechercheCategorie;
    private javax.swing.JRadioButton boutonRechercheDateEnregistrement;
    private javax.swing.JRadioButton boutonRechercheProduit;
    private javax.swing.JButton bouttonAjoutCategorie;
    private javax.swing.JButton bouttonAjoutProduit;
    private javax.swing.JButton bouttonEntréeStock;
    private javax.swing.JButton bouttonSortieStock;
    private javax.swing.JSpinner choixQuantité;
    private javax.swing.JTabbedPane deuxTables;
    private javax.swing.ButtonGroup groupeBoutonsRecherche;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAlerte;
    private javax.swing.JLabel labelCategorie;
    private javax.swing.JLabel labelProduit;
    private javax.swing.JLabel labelProvenance;
    private javax.swing.JLabel labelQuantite;
    private javax.swing.JComboBox<String> listeCategorie;
    private javax.swing.JComboBox<String> listeProduit;
    private javax.swing.JTextField provenanceTexte;
    private javax.swing.JButton rechercheBouton;
    private javax.swing.JTextField rechercheTextField;
    private javax.swing.JButton resetButon;
    private javax.swing.JButton supprimerBouton;
    private javax.swing.JTable tableAlerte;
    private javax.swing.JTable tableEnregistrement;
    private javax.swing.JTable tableStock;
    private javax.swing.JLabel titreGestionStocks;
    // End of variables declaration//GEN-END:variables
}
