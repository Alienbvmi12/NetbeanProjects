/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package nilaisiswa;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class Print extends javax.swing.JInternalFrame {

    /**
     * Creates new form Print
     */
    public Print() {
        initComponents();
        loadTahunAjaran();
        loadWakel();
    }
    
    private void loadWakel(){
        try{
            ResultSet rs = koneksi.read("select concat(nip, ' - ', nama) as wakel from walikelas");
            while(rs.next()){
                wakel.addItem(rs.getString("wakel"));
            }
        }
        catch(Exception ee){
            System.out.print(ee);
        }
    }
    
     private void loadTahunAjaran(){
        Integer index =  2010;
        tahunAjaran.removeAllItems();
        while(index < 2100){
            String th = index.toString() + " - " + Integer.toString(index + 1);
            tahunAjaran.addItem(th);
            index++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tingkat = new javax.swing.JComboBox<>();
        tahunAjaran = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        semester = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        siswa = new javax.swing.JTextField();
        wakel = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel5.setText("Tahun Ajaran");

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Print");

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Pilih Nis, tingkat, semester dan tahun ajaran");

        tingkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "XI", "XII", "XIII" }));

        tahunAjaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tahunAjaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunAjaranActionPerformed(evt);
            }
        });

        jLabel3.setText("NIS");

        jLabel4.setText("Tingkat");

        semester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ganjil", "Genap" }));
        semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });

        jLabel6.setText("Semester");

        siswa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                siswaKeyReleased(evt);
            }
        });

        wakel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wakelActionPerformed(evt);
            }
        });

        jLabel7.setText("Walikelas");

        jButton3.setText("New");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(tingkat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tahunAjaran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(semester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(siswa)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(wakel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(tingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(tahunAjaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wakel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Map<String, Object> parameters = new HashMap<>();
            ResultSet rs = koneksi.read("select nisn, id_siswa, nama, kelas.kelas from siswa,kelas where siswa.id_kelas=kelas.id_kelas and nis='"+siswa.getText()+"'");
            if(rs.next()){
                parameters.put("nis", siswa.getText() + "/" + rs.getString("nisn"));
                parameters.put("tingkat", tingkat.getSelectedItem().toString());
                parameters.put("tahun_ajaran", tahunAjaran.getSelectedItem().toString());
                parameters.put("semester", semester.getSelectedItem().toString());
                parameters.put("nama", rs.getString("nama"));
                parameters.put("id", rs.getInt("id_siswa"));
                parameters.put("wakel", wakel.getSelectedItem().toString().split("-")[1]);
                parameters.put("nip_wakel", "NIP. "+wakel.getSelectedItem().toString().split("-")[0]);
                parameters.put("kepsek", "DRS. AGUS RUKMANTARA. M.M");
                parameters.put("nip_kepsek", "NIP. 19650301200003100");
                parameters.put("kelas", tingkat.getSelectedItem().toString() + " " + rs.getString("kelas"));
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("print.jasper"), parameters, koneksi.getConnection());
                JasperViewer.viewReport(jp, false);
                JasperPrint jpa = JasperFillManager.fillReport(getClass().getResourceAsStream("printPage2.jasper"), parameters, koneksi.getConnection());
                JasperViewer.viewReport(jpa, false);
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Invalid NIS/not found");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tahunAjaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunAjaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunAjaranActionPerformed

    private void semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterActionPerformed

    private void siswaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_siswaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_siswaKeyReleased

    private void wakelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wakelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wakelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new NewWakel().show();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> semester;
    private javax.swing.JTextField siswa;
    private javax.swing.JComboBox<String> tahunAjaran;
    private javax.swing.JComboBox<String> tingkat;
    private javax.swing.JComboBox<String> wakel;
    // End of variables declaration//GEN-END:variables
}