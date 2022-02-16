/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package rumahsakit;
    import java.sql.*;
    import java.io.FileOutputStream;
    import com.itextpdf.text.Document;
    import com.itextpdf.text.Paragraph;
    import com.itextpdf.text.Phrase;
    import com.itextpdf.text.pdf.PdfWriter;
    import com.itextpdf.text.pdf.PdfPTable;
    import com.itextpdf.text.pdf.PdfPCell;
    import com.itextpdf.text.Image;

/**
 *
 * @author X230
 */    

public class generatePDF {
    
    public static void printpdf(String idpelanggan){
    try{
    String file_name="..\\filepdf.pdf";
    Document document=new Document();
    PdfWriter.getInstance(document, new FileOutputStream(file_name));
    document.open();
    document.add(Image.getInstance( "src\\RumahSakit\\kop.png" ));
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
    
    public static void main(String[] args) {
        printpdf("0");
        }
    }



