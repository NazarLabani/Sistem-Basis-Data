package perpustakaan.GUI;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MasterAnggota extends javax.swing.JFrame {
    
    
public static int kodeLogin=2;
    int login;
    private DefaultTableModel tabel1;
    Connection con;
     public void TamBuk(){
        try {
            String a=JOptionPane.showInputDialog("Masukan NIS");
        
        Connection con = Koneksi.getKoneksi();
        Statement stt = con.createStatement();
        String sql = "select NIS, nama,alamat from anggota where NIS='"+a+"'";  
        ResultSet res = stt.executeQuery(sql);
        
        while(res.next()){
            Object[] ob = new Object[2];
            ob[0]=  res.getString(1);
            ob[1]=  res.getString(2);
            ob[1]=  res.getString(2);

          
            nis.setText((String) ob[0]);
            Nama.setText((String) ob[1]);
            alamat.setText((String) ob[2]);

            
            

        }
        res.close(); 
        stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }
    private void LoadData() {
        Object[] kolom = {"NIS", "nama", "Jenis_Kelamin", "Kelas","alamat"};
        tabel1 = new DefaultTableModel(null, kolom);
        TabAng.setModel(tabel1);
        try {
            con = null;
            Connection con = Koneksi.getKoneksi();
            String sql = "" + "select * from anggota";
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                String nis = res.getString("nis");
                String nama = res.getString("nama");
                String j_k = res.getString("Jenis_kelamin");
                String kelas = res.getString("kelas");
                String almt = res.getString("alamat");
                Object[] Data = {nis, nama, j_k, kelas,almt};
                tabel1.addRow(Data);
            }
            TabAng.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabAng.getColumnModel().getColumn(1).setPreferredWidth(50);
            TabAng.getColumnModel().getColumn(2).setPreferredWidth(50);
            TabAng.getColumnModel().getColumn(3).setPreferredWidth(50);
            TabAng.getColumnModel().getColumn(4).setPreferredWidth(50);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e);
        }
    }
    public MasterAnggota() {
        initComponents();
        setLocationRelativeTo(null);
        
       
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabel = new javax.swing.JScrollPane();
        TabAng = new javax.swing.JTable();
        Label = new javax.swing.JPanel();
        Angt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Test1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        kelas = new javax.swing.JComboBox<>();
        nis = new javax.swing.JTextField();
        Nama = new javax.swing.JTextField();
        j_k = new javax.swing.JComboBox<>();
        Nis1 = new javax.swing.JLabel();
        Cari1 = new javax.swing.JButton();
        Nama1 = new javax.swing.JLabel();
        VIEW1 = new javax.swing.JButton();
        Kelas1 = new javax.swing.JLabel();
        Hapus1 = new javax.swing.JButton();
        J_k1 = new javax.swing.JLabel();
        Save1 = new javax.swing.JButton();
        Aamat1 = new javax.swing.JLabel();
        Exit1 = new javax.swing.JButton();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabAng.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIS", "NAMA", "KELAS", "JENIS KELAMIN", "ALAMAT"
            }
        ));
        TabAng.setGridColor(new java.awt.Color(255, 255, 255));
        Tabel.setViewportView(TabAng);

        Label.setBackground(new java.awt.Color(153, 204, 255));

        Angt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Angt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Angt.setText("ANGGOTA");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        alamat.setColumns(20);
        alamat.setRows(5);
        Test1.setViewportView(alamat);

        kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelas", "A", "B", "C" }));
        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        j_k.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Kelamin", "Laki - Laki", "Perempuan" }));
        j_k.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_kActionPerformed(evt);
            }
        });

        Nis1.setText("NIS");

        Cari1.setText("CARI");
        Cari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cari1ActionPerformed(evt);
            }
        });

        Nama1.setText("Nama");

        VIEW1.setText("TAMPIL");
        VIEW1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEW1ActionPerformed(evt);
            }
        });

        Kelas1.setText("Kelas");

        Hapus1.setText("HAPUS");
        Hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hapus1ActionPerformed(evt);
            }
        });

        J_k1.setText("Jenis Kelamin");

        Save1.setText("TAMBAH");
        Save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save1ActionPerformed(evt);
            }
        });

        Aamat1.setText("Alamat");

        Exit1.setText("KEMBALI");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });

        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(J_k1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(Nama1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nis1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Kelas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Aamat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(j_k, 0, 150, Short.MAX_VALUE)
                    .addComponent(nis)
                    .addComponent(Nama, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kelas, 0, 150, Short.MAX_VALUE)
                    .addComponent(Test1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Save1)
                    .addComponent(Cari1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VIEW1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Hapus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Exit1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nis1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nis)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Cari1)
                                .addComponent(VIEW1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j_k, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(J_k1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nama1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Save1)
                                        .addComponent(Hapus1)))
                                .addGap(18, 18, 18)
                                .addComponent(Exit1)
                                .addGap(18, 18, 18)
                                .addComponent(update)))))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Test1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Aamat1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LabelLayout = new javax.swing.GroupLayout(Label);
        Label.setLayout(LabelLayout);
        LabelLayout.setHorizontalGroup(
            LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Angt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LabelLayout.setVerticalGroup(
            LabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LabelLayout.createSequentialGroup()
                .addComponent(Angt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Tabel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelasActionPerformed

    private void Cari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cari1ActionPerformed
    String x=JOptionPane.showInputDialog("Masukan NIS!!!");
    DefaultTableModel tabelTampil1 = new DefaultTableModel();
    tabelTampil1.addColumn("NIS");
    tabelTampil1.addColumn("Nama ");
    tabelTampil1.addColumn("Jenis_kelamin ");
    tabelTampil1.addColumn("kelas ");
    tabelTampil1.addColumn("alamat ");
        try{
            Connection con = Koneksi.getKoneksi();
            Statement stat = con.createStatement();
            String sql = "Select * from anggota where NIS =  '" +x+ "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
            tabelTampil1.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            });
            }
            TabAng.setModel(tabelTampil1);

                }catch (Exception e){
            }
    }//GEN-LAST:event_Cari1ActionPerformed

    private void VIEW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEW1ActionPerformed
LoadData();        // TODO add your handling code here:
    }//GEN-LAST:event_VIEW1ActionPerformed

    private void Hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hapus1ActionPerformed
    String x=JOptionPane.showInputDialog("Masukan NIS!!!");
    int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Mendelete record ini???", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
       if (ok==0)
       {
        try
         {
            Connection con = Koneksi.getKoneksi();
            String sql="delete from anggota where NIS='"+x+"'";
            PreparedStatement st=con.prepareStatement(sql);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete Data Sukses");
         }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Delete Data Gagal");
        }
       }
// TODO add your handling code here:
    }//GEN-LAST:event_Hapus1ActionPerformed
    private void Save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save1ActionPerformed
    try {
            Connection con = Koneksi.getKoneksi();
            Statement stat = con.createStatement();
            String sqlnya = "insert into anggota values ('" + nis.getText() 
            +"','"+ Nama.getText()
            +"','"+ j_k.getSelectedItem()
            +"','"+ kelas.getSelectedItem()
            +"','"+ alamat.getText()
            + "')";
            stat.executeUpdate(sqlnya);
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        } catch (Exception e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_Save1ActionPerformed

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
    this.dispose();
    new Menu_Utama(0).setVisible(true);
    
       // TODO add your handling code here:
    }//GEN-LAST:event_Exit1ActionPerformed

    private void j_kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_kActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_kActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
    try {
        TamBuk();
        Connection con = Koneksi.getKoneksi();
        Statement stat = con.createStatement();
        ResultSet r = stat.executeQuery(
                "update anggota set "
                + "nama='"+Nama.getText()+"',"
                + "Jenis_Kelamin='"+j_k.getSelectedItem()+"',"
                + "Kelas='"+kelas.getSelectedItem()+"',"
                + "Alamat='"+alamat.getText()+"'"
                + " where "
                + "NIS='"+nis.getText()+"'"      
        );
        if("NIS".equals(null)){
            JOptionPane.showMessageDialog(null,"Data Tidak ada");
        }

JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
        } catch (Exception e) {
JOptionPane.showMessageDialog(rootPane, e); 
    }
        
        
       // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(MasterAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterAnggota().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Aamat1;
    private javax.swing.JLabel Angt;
    private javax.swing.JButton Cari1;
    private javax.swing.JButton Exit1;
    private javax.swing.JButton Hapus1;
    private javax.swing.JLabel J_k1;
    private javax.swing.JLabel Kelas1;
    private javax.swing.JPanel Label;
    private javax.swing.JTextField Nama;
    private javax.swing.JLabel Nama1;
    private javax.swing.JLabel Nis1;
    private javax.swing.JButton Save1;
    private javax.swing.JTable TabAng;
    private javax.swing.JScrollPane Tabel;
    private javax.swing.JScrollPane Test1;
    private javax.swing.JButton VIEW1;
    private javax.swing.JTextArea alamat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> j_k;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JTextField nis;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
