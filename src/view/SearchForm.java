/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import POJOS.FavoriteList;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author rodius
 */
public class SearchForm extends javax.swing.JFrame {

    /**
     * Creates new form SearchForm
     */
    public SearchForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        searchButton.setEnabled(false);
        
        movieTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                onSelectRow();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        eMoviePUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("eMoviePU").createEntityManager();
        genreQuery = java.beans.Beans.isDesignTime() ? null : eMoviePUEntityManager.createQuery("SELECT g.name FROM Genre g");
        genreList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(genreQuery.getResultList());
        favoriteListQuery = java.beans.Beans.isDesignTime() ? null : eMoviePUEntityManager.createQuery("SELECT f FROM FavoriteList f");
        favoriteListList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(favoriteListQuery.getResultList());
        jPanel1 = new javax.swing.JPanel();
        genreCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        yearTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();
        listCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, genreList, genreCombo);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Επιλέξτε είδος:");

        jLabel2.setText("Επιλέξτε έτος κυκλοφορίας:");

        yearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yearTextFieldKeyReleased(evt);
            }
        });

        clearButton.setText("Καθαρισμός");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        searchButton.setText("Αναζήτηση");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton)
                    .addComponent(searchButton))
                .addGap(104, 104, 104))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clearButton, searchButton});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {genreCombo, yearTextField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(jLabel2)))
        );

        jScrollPane1.setViewportView(movieTable);

        listCombo.setRenderer((new DefaultListCellRenderer() {
          public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
              FavoriteList myObj = (FavoriteList) value;
              setText(myObj.getName());
            }
            return this;
        }}));

            jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteListList, listCombo);
            bindingGroup.addBinding(jComboBoxBinding);

            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jLabel3.setText("Επιλέξτε λίστα:");

            DeleteButton.setText("Διαγραφή από τη λίστα");
            DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    DeleteButtonMouseClicked(evt);
                }
            });
            DeleteButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DeleteButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(listCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeleteButton)))
                            .addGap(58, 58, 58))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeleteButton))
                    .addGap(35, 35, 35))
            );

            bindingGroup.bind();

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        // TODO add your handling code here:
        yearTextField.setText("");
        genreCombo.setSelectedIndex(0);
        searchButton.setEnabled(false);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Τίτλος ταινίας", "Βαθμολογία", "Περιγραφή"});
        movieTable.setModel(tableModel);
        
        System.out.println("clear");
    }//GEN-LAST:event_clearButtonMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        // TODO add your handling code here:
        String genre = genreCombo.getSelectedItem().toString();
        String year = yearTextField.getText();
        updateTableData(year, genre);
    }//GEN-LAST:event_searchButtonMouseClicked

    private void yearTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTextFieldKeyReleased
        setSearchButtonStatus();
    }//GEN-LAST:event_yearTextFieldKeyReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formWindowGainedFocus

    private void myListsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myListsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myListsComboBoxActionPerformed

    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButtonMouseClicked

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void setSearchButtonStatus(){
        if(yearTextField.getText().isEmpty()){
            searchButton.setEnabled(false); // Απενεργοποίηση της αναζήτησης όταν είναι άδειο το έτος
        }else {
            if(genreCombo.getSelectedIndex() > -1){
                searchButton.setEnabled(true);    
            }
        }
    }
    
    public void onSelectRow(){
       //get selected item
        // find if fav list id
        // if exists set combo box to this value
        // else set combo box to empty
       System.out.println(movieTable.getValueAt(movieTable.getSelectedRow(), 0).toString());
    }
    
    
   
    public void updateTableData(String year, String genreName){
        EntityManager em = mainUI.em;
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
 
        String dateInString = "1-Jan-" + year;
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        }
        catch(Exception e) {
           //TODO new prompt error message
        } 

        List<POJOS.Movie> movieList = em.createQuery("SELECT m FROM Movie m WHERE m.genreId.name = :genreName and m.releaseDate > :date")
                    .setParameter("genreName", genreName)
                    .setParameter("date", date)
                    .getResultList();
                      
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Τίτλος ταινίας", "Βαθμολογία", "Περιγραφή"});
        
        for (POJOS.Movie m : movieList) {
            tableModel.addRow(new String[]{m.getTitle(), m.getRating().toString(), m.getOverview()});
        }
        movieTable.setModel(tableModel);
    }
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton clearButton;
    private javax.persistence.EntityManager eMoviePUEntityManager;
    private java.util.List<POJOS.FavoriteList> favoriteListList;
    private javax.persistence.Query favoriteListQuery;
    private javax.swing.JComboBox genreCombo;
    private java.util.List<POJOS.Genre> genreList;
    private javax.persistence.Query genreQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listCombo;
    private javax.swing.JTable movieTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField yearTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
