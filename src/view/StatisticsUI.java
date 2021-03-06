/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import POJOS.Movie;
import controller.ApiController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodius
 */
public class StatisticsUI extends javax.swing.JFrame {

    /**
     * Creates new form StatisticsUI
     */
    EntityManager em = ApiController.em;
    public StatisticsUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        jPanel1.setFocusable(true);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{});
        topmoviesTable.setModel(tableModel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        top10Button = new javax.swing.JButton();
        topPerListButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        topmoviesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        top10Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        top10Button.setText("Οι Καλύτερες 10 Ταινίες");
        top10Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
        top10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                top10ButtonActionPerformed(evt);
            }
        });

        topPerListButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        topPerListButton.setText("Οι Καλύτερες Ταινίες ανά Λίστα");
        topPerListButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
        topPerListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topPerListButtonActionPerformed(evt);
            }
        });

        topmoviesTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
        topmoviesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(topmoviesTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(topPerListButton)
                            .addComponent(top10Button))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {top10Button, topPerListButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(top10Button)
                .addGap(18, 18, 18)
                .addComponent(topPerListButton)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void top10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_top10ButtonActionPerformed
        System.out.println("top 10 movies");
        topmoviesTable.setVisible(true);
        
        List <Movie> movieList = em.createNativeQuery("Select m.id, m.title, m.rating from Movie m order by rating DESC FETCH FIRST 10 ROWS ONLY", Movie.class).getResultList();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        
        if(movieList.size() == 0){
            tableModel.setColumnIdentifiers(new String[]{"Μήνυμα"});
            tableModel.addRow(new String[]{"Δεν βρέθηκαν ταινίες"});
        }else {
            tableModel.setColumnIdentifiers(new String[]{"Τίτλος ταινίας", "Βαθμολογία"});                
            for (Movie m : movieList) {
                tableModel.addRow(new String[]{m.getTitle(), m.getRating().toString()});
            }
        }
        
        
        topmoviesTable.setModel(tableModel);

    }//GEN-LAST:event_top10ButtonActionPerformed

    private void topPerListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topPerListButtonActionPerformed
        System.out.println("top movies per list");
        topmoviesTable.setVisible(true);
        
        List <Movie> movieList = em.createNativeQuery("select m.id, m.title from movie m where m.FAVORITE_LIST_ID is not null and m.rating = any\n" +
            "(select Max(M.RATING) from movie M where M.FAVORITE_LIST_ID = m.FAVORITE_LIST_ID group by M.FAVORITE_LIST_ID)", Movie.class).getResultList();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        
        if(movieList.size() == 0){                   
            tableModel.setColumnIdentifiers(new String[]{"Μήνυμα"});
            tableModel.addRow(new String[]{"Δεν βρέθηκε ταινία σε λίστα"});
        } else {
            tableModel.setColumnIdentifiers(new String[]{"Τίτλος ταινίας"});
            for (Movie m : movieList) {
                 tableModel.addRow(new String[]{m.getTitle()});
            } 
        }    
        
        topmoviesTable.setModel(tableModel);
    }//GEN-LAST:event_topPerListButtonActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // κρύβουμε τον πίνακα ώστε να μην φαίνονται μη ενημερωμένα δεδομένα
        topmoviesTable.setVisible(false);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{});
        topmoviesTable.setModel(tableModel);
    }//GEN-LAST:event_jPanel1FocusGained

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton top10Button;
    private javax.swing.JButton topPerListButton;
    private javax.swing.JTable topmoviesTable;
    // End of variables declaration//GEN-END:variables
}
