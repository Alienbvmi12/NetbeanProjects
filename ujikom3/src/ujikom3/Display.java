/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ujikom3;

/**
 *
 * @author Acer
 */
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Display extends javax.swing.JFrame {
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    DefaultTableModel  model = new DefaultTableModel ( );

    /**
     * Creates new form Display
     */
    public Display() {
        initComponents(); koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
         
             jTable1.setModel(model);
             model.addColumn("ID");
             model.addColumn("Spesifikasi");
             model.addColumn("Kategori");
             model.addColumn("Merk");
             model.addColumn("Qty");
             
             getData();
        
        
    }
    public void getData( ){

     try{
          
           String sql        = "Select * from utama ";
           ResultSet res   = stat.executeQuery(sql);

           //penelusuran baris pada tabel tblGaji dari database
           while(res.next ()){
                Object[ ] obj = new Object[5];
                obj[0] = res.getString("id_spec");
                obj[2] = res.getString("spec");
                obj[0] = res.getString("kategori");
                obj[0] = res.getString("merk");
                obj[0] = res.getString("qty");
                

                model.addRow(obj);
            }
      }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnlog = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnlog2 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        btnlog3 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        panelhome = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        panelbarang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USER");

        jPanel1.setBackground(new java.awt.Color(41, 128, 185));
        jPanel1.setPreferredSize(new java.awt.Dimension(664, 377));

        jPanel2.setBackground(new java.awt.Color(52, 152, 219));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/SMK.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVENTORY");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TJKT");

        btnlog.setBackground(new java.awt.Color(52, 152, 219));
        btnlog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout-16.png"))); // NOI18N
        jLabel4.setText("LOGOUT");

        javax.swing.GroupLayout btnlogLayout = new javax.swing.GroupLayout(btnlog);
        btnlog.setLayout(btnlogLayout);
        btnlogLayout.setHorizontalGroup(
            btnlogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnlogLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnlogLayout.setVerticalGroup(
            btnlogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnlogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnlog2.setBackground(new java.awt.Color(52, 152, 219));
        btnlog2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlog2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlog2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlog2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlog2MouseExited(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/home-3-16.png"))); // NOI18N
        jLabel107.setText("HOME");

        javax.swing.GroupLayout btnlog2Layout = new javax.swing.GroupLayout(btnlog2);
        btnlog2.setLayout(btnlog2Layout);
        btnlog2Layout.setHorizontalGroup(
            btnlog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnlog2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel107)
                .addGap(33, 33, 33))
        );
        btnlog2Layout.setVerticalGroup(
            btnlog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnlog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnlog3.setBackground(new java.awt.Color(52, 152, 219));
        btnlog3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlog3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlog3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlog3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlog3MouseExited(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/package-2-16.png"))); // NOI18N
        jLabel108.setText("BARANG");

        javax.swing.GroupLayout btnlog3Layout = new javax.swing.GroupLayout(btnlog3);
        btnlog3.setLayout(btnlog3Layout);
        btnlog3Layout.setHorizontalGroup(
            btnlog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnlog3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel108)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnlog3Layout.setVerticalGroup(
            btnlog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnlog3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel3)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnlog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlog3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlog2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(btnlog2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlog3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnlog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel3.setBackground(new java.awt.Color(41, 128, 185));
        panel3.setForeground(new java.awt.Color(255, 255, 255));
        panel3.setLayout(new java.awt.CardLayout());

        panelhome.setBackground(new java.awt.Color(41, 128, 185));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("WELCOME");

        jLabel104.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setText("INVENTORY");

        jLabel105.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("TO");

        jLabel106.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setText("TJKT");

        javax.swing.GroupLayout panelhomeLayout = new javax.swing.GroupLayout(panelhome);
        panelhome.setLayout(panelhomeLayout);
        panelhomeLayout.setHorizontalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhomeLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel106)
                    .addComponent(jLabel103)
                    .addComponent(jLabel105)
                    .addComponent(jLabel104))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        panelhomeLayout.setVerticalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhomeLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel103)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel105)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel106)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel104)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        panel3.add(panelhome, "card2");

        panelbarang.setBackground(new java.awt.Color(41, 128, 185));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panelbarangLayout = new javax.swing.GroupLayout(panelbarang);
        panelbarang.setLayout(panelbarangLayout);
        panelbarangLayout.setHorizontalGroup(
            panelbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbarangLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panelbarangLayout.setVerticalGroup(
            panelbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel3.add(panelbarang, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogMouseClicked
        this.dispose();
        mainmenu a = new mainmenu();
        a.setVisible(true);
    }//GEN-LAST:event_btnlogMouseClicked

    private void btnlogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogMouseEntered
        btnlog.setBackground(new Color (41,128,185));
    }//GEN-LAST:event_btnlogMouseEntered

    private void btnlogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogMouseExited
        btnlog.setBackground(new Color(52,152,219));
    }//GEN-LAST:event_btnlogMouseExited

    private void btnlog2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlog2MouseClicked
        panel3.removeAll();
        panel3.repaint();
        panel3.revalidate();

        panel3.add(panelhome);
        panel3.repaint();
        panel3.revalidate();
    }//GEN-LAST:event_btnlog2MouseClicked

    private void btnlog2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlog2MouseEntered
        btnlog2.setBackground(new Color (41,128,185));
    }//GEN-LAST:event_btnlog2MouseEntered

    private void btnlog2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlog2MouseExited
        btnlog2.setBackground(new Color(52,152,219));
    }//GEN-LAST:event_btnlog2MouseExited

    private void btnlog3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlog3MouseClicked
        panel3.removeAll();
        panel3.repaint();
        panel3.revalidate();

        panel3.add(panelbarang);
        panel3.repaint();
        panel3.revalidate();
    }//GEN-LAST:event_btnlog3MouseClicked

    private void btnlog3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlog3MouseEntered
        btnlog3.setBackground(new Color (41,128,185));
    }//GEN-LAST:event_btnlog3MouseEntered

    private void btnlog3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlog3MouseExited
        btnlog3.setBackground(new Color(52,152,219));
    }//GEN-LAST:event_btnlog3MouseExited

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnlog;
    private javax.swing.JPanel btnlog2;
    private javax.swing.JPanel btnlog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panelbarang;
    private javax.swing.JPanel panelhome;
    // End of variables declaration//GEN-END:variables
}