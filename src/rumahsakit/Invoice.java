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
   import java.io.FileOutputStream;
    import com.itextpdf.text.Document;
    import com.itextpdf.text.Paragraph;
    import com.itextpdf.text.Phrase;
    import com.itextpdf.text.pdf.PdfWriter;
    import com.itextpdf.text.pdf.PdfPTable;
    import com.itextpdf.text.pdf.PdfPCell;
    import com.itextpdf.text.Image;
import static rumahsakit.generatePDF.printpdf;
/**
 *
 * @author X230
 */
public class Invoice extends javax.swing.JFrame {
DefaultTableModel tabModel;
ResultSet rsinvoice=null;
    /**
     * Creates new form Invoice
     */
    public Invoice() {
        initComponents();
        
    }
        private void tampilData(String number_input){
        try{
            Object[] judul_kolom = {"id_layanan", "id_pasien", "id_dokter", "jenis", "keterangan", "waktu", "harga"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TableInvoice.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            rsinvoice=stt.executeQuery("SELECT * from layanan where id_pasien = '" + number_input + "' ");  
            while(rsinvoice.next()){
                Object[] data={
                    rsinvoice.getString("id_layanan"),
                    rsinvoice.getString("id_pasien"),
                    rsinvoice.getString("id_dokter"),
                    rsinvoice.getString("jenis"),
                    rsinvoice.getString("keterangan"),
                    rsinvoice.getString("waktu"),
                    rsinvoice.getString("harga")
                };
            tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
        
    }

        private void TotalHarga(String number_input){
        try{
            Object[] judul_kolom = {"id_layanan", "id_pasien", "id_dokter", "jenis", "keterangan", "waktu", "harga"};            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            rsinvoice=stt.executeQuery("SELECT SUM(harga) as total from layanan where id_pasien = '" + number_input + "' ");  
            while(rsinvoice.next()){
                String data = rsinvoice.getString("total");
                labelhasil.setText("Rp "+data+",-");
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
        
    }
            public static void printpdf(String idpelanggan){
    try{
    String file_name="..\\InvoicePasien'"+ idpelanggan +"'.pdf";
    Document document=new Document();
    PdfWriter.getInstance(document, new FileOutputStream(file_name));
    document.open();
    String img = "https://cdn.discordapp.com/attachments/839027400166735932/851501331922681887/kop.png";
    document.add(Image.getInstance( img ));
    Connection connection=(Connection)koneksi.koneksiDB();
    ResultSet rs=null;
    PreparedStatement ps=null;

    String query = "select * from layanan where id_pasien = '"+idpelanggan +"'";
    ps=connection.prepareStatement(query);
    rs=ps.executeQuery();

    PdfPTable table = new PdfPTable(5);
    PdfPCell cl = new PdfPCell(new Phrase("Waktu"));
    table.addCell(cl);
    cl = new PdfPCell(new Phrase("Id_Pasien"));
    table.addCell(cl);
    cl = new PdfPCell(new Phrase("Jenis Layanan"));
    table.addCell(cl);
    cl = new PdfPCell(new Phrase("Keterangan"));
    table.addCell(cl);
    cl = new PdfPCell(new Phrase("Biaya"));
    table.addCell(cl);
    table.setHeaderRows(1);
    document.add(new Paragraph("Rincian:"));
    document.add(new Paragraph(" "));
    while(rs.next()){
    table.addCell(rs.getString("waktu"));
    table.addCell(rs.getString("id_pasien"));
    table.addCell(rs.getString("jenis"));
    table.addCell(rs.getString("keterangan"));
    table.addCell(rs.getString("harga"));
    }    
    ResultSet rsinvoice=null;
    Connection conn=(Connection)koneksi.koneksiDB();
    Statement stt=conn.createStatement();
    rsinvoice=stt.executeQuery("SELECT SUM(harga) as total from layanan where   id_pasien = '"+idpelanggan +"'");  

         
    System.out.println("Finish");
    document.add(table);
    
    document.add(new Paragraph(" "));
        while(rsinvoice.next()){
        String data = rsinvoice.getString("total");
        document.add(new Paragraph("Total biaya yang harus dibayar sebesar: Rp "+data+",-")); 
        document.add(new Paragraph(""));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        }     
    document.close();
}
catch(Exception e){
System.err.println(e);
}    
        
        
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableInvoice = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldnim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        labelhasil = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        button2 = new java.awt.Button();
        button1 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maju Jaya Medical");
        setMinimumSize(new java.awt.Dimension(915, 560));
        getContentPane().setLayout(null);

        TableInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id_layanan", "id_pasien", "id_dokter", "jenis", "keterangan", "waktu", "harga"
            }
        ));
        jScrollPane1.setViewportView(TableInvoice);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 77, 453, 403);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Invoice");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(378, 12, 114, 47);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Masukan ID_Pasien");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 100, 220, 20);

        jTextFieldnim.setText(" ");
        jTextFieldnim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldnimActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldnim);
        jTextFieldnim.setBounds(260, 100, 133, 19);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Total Biaya");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(45, 173, 118, 32);

        labelhasil.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelhasil.setText("Rp 0,-");
        getContentPane().add(labelhasil);
        labelhasil.setBounds(260, 170, 133, 32);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumahsakit/Logo-PBO-kecil-bgt.png"))); // NOI18N
        jLabel5.setText("Logo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 10, 30, 30);

        button2.setLabel("Clear");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2);
        button2.setBounds(150, 290, 90, 50);

        button1.setLabel("GET");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1);
        button1.setBounds(30, 290, 90, 50);

        button3.setLabel("Print Invoice");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        getContentPane().add(button3);
        button3.setBounds(280, 290, 90, 50);

        button4.setLabel("Kembali");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4);
        button4.setBounds(40, 440, 60, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumahsakit/Bg-PBO-coab.jpg"))); // NOI18N
        jLabel4.setText("Background");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 900, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldnimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldnimActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
       String a = jTextFieldnim.getText();

        tampilData(a);
        TotalHarga(a);

    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
                jTextFieldnim.setText("");
        labelhasil.setText("Rp 0.00,-");
        tampilData(null);;
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        String a = jTextFieldnim.getText();
        printpdf(a);
        JOptionPane.showMessageDialog(null,"File PDF sudah tergenerate");
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new menuUtama().setVisible(true);
    }//GEN-LAST:event_button4ActionPerformed

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
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableInvoice;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldnim;
    private javax.swing.JLabel labelhasil;
    // End of variables declaration//GEN-END:variables
}
