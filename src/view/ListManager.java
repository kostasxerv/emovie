/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.FavoriteList;


/**
 *
 * @author rodius
 */
public class ListManager extends javax.swing.JFrame {
    /**
     * Creates new form ListManager
     */
    public ListManager() {
        initComponents();
        this.setLocationRelativeTo(null);
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

        em = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("eMoviePU").createEntityManager();
        favoriteListQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT f FROM FavoriteList f");
        favoriteListList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : favoriteListQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        CreateButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListOfLists = new javax.swing.JList<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        CreateButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CreateButton.setText("Δημιουργία");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EditButton.setText("επεξεργασία");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DeleteButton.setText("Διαγραφή");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteListList, ListOfLists);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        bindingGroup.addBinding(jListBinding);

        ListOfLists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListOfListsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListOfLists);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditButton)
                    .addComponent(CreateButton)
                    .addComponent(DeleteButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CreateButton, DeleteButton, EditButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(CreateButton)
                .addGap(18, 18, 18)
                .addComponent(EditButton)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int i = ListOfLists.getSelectedIndex();
        if(i == -1){
            return;
        }
        String name = ListOfLists.getModel().getElementAt(i);
        int result = JOptionPane.showConfirmDialog(null, "Διαγραφή της λίστας " + name,
                "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        System.out.println(result);
        if(result != 0){
            return;
        }
        EntityManager em = mainUI.em;
        em.getTransaction().begin();
        FavoriteList fl = em
                .createNamedQuery("FavoriteList.findByName", FavoriteList.class)
                .setParameter("name", name)
                .getSingleResult();
        if(fl == null){
            return;
        }     
        em.remove(fl);
        em.flush();
        em.getTransaction().commit();
        updateListData();
        System.out.println("Delete");
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        String listName = JOptionPane.showInputDialog("Δώσε το όνομα της λίστας:" );
        if(listName == null){
            return;
        }
        EntityManager em = mainUI.em; // Ο EntityManager

        em.getTransaction().begin(); //ξεκινάω μια καινούργια 

        model.FavoriteList newList = new model.FavoriteList();

        newList.setName(listName);    

        em.persist(newList);
        em.flush();
        em.getTransaction().commit(); //Αποθήκευση στη βάση των αλλαγών

        System.out.println("New List successfully created!");
        System.out.println(listName); 
        updateListData();
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int i = ListOfLists.getSelectedIndex();
        if(i == -1){
            return;
        }
        String name = ListOfLists.getModel().getElementAt(i);
        String newName = JOptionPane.showInputDialog("Δώσε το όνομα της λίστας:", name);
        if(newName == null){
            return;
        }
        em.getTransaction().begin();
        FavoriteList fl = em
                .createNamedQuery("FavoriteList.findByName", FavoriteList.class)
                .setParameter("name", name)
                .getSingleResult();
        if(fl == null){
            System.out.println("Not Found list");
            return;
        }
        FavoriteList editedFl = em.find(FavoriteList.class, fl.getId());
        editedFl.setName(newName);
        em.merge(editedFl);
        System.out.println(editedFl.getName());

        em.getTransaction().commit(); //Αποθήκευση στη βάση των αλλαγών
        System.out.println("List successfully updated!");
//        System.out.println(newName);
        updateListData();          
    }//GEN-LAST:event_EditButtonActionPerformed

    private void ListOfListsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListOfListsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ListOfListsMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        updateListData();
        System.out.println("in");
    }//GEN-LAST:event_formWindowGainedFocus
    
    public void updateListData(){
        EntityManager em = mainUI.em;
        em.getTransaction().begin();
        favoriteListList = em
                    .createNamedQuery("FavoriteList.findAll", FavoriteList.class)
                    .getResultList();
        em.getTransaction().commit();
        
        String[] arr = new String[favoriteListList.size()];

        for(int i = 0; i < favoriteListList.size(); i++){
            arr[i] = favoriteListList.get(i).getName();
            System.out.println(arr[i]);
        }
        ListOfLists.setListData(arr);
//        System.out.println(ListOfLists.getModel().getSize());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JList<String> ListOfLists;
    private javax.persistence.EntityManager em;
    private java.util.List<model.FavoriteList> favoriteListList;
    private javax.persistence.Query favoriteListQuery;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
