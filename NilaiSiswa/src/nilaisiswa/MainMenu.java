/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nilaisiswa;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Any;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class MainMenu extends javax.swing.JFrame {
    
    private String id_nilai;
    private long start;
    private long end;
    private boolean type = false;
    private Integer page = 1;

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        loadTb();
        loadMapel();
        loadJenisNilai();
        loadTahunAjaran();
        loadKelompokPenilaian();
    }
    
    
    private void loadTahunAjaran(){
        Integer index =  2020;
        tahun_ajaran.removeAllItems();
        while(index < 2100){
            String th = index.toString() + " - " + Integer.toString(index + 1);
            tahun_ajaran.addItem(th);
            tahunAjaranTampil.addItem(th);
            index++;
        }
    }
    
    private void loadKelompokPenilaian(){
        try{
            ResultSet rs = koneksi.read("select concat(id_kelompok, '. ', kelompok) as kelaz from kelompok_mapel");
            while(rs.next()){
                kelompokPenilaian.addItem(rs.getString("kelaz"));
            }
        }
        catch(Exception ee){
            System.out.print(ee);
        }
    }
    
    private void loadSiswa(){
        try{
            ResultSet rs = koneksi.read("select concat(siswa.nis, ' - ', siswa.nama, ' - ', kelas.kelas) as kelaz from siswa, kelas where kelas.id_kelas=siswa.id_kelas and (siswa.nis like '%"+src.getText()+"%' or siswa.nama like '%"+src.getText()+"%' or kelas.kelas like '%"+src.getText()+"%')");
            nisnamakelas.removeAllItems();
            while(rs.next()){
                nisnamakelas.addItem(rs.getString("kelaz"));
            }
        }
        catch(Exception ee){
            System.out.print(ee);
        }
    }
    
    private void setStart(){
        start = System.currentTimeMillis();
    }
    
    private void setEnd(){
        end = System.currentTimeMillis();
    }
    
    private void timeTook(){
        took.setText("Query success, time took : "+((end-start)/10000));
    }
    
    private void loadMapel(){
        try{
            ResultSet rs = koneksi.read("select concat(id_mapel, ' - ', mapel) as kelaz from mapel");
            mapel.removeAllItems();
            while(rs.next()){
                mapel.addItem(rs.getString("kelaz"));
            }
        }
        catch(Exception ee){
            
        }
    }
    private void loadJenisNilai(){
        setStart();
        try{
            ResultSet rs = koneksi.read("select concat(id_jenis, ' - ', penilaian) as kelaz from jenis_nilai");
            jenis_nilai.removeAllItems();
            while(rs.next()){
                jenis_nilai.addItem(rs.getString("kelaz"));
            }
        }
        catch(Exception ee){
            
        }
        setEnd();
        timeTook();
    }
    
    
    private void loadTb(){
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Id Nilai");
        tm.addColumn("Nis");
        tm.addColumn("Nama");
        tm.addColumn("Tingkat");
        tm.addColumn("Kelas");
        tm.addColumn("Mapel");
        tm.addColumn("Nilai");
        tm.addColumn("Jenis Nilai");
        tm.addColumn("Tahun Ajaran");
        tm.addColumn("Semester");
        
        try {
            setStart();
            String sql;
            String th = "", smt = "", kel = "", ting = "", sis = "";
            if(nisnamakelas.getSelectedItem() != "Nis - Nama - Kelas"){
                String[] datSis = nisnamakelas.getSelectedItem().toString().split("-");
                sis = "siswa.nis='"+datSis[0]+"'";
            }
            if(tahunAjaranTampil.getSelectedIndex() != 0){
                th = "nilai.tahun_ajaran='"+tahunAjaranTampil.getSelectedItem()+"'";
            }
            if(kelompokPenilaian.getSelectedIndex() != 0){
                kel = "mapel.kelompok='"+kelompokPenilaian.getSelectedItem().toString().split("\\.")[0]+"'";
            }
            if(smta.getSelectedIndex() != 0){
                smt = "nilai.semester='"+smta.getSelectedItem()+"'";
            }
            if(tingat.getSelectedIndex() != 0){
                ting = "nilai.tingkat='"+tingat.getSelectedItem()+"'";
            }
            if(type){
                sql = "select nilai.id_nilai, siswa.nis as nis, siswa.nama as nama, nilai.tingkat as tingkat,"
                        + " kelas.kelas as kelas, mapel.mapel as mapel, jenis_nilai.penilaian as jenis_nilai, nilai.nilai as nilai,"
                        + " nilai.tahun_ajaran as tahun_ajaran, nilai.semester as semester from nilai, siswa, jenis_nilai, kelas, mapel "
                        + "where (siswa.id_siswa=nilai.id_siswa and siswa.id_kelas=kelas.id_kelas and mapel.id_mapel=nilai.id_mapel and"
                        + " jenis_nilai.id_jenis=nilai.id_jenis) and"
                        + " ("+sis+" and "+th+" and "+kel+" and "+smt+" and "+ting+")"
                        + " and (siswa.nama like '%"+src.getText()+"%' or nilai.id_nilai like '%"+search.getText()+"%' or siswa.nama "
                        + "like '%"+search.getText()+"%' or siswa.nis like '%"+search.getText()+"%' or nilai.tingkat "
                        + "like '%"+search.getText()+"%' or kelas.kelas like '%"+search.getText()+"%' or mapel.mapel "
                        + "like '%"+search.getText()+"%' or nilai.nilai like '%"+search.getText()+"%' or jenis_nilai.penilaian "
                        + "like '%"+search.getText()+"%' or nilai.tahun_ajaran like '%"+search.getText()+"%' or nilai.semester like '%"+search.getText()+"%') limit "+(page-1)*9+",9";
            }
            else{
                sql = "select nilai.id_nilai, siswa.nis as nis, siswa.nama as nama, nilai.tingkat as tingkat,"
                        + " kelas.kelas as kelas, mapel.mapel as mapel, jenis_nilai.penilaian as jenis_nilai, nilai.nilai as nilai,"
                        + " nilai.tahun_ajaran as tahun_ajaran, nilai.semester as semester from nilai, siswa, jenis_nilai, kelas, mapel "
                        + "where (siswa.id_siswa=nilai.id_siswa and siswa.id_kelas=kelas.id_kelas and mapel.id_mapel=nilai.id_mapel and"
                        + " jenis_nilai.id_jenis=nilai.id_jenis)"
                        + " and (siswa.nama like '%"+search.getText()+"%' or nilai.id_nilai like '%"+search.getText()+"%' or siswa.nama "
                        + "like '%"+search.getText()+"%' or siswa.nis like '%"+search.getText()+"%' or nilai.tingkat "
                        + "like '%"+search.getText()+"%' or kelas.kelas like '%"+search.getText()+"%' or mapel.mapel "
                        + "like '%"+search.getText()+"%' or nilai.nilai like '%"+search.getText()+"%' or jenis_nilai.penilaian "
                        + "like '%"+search.getText()+"%' or nilai.tahun_ajaran like '%"+search.getText()+"%' or nilai.semester like '%"+search.getText()+"%') limit "+(page-1)*9+",9";
            }
            ResultSet rs = koneksi.read(sql);
            while (rs.next()) {
                tm.addRow(new Object[]{
                    rs.getString("id_nilai"),
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("tingkat"),
                    rs.getString("kelas"),
                    rs.getString("mapel"),
                    rs.getString("nilai"),
                    rs.getString("jenis_nilai"),
                    rs.getString("tahun_ajaran"),
                    rs.getString("semester")
                });
            }
            setEnd();
            timeTook();
        jTable2.setModel(tm);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void search(){
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Id Nilai");
        tm.addColumn("Nis");
        tm.addColumn("Nama");
        tm.addColumn("Tingkat");
        tm.addColumn("Kelas");
        tm.addColumn("Mapel");
        tm.addColumn("Nilai");
        tm.addColumn("Jenis Nilai");
        tm.addColumn("Tahun Ajaran");
        tm.addColumn("Semester");
        
        try {
            setStart();
            ResultSet rs = koneksi.read("select nilai.id_nilai, siswa.nis as nis, siswa.nama as nama, nilai.tingkat as tingkat, kelas.kelas as kelas, mapel.mapel as mapel, jenis_nilai.penilaian as jenis_nilai, nilai.nilai as nilai, nilai.tahun_ajaran as tahun_ajaran, nilai.semester as semester from nilai, siswa, jenis_nilai, kelas, mapel where (siswa.id_siswa=nilai.id_siswa and siswa.id_kelas=kelas.id_kelas and mapel.id_mapel=nilai.id_mapel and jenis_nilai.id_jenis=nilai.id_jenis) and (siswa.nama like '%"+src.getText()+"%' or nilai.id_nilai like '%"+src.getText()+"%' or siswa.nama like '%"+src.getText()+"%' or siswa.nis like '%"+src.getText()+"%' or nilai.tingkat like '%"+src.getText()+"%' or kelas.kelas like '%"+src.getText()+"%' or mapel.mapel like '%"+src.getText()+"%' or nilai.nilai like '%"+src.getText()+"%' or jenis_nilai.penilaian like '%"+src.getText()+"%' or nilai.tahun_ajaran like '%"+src.getText()+"%' or nilai.semester like '%"+src.getText()+"%')");
            while (rs.next()) {
                tm.addRow(new Object[]{
                    rs.getString("id_nilai"),
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("tingkat"),
                    rs.getString("kelas"),
                    rs.getString("mapel"),
                    rs.getString("nilai"),
                    rs.getString("jenis_nilai"),
                    rs.getString("tahun_ajaran"),
                    rs.getString("semester")
                });
            }
            setEnd();
        timeTook();
        jTable2.setModel(tm);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void insert(){
        try{
            setStart();
            ResultSet rs = koneksi.read("select id_siswa from siswa where nis='" + nis.getText() + "'");
            if(rs.next()){
                koneksi.post("insert into nilai (id_siswa, id_jenis, nilai, id_mapel, tingkat, tahun_ajaran, semester)values ("
                        + "'"+rs.getString("id_siswa")+"',"
                        + "'"+jenis_nilai.getSelectedItem().toString().split("-", 0)[0]+"',"
                        + "'"+nilai.getText()+"',"
                        + "'"+mapel.getSelectedItem().toString().split("-", 0)[0]+"',"
                        + "'"+tingkat.getSelectedItem().toString()+"',"
                        + "'"+tahun_ajaran.getSelectedItem().toString()+"',"
                        + "'"+semester.getSelectedItem().toString()+"')");
                JOptionPane.showMessageDialog(null,"Berhasil tambah!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid NIS/not found");
            }
            setEnd();
        timeTook();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
      private void edit(){
        try{
            setStart();
            ResultSet rs = koneksi.read("select id_siswa from siswa where nis='" + nis.getText() + "'");
            if(rs.next()){
                koneksi.post("update nilai set "
                        + "id_siswa='"+rs.getString("id_siswa")+"',"
                        + "id_jenis='"+jenis_nilai.getSelectedItem().toString().split("-", 0)[0]+"',"
                        + "nilai='"+nilai.getText()+"',"
                        + "id_mapel='"+mapel.getSelectedItem().toString().split("-", 0)[0]+"',"
                        + "tingkat='"+tingkat.getSelectedItem().toString()+"',"
                        + "tahun_ajaran='"+tahun_ajaran.getSelectedItem().toString()+"',"
                        + "semester='"+semester.getSelectedItem().toString()+"' where id_nilai='"+id_nilai+"'");
                JOptionPane.showMessageDialog(null,"Berhasil edit!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid NIS");
            }
            setEnd();
        timeTook();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
     private void hapus(){
        try{
            setStart();
            koneksi.post("delete from nilai where id_nilai='"+id_nilai+"'");
            JOptionPane.showMessageDialog(null,"Berhasil hapus!!");
            setEnd();
        timeTook();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
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
        took = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        nama = new javax.swing.JTextField();
        nis = new javax.swing.JTextField();
        mapel = new javax.swing.JComboBox<>();
        jenis_nilai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        showPage = new javax.swing.JLabel();
        nilai = new javax.swing.JTextField();
        tahun_ajaran = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tingkat = new javax.swing.JComboBox<>();
        src = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kelas = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        semester = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        tingat = new javax.swing.JComboBox<>();
        smta = new javax.swing.JComboBox<>();
        tahunAjaranTampil = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        nisnamakelas = new javax.swing.JComboBox<>();
        search = new javax.swing.JTextField();
        kelompokPenilaian = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        nama.setEditable(false);
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nisActionPerformed(evt);
            }
        });
        nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nisKeyReleased(evt);
            }
        });

        mapel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jenis_nilai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("NIS");

        jLabel2.setText("Nama");

        jLabel3.setText("Tingkat/Kelas");

        jLabel4.setText("Mapel");

        jLabel5.setText("Jenis Nilai");

        showPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showPage.setText("1");

        nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nilaiActionPerformed(evt);
            }
        });

        tahun_ajaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Tahun ajaran");

        tingkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "XI", "XII", "XIII" }));

        src.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcActionPerformed(evt);
            }
        });
        src.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srcKeyReleased(evt);
            }
        });

        jLabel7.setText("Search");

        kelas.setEditable(false);
        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        semester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ganjil", "Genap" }));

        jLabel10.setText("Semester");

        tingat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tingkat", "X", "XI", "XII", "XIII" }));

        smta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Semester--", "Ganjil", "Genap" }));

        tahunAjaranTampil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Tahun Ajaran--" }));

        jCheckBox1.setText("Tampilkan Berdasarkan");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        nisnamakelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nis - Nama - Kelas" }));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        kelompokPenilaian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Kelompok Penilaian--" }));

        jButton7.setText("Load");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("/\\");
            jButton8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton8ActionPerformed(evt);
                }
            });

            jButton9.setText("\\/");
            jButton9.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton9ActionPerformed(evt);
                }
            });

            jLabel9.setText("Nilai");

            jLabel11.setText("Src siswa");

            jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(nama, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(nis, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(mapel, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jenis_nilai, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(showPage, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(nilai, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(tahun_ajaran, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(tingkat, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(src, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(kelas, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(semester, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(tingat, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(smta, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(tahunAjaranTampil, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jCheckBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(nisnamakelas, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(search, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(kelompokPenilaian, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

            javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
            jDesktopPane1.setLayout(jDesktopPane1Layout);
            jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nisnamakelas, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(kelompokPenilaian, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tingat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(tahunAjaranTampil, 0, 174, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(smta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(0, 62, Short.MAX_VALUE)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel3)
                                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2)
                                                .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1)
                                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                    .addComponent(tingkat, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(kelas)))
                                            .addComponent(semester, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel10))
                                    .addGap(37, 37, 37)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mapel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jenis_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel9))
                                    .addGap(47, 47, 47)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(showPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(3, 3, 3)))
                    .addContainerGap())
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap(532, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)))
            );
            jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4))
                    .addGap(7, 7, 7)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(mapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jenis_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(6, 6, 6))
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(jLabel10))
                    .addGap(7, 7, 7)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jButton8)
                            .addGap(18, 18, 18)
                            .addComponent(showPage)
                            .addGap(18, 18, 18)
                            .addComponent(jButton9)
                            .addGap(79, 79, 79)))
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(smta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tahunAjaranTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1)
                        .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nisnamakelas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kelompokPenilaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tingat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7))
                    .addGap(0, 15, Short.MAX_VALUE))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(279, Short.MAX_VALUE)))
            );

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(took, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jDesktopPane1)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(305, 305, 305)
                    .addComponent(took, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jMenu1.setText("Navigation");

            jMenuItem2.setText("Data Siswa");
            jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem2ActionPerformed(evt);
                }
            });
            jMenu1.add(jMenuItem2);

            jMenuBar1.add(jMenu1);

            jMenu2.setText("Account");

            jMenuItem1.setText("Logout");
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem1ActionPerformed(evt);
                }
            });
            jMenu2.add(jMenuItem1);

            jMenuBar1.add(jMenu2);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        new Login().show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        Print cetakDialog = new Print();
        jDesktopPane1.add(cetakDialog);
        cetakDialog.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTable2.removeAll();
        loadTb();
        loadMapel();
        loadJenisNilai();
        loadTahunAjaran();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        nis.setText("");
        nama.setText("");
        nilai.setText("0");
        id_nilai = "";
        kelas.setText("");
        DefaultTableModel tm = new DefaultTableModel();
        jTable2.setModel(tm);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(id_nilai != ""){
            hapus();
            loadTb();
            id_nilai = "";
        }
        else{
            JOptionPane.showMessageDialog(null,"Mohon pihih data yang valid!!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(id_nilai != ""){
            edit();
            loadTb();
            id_nilai = "";
        }
        else{
            JOptionPane.showMessageDialog(null,"Mohon pihih data yang valid!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if((nis.getText() != "" && nama.getText() != "" && nilai.getText() != "") && (nis.getText().length() > 2 && nama.getText().length() > 2)){
            insert();
            loadTb();
        }
        else{
            JOptionPane.showMessageDialog(null,"Mohon isi data dengan valid!!, nis dan nama tidak boleh kosong dan harus lebih dari 2 huruf atau angka");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelasActionPerformed

    private void srcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srcKeyReleased
        loadSiswa();
    }//GEN-LAST:event_srcKeyReleased

    private void srcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcActionPerformed

    private void nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nilaiActionPerformed

    }//GEN-LAST:event_nilaiActionPerformed

    private void nisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nisKeyReleased
        try {
            setStart();
            ResultSet rs = koneksi.read("select siswa.nama as nama, kelas.kelas as kelas from siswa, kelas where siswa.nis='" + nis.getText() + "' and kelas.id_kelas=siswa.id_kelas");
            if(rs.next()){
                nama.setText(rs.getString("nama"));
                kelas.setText(rs.getString("kelas"));
            }
            setEnd();
            timeTook();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nisKeyReleased

    private void nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nisActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try{
            int row =jTable2.getSelectedRow();
            this.id_nilai = jTable2.getModel().getValueAt(row, 0).toString();
            nis.setText(jTable2.getModel().getValueAt(row, 1).toString());
            nama.setText(jTable2.getModel().getValueAt(row, 2).toString());
            tingkat.setSelectedItem(jTable2.getModel().getValueAt(row, 3));
            kelas.setText(jTable2.getModel().getValueAt(row, 4).toString());
            ResultSet rs = koneksi.read("select concat(id_mapel, ' - ', mapel) as map from mapel where mapel='"+jTable2.getModel().getValueAt(row, 5).toString()+"'");
            if(rs.next()){
                mapel.setSelectedItem(rs.getObject("map"));
            }
            ResultSet rs2 = koneksi.read("select concat(id_jenis, ' - ', penilaian) as jenis from jenis_nilai where penilaian='"+jTable2.getModel().getValueAt(row, 7).toString()+"'");
            if(rs2.next()){
                jenis_nilai.setSelectedItem(rs2.getObject("jenis"));
            }
            nilai.setText(jTable2.getModel().getValueAt(row, 6).toString());
            tahun_ajaran.setSelectedItem((String) jTable2.getModel().getValueAt(row, 8));
            semester.setSelectedItem((String) jTable2.getModel().getValueAt(row, 9));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new DataSiswa().show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        loadTb();
    }//GEN-LAST:event_searchKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        loadTb();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
       if (jCheckBox1.isSelected()) {
           type = true;
       } 
       else {
           type = false;
       }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        page++;     
        showPage.setText(page.toString());
        loadTb();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(page > 1){
            page--;
            showPage.setText(page.toString());
            loadTb();
        }    
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> jenis_nilai;
    private javax.swing.JTextField kelas;
    private javax.swing.JComboBox<String> kelompokPenilaian;
    private javax.swing.JComboBox<String> mapel;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nilai;
    private javax.swing.JTextField nis;
    private javax.swing.JComboBox<String> nisnamakelas;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> semester;
    private javax.swing.JLabel showPage;
    private javax.swing.JComboBox<String> smta;
    private javax.swing.JTextField src;
    private javax.swing.JComboBox<String> tahunAjaranTampil;
    private javax.swing.JComboBox<String> tahun_ajaran;
    private javax.swing.JComboBox<String> tingat;
    private javax.swing.JComboBox<String> tingkat;
    private javax.swing.JLabel took;
    // End of variables declaration//GEN-END:variables
}
