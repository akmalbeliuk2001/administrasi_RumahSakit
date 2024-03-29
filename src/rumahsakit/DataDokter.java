/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;
/**
 *
 * @author X230
 */
public class DataDokter extends javax.swing.JFrame {
DefaultTableModel tabModel;
ResultSet RS=null;
    /**
     * Creates new form DataPasien
     */
    public DataDokter() {
        initComponents();
        showData();
    }

        private void showData(){
        try{
            Object[] judul_kolom = {"id_dokter", "nik", "nama", "alamat", "telepon", "tglahir", "goldar", "gender", "spesialisasi"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelDokter.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RS=stt.executeQuery("SELECT * from dokter ");  
            while(RS.next()){
                Object[] data={
                    RS.getString("id_dokter"),
                    RS.getString("nik"),
                    RS.getString("nama"),
                    RS.getString("alamat"),
                    RS.getString("telepon"),
                    RS.getString("tglahir"),
                    RS.getString("goldar"), 
                    RS.getString("gender"),
                    RS.getString("spesialisasi")
                };
            tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }

    //show data to form when click data on table
    //menampilkan data ke form saat data pada tabel di klik 
    void tableToForm(){
        jTextFieldNama.setText(tabModel.getValueAt(TabelDokter.getSelectedRow(), 2)+ "");
        jTextFieldAlamat.setText(tabModel.getValueAt(TabelDokter.getSelectedRow(), 3)+ "");
        jTextFieldTelepon.setText(tabModel.getValueAt(TabelDokter.getSelectedRow(), 4)+ "");
        jTextFieldNIK.setText(tabModel.getValueAt(TabelDokter.getSelectedRow(),1)+"");
        jTextFieldTL.setText(tabModel.getValueAt(TabelDokter.getSelectedRow(),5)+"");
        jTextFieldDarah.setText(tabModel.getValueAt(TabelDokter.getSelectedRow(),6)+"");
        jComboBoxJK.setSelectedItem(tabModel.getValueAt(TabelDokter.getSelectedRow(),7)+"");
        jTextFieldSpesialisasi.setText(tabModel.getValueAt(TabelDokter.getSelectedRow(), 8)+ "");
        
        buttonUpdate.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonSave.setEnabled(false);
    }
    
    //clear the form
    //membersihkan isian form 
    private void clearData(){
        
        jTextFieldNIK.setText("");
        jTextFieldNama.setText(""); 
        jTextFieldAlamat.setText("");
        jTextFieldTelepon.setText("");
        jTextFieldTL.setText("");
        jTextFieldDarah.setText("");
        jComboBoxJK.setSelectedIndex(0);
        jTextFieldSpesialisasi.setText("");
        
    } 
    
    //disable to fill in form
    //tidak membolehkan untuk mengisi form
    private void SetEditOff(){
        jTextFieldNIK.setEnabled(false);
        jTextFieldNama.setEnabled(false); 
        jTextFieldAlamat.setEnabled(false);
        jTextFieldTelepon.setEnabled(false);
        jTextFieldTL.setEnabled(false);
        jTextFieldDarah.setEnabled(false);
        jComboBoxJK.setEnabled(false);
        jTextFieldSpesialisasi.setEnabled(false);
    }
    
    //enable to fill in form
    //membolehkan untuk mengisi form
    private void seteditOn(){
        jTextFieldNIK.setEnabled(true);
        jTextFieldNama.setEnabled(true); 
        jTextFieldAlamat.setEnabled(true);
        jTextFieldTelepon.setEnabled(true);
        jTextFieldTL.setEnabled(true);
        jTextFieldDarah.setEnabled(true);
        jComboBoxJK.setEnabled(true);
        jTextFieldSpesialisasi.setEnabled(true);
    }
 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelDokter = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAlamat = new javax.swing.JTextField();
        jTextFieldTelepon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDarah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNIK = new javax.swing.JTextField();
        buttonNew = new java.awt.Button();
        buttonUpdate = new java.awt.Button();
        buttonDelete = new java.awt.Button();
        buttonSave = new java.awt.Button();
        jComboBoxJK = new javax.swing.JComboBox<>();
        jTextFieldSpesialisasi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        buttonKembali = new java.awt.Button();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maju Jaya Medical");
        setMinimumSize(new java.awt.Dimension(1115, 580));
        getContentPane().setLayout(null);

        TabelDokter.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelDokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDokterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelDokter);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(350, 60, 739, 450);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Data Dokter");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(122, 6, 193, 47);

        jTextFieldNama.setToolTipText("");
        jTextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNama);
        jTextFieldNama.setBounds(140, 72, 161, 20);

        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Nama");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(43, 76, 80, 14);

        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Alamat");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(43, 118, 80, 14);

        jTextFieldAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAlamatActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldAlamat);
        jTextFieldAlamat.setBounds(140, 114, 161, 20);

        jTextFieldTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTeleponActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTelepon);
        jTextFieldTelepon.setBounds(140, 156, 161, 20);

        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Telepon");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(43, 160, 80, 14);

        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Darah");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(43, 202, 80, 14);

        jTextFieldDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDarahActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldDarah);
        jTextFieldDarah.setBounds(140, 198, 161, 20);

        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Tanggal Lahir");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(43, 244, 64, 14);

        jTextFieldTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTLActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTL);
        jTextFieldTL.setBounds(140, 240, 161, 20);

        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("NIK");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(43, 286, 70, 14);

        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Jenis Kelamin");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(43, 329, 63, 14);

        jTextFieldNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNIKActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNIK);
        jTextFieldNIK.setBounds(140, 282, 161, 20);

        buttonNew.setLabel("New");
        buttonNew.setName(""); // NOI18N
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });
        getContentPane().add(buttonNew);
        buttonNew.setBounds(43, 430, 41, 24);

        buttonUpdate.setLabel("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpdate);
        buttonUpdate.setBounds(94, 430, 56, 24);

        buttonDelete.setLabel("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDelete);
        buttonDelete.setBounds(160, 430, 52, 24);

        buttonSave.setLabel("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSave);
        buttonSave.setBounds(210, 430, 57, 24);

        jComboBoxJK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));
        jComboBoxJK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJKActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxJK);
        jComboBoxJK.setBounds(141, 324, 160, 20);

        jTextFieldSpesialisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSpesialisasiActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSpesialisasi);
        jTextFieldSpesialisasi.setBounds(141, 368, 160, 20);

        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("Spesialisasi");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(43, 372, 80, 14);

        buttonKembali.setLabel("Kembali");
        buttonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliActionPerformed(evt);
            }
        });
        getContentPane().add(buttonKembali);
        buttonKembali.setBounds(40, 480, 62, 24);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumahsakit/Logo-PBO-kecil-bgt.png"))); // NOI18N
        jLabel13.setText("Logo");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 10, 30, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumahsakit/Bg-PBO-coab.jpg"))); // NOI18N
        jLabel12.setText("Background");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 1100, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaActionPerformed

    private void jTextFieldAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAlamatActionPerformed

    private void jTextFieldTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTeleponActionPerformed

    private void jTextFieldDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDarahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDarahActionPerformed

    private void jTextFieldTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTLActionPerformed

    private void jTextFieldNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNIKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNIKActionPerformed
    
    //process for making new data
    //proses untuk membuat data data
    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        // TODO add your handling code here:
        clearData();
        buttonSave.setEnabled(true);
        buttonUpdate.setEnabled(false);
        buttonDelete.setEnabled(false);
        seteditOn();
    }//GEN-LAST:event_buttonNewActionPerformed

    //process for deleting data
    //proses untuk menghapus data
    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        String nama=jTextFieldNama.getText();

        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
            jTextFieldNama.requestFocus();
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM dokter WHERE nama='"+nama+"'");
            clearData();
            showData();
            SetEditOff();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    
    //process for updating data
    //proses untuk memperbaharui data
    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
        String nama=jTextFieldNama.getText();
        String jk=jComboBoxJK.getSelectedItem().toString();
        String nik=jTextFieldNIK.getText();
        String alamat=jTextFieldAlamat.getText();
        String telepon=jTextFieldTelepon.getText();
        String tl=jTextFieldTL.getText();
        String darah=jTextFieldDarah.getText();      
        String spesialisasi=jTextFieldSpesialisasi.getText();
        
        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh dikosongkan!");
            jTextFieldNama.requestFocus();
        }else if (nik.isEmpty()) {
            JOptionPane.showMessageDialog(null,"NIK tidak boleh dikosongkan!");
            jTextFieldNIK.requestFocus();
        }else if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh dikosongkan!");
            jTextFieldAlamat.requestFocus();
        }else if (telepon.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Telepon tidak boleh dikosongkan!");
            jTextFieldTelepon.requestFocus();
        }else if (tl.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Tanggal lahir tidak boleh dikosongkan!");
            jTextFieldTL.requestFocus();
        }else if (darah.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Darah tidak boleh dikosongkan!");
            jTextFieldDarah.requestFocus();
        }else if (spesialisasi.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Spesialisasi tidak boleh dikosongkan!");
            jTextFieldSpesialisasi.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE dokter SET nik='"+nik+"', nama='"+nama+"' , alamat='"+alamat+"', telepon='"+telepon+"', tglahir='"+tl+"', goldar='"+darah+"', gender='"+jk+"', spesialisasi='"+spesialisasi+"' WHERE nama='"+nama+"'");
                clearData();
                showData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void jComboBoxJKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxJKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxJKActionPerformed
   
    
    //process for saving data
    //proses untuk menyimpan data
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        // TODO add your handling code here:
        String nama=jTextFieldNama.getText();
        String jk=jComboBoxJK.getSelectedItem().toString();
        String nik=jTextFieldNIK.getText();
        String alamat=jTextFieldAlamat.getText();
        String telepon=jTextFieldTelepon.getText();
        String tl=jTextFieldTL.getText();
        String darah=jTextFieldDarah.getText();   
        String spesialisasi=jTextFieldSpesialisasi.getText();
        
        if (nama.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh dikosongkan!");
            jTextFieldNama.requestFocus();
        }else if (nik.isEmpty()) {
            JOptionPane.showMessageDialog(null,"NIK tidak boleh dikosongkan!");
            jTextFieldNIK.requestFocus();
        }else if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh dikosongkan!");
            jTextFieldAlamat.requestFocus();
        }else if (telepon.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Telepon tidak boleh dikosongkan!");
            jTextFieldTelepon.requestFocus();
        }else if (tl.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Tanggal lahir tidak boleh dikosongkan!");
            jTextFieldTL.requestFocus();
        }else if (darah.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Darah tidak boleh dikosongkan!");
            jTextFieldDarah.requestFocus();
        }else if (spesialisasi.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Spesialisasi tidak boleh dikosongkan!");
            jTextFieldSpesialisasi.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("INSERT INTO dokter(nik, nama, alamat, telepon, tglahir, goldar, gender, spesialisasi)"+
                    "VALUES('"+nik+"','"+nama+"','"+alamat+"','"+telepon+"','"+tl+"','"+darah+"','"+jk+"','"+spesialisasi+"')");
                clearData();
                showData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void jTextFieldSpesialisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSpesialisasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSpesialisasiActionPerformed

    //handling process when click data on pasien table
    //menangani proses saat tabel pasien di klik
    private void TabelDokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDokterMouseClicked
        // TODO add your handling code here:
        seteditOn();
        tableToForm();
    }//GEN-LAST:event_TabelDokterMouseClicked

    private void buttonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new menuUtama().setVisible(true);
    }//GEN-LAST:event_buttonKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(DataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataDokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelDokter;
    private java.awt.Button buttonDelete;
    private java.awt.Button buttonKembali;
    private java.awt.Button buttonNew;
    private java.awt.Button buttonSave;
    private java.awt.Button buttonUpdate;
    private javax.swing.JComboBox<String> jComboBoxJK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAlamat;
    private javax.swing.JTextField jTextFieldDarah;
    private javax.swing.JTextField jTextFieldNIK;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldSpesialisasi;
    private javax.swing.JTextField jTextFieldTL;
    private javax.swing.JTextField jTextFieldTelepon;
    // End of variables declaration//GEN-END:variables
}
