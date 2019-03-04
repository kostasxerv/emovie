/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import POJOS.FavoriteList;
import POJOS.Genre;
import POJOS.Movie;
import controller.ApiController;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author rodius
 */
public class SearchForm extends javax.swing.JFrame {
    EntityManager em = ApiController.em;

    /**
     * Creates new form SearchForm
     */
    public SearchForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        setInitialComponentsState();
 
        movieTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if(movieTable.getSelectedRowCount() == 0) return;
                onSelectRow();
            }
        });
        
        class FavoriteListRenderer extends BasicComboBoxRenderer {
            public Component getListCellRendererComponent(
                JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof FavoriteList)
                {
                    FavoriteList foo = (FavoriteList)value;
                    setText( foo.getName() );
                }
                return this;
            }}
        listCombo.setRenderer(new FavoriteListRenderer());
        
        class GenreRenderer extends BasicComboBoxRenderer {
            public Component getListCellRendererComponent(
                JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof Genre)
                {
                    Genre foo = (Genre)value;
                    setText( foo.getName() );
                }
                return this;
            }}
        genreCombo.setRenderer(new GenreRenderer());        
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

        genreQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT g FROM Genre g");
        genreList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(genreQuery.getResultList());
        favoriteListQuery = java.beans.Beans.isDesignTime() ? null : em     .createQuery("SELECT f FROM FavoriteList f");
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
        setBackground(new java.awt.Color(102, 102, 102));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        genreCombo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, genreList, genreCombo);
        bindingGroup.addBinding(jComboBoxBinding);

        genreCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreComboActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Επιλέξτε είδος:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Επιλέξτε έτος κυκλοφορίας:");

        yearTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
        yearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yearTextFieldKeyReleased(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gui/search.clear.png"))); // NOI18N
        clearButton.setText("Καθαρισμός Κριτηρίων");
        clearButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gui/search.srch.png"))); // NOI18N
        searchButton.setText("Αναζήτηση");
        searchButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));

        movieTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
        jScrollPane1.setViewportView(movieTable);

        listCombo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteListList, listCombo);
        bindingGroup.addBinding(jComboBoxBinding);

        listCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listComboMouseClicked(evt);
            }
        });
        listCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listComboActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Επιλέξτε λίστα:");

        DeleteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gui/search.delete.png"))); // NOI18N
        DeleteButton.setText("Διαγραφή από τη λίστα");
        DeleteButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(listCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genreCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearButton)
                            .addComponent(searchButton))))
                .addGap(27, 27, 27))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DeleteButton, clearButton, searchButton});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {genreCombo, listCombo, yearTextField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(searchButton))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {genreCombo, jLabel1, jLabel2, yearTextField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        // TODO add your handling code here:
        setInitialComponentsState();
    }//GEN-LAST:event_clearButtonMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        // TODO add your handling code here:
        if(searchButton.isEnabled() == false){
           JOptionPane.showMessageDialog(null,"Εισάγετε στοιχεία και στα δύο πεδία αναζήτησης");
           return;
        }
        String genre = genreCombo.getSelectedItem().toString();
        String year = yearTextField.getText();
        updateTableData(year, genre);
    }//GEN-LAST:event_searchButtonMouseClicked

    private void yearTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTextFieldKeyReleased
        setSearchButtonStatus();
    }//GEN-LAST:event_yearTextFieldKeyReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
       // TODO add your handling code here:
       genreList = genreQuery.getResultList();
       if(genreList.size() > 0){
            List<String> gelist = new ArrayList<String>();
            for(Genre g: genreList){
                gelist.add(g.getName());
            }
            DefaultComboBoxModel gemodel = new DefaultComboBoxModel(gelist.toArray());
            genreCombo.setModel(gemodel);
       }
        

       favoriteListList = favoriteListQuery.getResultList();
       if(favoriteListList.size() > 0) {
        List<String> flist = new ArrayList<String>();
        for(FavoriteList g: favoriteListList){
            flist.add(g.getName());
        }
        DefaultComboBoxModel limodel = new DefaultComboBoxModel(flist.toArray());
        listCombo.setModel(limodel);
       }
       
       setInitialComponentsState();
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void myListsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myListsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myListsComboBoxActionPerformed

    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButtonMouseClicked

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        if(listCombo.getSelectedIndex() == -1){
            return;
        }

       Integer id = Integer.parseInt(movieTable.getModel().getValueAt(movieTable.getSelectedRow(), 3).toString());
        
        Movie m = em
                .createNamedQuery("Movie.findById", Movie.class)
                .setParameter("id", id)
                .getSingleResult();

        em.getTransaction().begin();
        m.setFavoriteListId(null);
        em.persist(m);
        em.getTransaction().commit();
        
        listCombo.setSelectedIndex(-1);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void listComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listComboActionPerformed
        if(listCombo.getSelectedIndex() == -1){
            return;
        }
        
        if(movieTable.getModel().getRowCount() == 0){
            return;
        }
        
       Integer id = Integer.parseInt(movieTable.getModel().getValueAt(movieTable.getSelectedRow(), 3).toString());
        
        String name = (String)listCombo.getSelectedItem();
        
        
        FavoriteList fl = em
                .createNamedQuery("FavoriteList.findByName", FavoriteList.class)
                .setParameter("name", name)
                .getSingleResult();

        Movie m = em
                .createNamedQuery("Movie.findById", Movie.class)
                .setParameter("id", id)
                .getSingleResult();

        em.getTransaction().begin();
        m.setFavoriteListId(fl);
        em.persist(m);
        em.getTransaction().commit();
        
        if(id != null){
            System.out.println("Add " +  m.getTitle() + " in the list " + fl.getName() );
        }
        DeleteButton.setEnabled(true);
    }//GEN-LAST:event_listComboActionPerformed

    private void listComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listComboMouseClicked

    private void genreComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreComboActionPerformed
        // TODO add your handling code here:
       setSearchButtonStatus();
    }//GEN-LAST:event_genreComboActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

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
       DeleteButton.setEnabled(false);
        
       Integer id = Integer.parseInt(movieTable.getModel().getValueAt(movieTable.getSelectedRow(), 3).toString());
       
       System.out.println("Selected movie: " + id);
       Movie m = em
               .createNamedQuery("Movie.findById", Movie.class)
               .setParameter("id", id)
               .getSingleResult();
       
       listCombo.setEnabled(true);
       
       if(m.getFavoriteListId() != null){
           FavoriteList fl = m.getFavoriteListId();
           setSelectedList(fl);
           DeleteButton.setEnabled(true);
       }else {
           listCombo.setSelectedIndex(-1);
       }
       
    }
    
    public void setSelectedList(FavoriteList fl){
        listCombo.setEnabled(true);
        listCombo.setSelectedItem(fl.getName());
    }
    
   
    public void updateTableData(String year, String genreName){
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            
        Date date = null;
        try {
            if(Integer.parseInt(year) > 2100){
                throw new Exception("Εισάγετε μία έγκυρη χρονολογία");
            }
            String dateInString = "1-Jan-" + year;
            date = formatter.parse(dateInString);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 

        List<POJOS.Movie> movieList = em
                    .createQuery("SELECT m FROM Movie m WHERE m.genreId.name = :genreName and m.releaseDate >= :date")
                    .setParameter("genreName", genreName)
                    .setParameter("date", date)
                    .getResultList();
                      
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{ "Τίτλος ταινίας", "Βαθμολογία", "Περιγραφή", "Id" });
        movieTable.setModel(tableModel);
        movieTable.removeColumn(movieTable.getColumnModel().getColumn(3));

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
        sorter.setSortable(0, false);
        sorter.setSortable(2, false);
        movieTable.setRowSorter(sorter);
        
        for (POJOS.Movie m : movieList) {
            tableModel.addRow(new String[]{ m.getTitle(), m.getRating().toString(), m.getOverview(), m.getId().toString()});
        }
        
    }
    
     public void setInitialComponentsState(){
        yearTextField.setText("");

        searchButton.setEnabled(false);
        listCombo.setEnabled(false);
        DeleteButton.setEnabled(false);
        
        genreCombo.setSelectedIndex(-1);
        listCombo.setSelectedIndex(-1);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Τίτλος ταινίας", "Βαθμολογία", "Περιγραφή"});
        movieTable.setRowSorter(null);
        movieTable.setModel(tableModel);
        
    }
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton clearButton;
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
