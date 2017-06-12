package perpustakaan.GUI;

import Koneksi.Koneksi;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class MasterBuku extends javax.swing.JFrame {
    public static int kodeLogin=2;
    private DefaultTableModel tabel1;
    Connection con;
    public void ComboBuku(){
        try{
            Connection c=Koneksi.getKoneksi();
            Statement s=c.createStatement();
            String sql="select kd_buku from buku";
            ResultSet r=s.executeQuery(sql);
            while(r.next()){
                kd_buku.addItem(r.getString("kd_buku"));
            }
            r.close();;
            s.close();;
        }
catch(Exception e){
System.out.println(e.getMessage());
}
    }
    public void TamBuk(){
        try{
        Connection con = Koneksi.getKoneksi();
        Statement stt = con.createStatement();
        String sql = "select judul_buku, pengarang,penerbit, tahun_buku,jumlah  from buku where kd_buku='"+kd_buku.getSelectedItem()+"'";  
        ResultSet res = stt.executeQuery(sql);
        
        while(res.next()){
            Object[] ob = new Object[5];
            ob[0]=  res.getString(1);
            ob[1]=  res.getString(2);
            ob[2]=  res.getString(3);
            ob[3]=  res.getString(4);
            ob[4]=  res.getString(5);

          
            nm_buku.setText((String) ob[0]);
            penerbit.setText((String) ob[1]);
            pengarang.setText((String) ob[2]);
            thn_buku.setText((String) ob[3]);
            jml.setText((String) ob[4]);

            
            

        }
        res.close(); 
        stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void LoadData() {
        Object[] kolom = {"kd_buku", "judul_buku", "pengarang", "penerbit","Tahun_buku","jumlah"};
        tabel1 = new DefaultTableModel(null, kolom);
        TabBuk.setModel(tabel1);
        try {
            con = null;
            Connection con = Koneksi.getKoneksi();
            String sql = "" + "select * from buku";
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                String kode_buku = res.getString("kd_buku");
                String j_buku = res.getString("judul_buku");
                String pengarang = res.getString("pengarang");
                String penerbit = res.getString("penerbit");
                String t_buku = res.getString("Tahun_buku");
                String jml = res.getString("jumlah");
                Object[] Data = {kode_buku, j_buku, pengarang, penerbit,t_buku,jml};
                tabel1.addRow(Data);
            }
            TabBuk.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabBuk.getColumnModel().getColumn(1).setPreferredWidth(50);
            TabBuk.getColumnModel().getColumn(2).setPreferredWidth(50);
            TabBuk.getColumnModel().getColumn(3).setPreferredWidth(50);
            TabBuk.getColumnModel().getColumn(4).setPreferredWidth(50);
            TabBuk.getColumnModel().getColumn(5).setPreferredWidth(50);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e);
        }
    }
    public MasterBuku() {
        initComponents();
        setLocationRelativeTo(null);
        ComboBuku();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabBuk = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nm_buku = new javax.swing.JTextField();
        penerbit = new javax.swing.JTextField();
        pengarang = new javax.swing.JTextField();
        jml = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        save = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        del = new javax.swing.JButton();
        update = new javax.swing.JButton();
        view = new javax.swing.JButton();
        priny = new javax.swing.JButton();
        thn_buku = new javax.swing.JTextField();
        kd_buku = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TabBuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Buku", "Nama Buku", "Penerbit", "Pengarang", "Tahun Buku", "Jumlah"
            }
        ));
        jScrollPane1.setViewportView(TabBuk);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setText("Kode Buku");

        jLabel3.setText("Nama Buku");

        jLabel4.setText("Penerbit");

        jLabel5.setText("Pengarang");

        jLabel6.setText("Tahun Buku");

        jLabel7.setText("Jumlah");

        cari.setText("CARI");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        save.setText("UPDATE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        exit.setText("KELUAR");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        del.setText("HAPUS");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        update.setText("TAMBAH");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        view.setText("VIEW");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        priny.setText("CETAK");
        priny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prinyActionPerformed(evt);
            }
        });

        kd_buku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kode Buku" }));
        kd_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_bukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jml, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(thn_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(kd_buku, 0, 150, Short.MAX_VALUE)
                                .addComponent(nm_buku)
                                .addComponent(penerbit)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(pengarang))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priny, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari)
                    .addComponent(del)
                    .addComponent(kd_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nm_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save)
                    .addComponent(update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view)
                    .addComponent(priny))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thn_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
    
    String x=JOptionPane.showInputDialog("Masukan Kode Buku!!!");
    DefaultTableModel tabelTampil1 = new DefaultTableModel();
    tabelTampil1.addColumn("kd_buku");
    tabelTampil1.addColumn("judul_buku");
    tabelTampil1.addColumn("pengarang ");
    tabelTampil1.addColumn("penerbit");
    tabelTampil1.addColumn("tahun_buku");
    tabelTampil1.addColumn("jumlah");
        try{
            Connection con = Koneksi.getKoneksi();
            Statement stat = con.createStatement();
            String sql = "Select * from buku where kd_buku =  '" +x+ "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
            tabelTampil1.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(5),
            });
            }
            TabBuk.setModel(tabelTampil1);

                }catch (Exception e){
            }        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    try {
        TamBuk();
        Connection con = Koneksi.getKoneksi();
        Statement stat = con.createStatement();
        ResultSet r = stat.executeQuery(
                "update anggota set "
                + "judul_buku='"+nm_buku.getText()+"',"
                + "pengarang='"+pengarang.getText()+"',"
                + "penerbit='"+penerbit.getText()+"',"
                + "tahun_buku='"+thn_buku.getText()+"'"
                + "jumlah='"+jml.getText()+"'"
                + " where "
                + "kd_buku='"+kd_buku.getSelectedItem()+"'"      
        );
        

JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
        } catch (Exception e) {
JOptionPane.showMessageDialog(rootPane, e); 
    }    // TODO add your handling code here:
             // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
    try{
        String x = JOptionPane.showInputDialog("Masukan Kode Buku");
        Connection con = Koneksi.getKoneksi();
        Statement stat = con.createStatement();
        String sql="delete from buku where kd_buku='"+x+"'";
        stat.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
        LoadData();
        nm_buku.setText(null);
        penerbit.setText(null);
        pengarang.setText(null);
        jml.setText(null);
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, "Koneksi Gagal");
             // TODO add your handling code here:
    }//GEN-LAST:event_delActionPerformed
    }
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
if (JOptionPane.showConfirmDialog(null,"Jika ingin keluar dari aplikasi tekan ya","ya",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
        System.exit(0);
}// TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
LoadData();        // TODO add your handling code here:
    }//GEN-LAST:event_viewActionPerformed

    private void prinyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prinyActionPerformed
 try {
            
            InputStream sumber = getClass().getResourceAsStream("/perpustakaan/Laporan/Laporan_Buku.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(sumber);
            Map params = new HashMap();
            params.clear();
            JasperPrint jp = JasperFillManager.fillReport(jr, params, Koneksi.getKoneksi());

            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setExtendedState(viewer.getExtendedState() | 0x6);
            viewer.setVisible(true);
            viewer.setTitle("Bukti Pinjam");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Tidak dapat menampilkan report " + ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_prinyActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
this.dispose();;
new TambahBuku().setVisible(true);
    }//GEN-LAST:event_updateActionPerformed

    private void kd_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_bukuActionPerformed
TamBuk();        // TODO add your handling code here:
    }//GEN-LAST:event_kd_bukuActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MasterBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabBuk;
    private javax.swing.JButton cari;
    private javax.swing.JButton del;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jml;
    private javax.swing.JComboBox<String> kd_buku;
    private javax.swing.JTextField nm_buku;
    private javax.swing.JTextField penerbit;
    private javax.swing.JTextField pengarang;
    private javax.swing.JButton priny;
    private javax.swing.JButton save;
    private javax.swing.JTextField thn_buku;
    private javax.swing.JButton update;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
