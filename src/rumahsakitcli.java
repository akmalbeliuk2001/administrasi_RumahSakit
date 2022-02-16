/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;
import java.io.*;
import java.lang.*;
public class rumahsakitcli{
public static void main(String[]args) {
Scanner input=new Scanner (System.in);
String kembali = "Y";
String nama, alamat, golda;
int tggi, brt ;
int pilihan, bayar,hari,ds ,kmr,pil;
while(kembali.equalsIgnoreCase("Y")){

System.out.println("\t||| Menu Utama Rumah Sakit Tadika Mesra |||");
System.out.println("\t<<===================================>>");
System.out.println();
System.out.println(" 1. FORM PASIEN");
System.out.println(" 2. PILIH DOKTER");
System.out.println(" 3. PILIH KAMAR");
System.out.println(" 4. BATAL/KELUAR");
System.out.print("\n  Menu Pilihan Anda : ");
pilihan = input.nextInt();
switch(pilihan)
{   
   case 1 :
        System.out.println("===========================");
        System.out.print("\n\t*** Isikan Identitas Pasien di bawah ini *** \n");
        System.out.print(".Nama   : ");
            nama = input.next();
        System.out.print(".Alamat : ");
            alamat = input.next();
        System.out.print(".Golongan darah : ");
            golda = input.next();
        System.out.print(".Tinggi Badan   : ");
            tggi = input.nextInt();
        System.out.print(".Berat badan    : ");
            brt = input.nextInt();
        System.out.println();
        System.out.println("\tApa Keluhan yang anda rasakan ?");
        System.out.println();
        System.out.println("1. Penyakit Umum");
        System.out.println("2. Penyakit Khusus");
        System.out.print("Masukan pilihan Anda : ");
        pil = input.nextInt();
            if(pil == 1){
        System.out.println("\n\t* Identitas yang anda masukan *");
        System.out.println("\nNama           : "+nama);
        System.out.println("Alamat         : "+alamat);
        System.out.println("Golongan darah : "+golda);
        System.out.println("Tinggi Badan   : "+tggi);
        System.out.println("Berat badan    : "+brt);   
        System.out.println(nama+" Menderita penyakit umum, Anda disarankan untuk konsultasi pada Dokter Umum");}
        else{
        System.out.println("\n\t* Identitas yang anda masukan *");
        System.out.println("\nNama           : "+nama);
        System.out.println("Alamat         : "+alamat);
        System.out.println("Golongan darah : "+golda);
        System.out.println("Tinggi Badan   : "+tggi);
        System.out.println("Berat badan    : "+brt);
        System.out.println(nama+" Menderita penyakit khusus, Anda disarankan untuk konsultasi pada Dokter Spesialis");
        System.out.println();}
        break;
    
        case 2 :
        System.out.println("=========================");
        System.out.println("\t*Pilih Dokter *");
        System.out.println("1. Umum");
        System.out.println("2. Spesialis");
        System.out.print(" Masukan info Dokter Pilihan Anda .. : ");
            ds = input.nextInt();
        if (ds == 1)
        {
        System.out.println("\n\tDaftar Dokter Umum");
        System.out.print("\t------------------------------------\n");
        System.out.println("1. Dr. Albert Einstein");
        System.out.println("   - Waktu Praktek : Senin-Selasa , 08.00- 17.00");
        System.out.println("   - Telp : 08299868966\n");
        System.out.println("2. Dr. Nikola Tesla");
        System.out.println("   - Waktu Praktek : Rabu-Kamis , 08.00- 17.00");
        System.out.println("   - Telp : 08299866453\n");
        System.out.println("3. Dr. Adolf Hitler");
        System.out.println("   - Waktu Praktek : jum'at-Sabtu , 08.00- 17.00");
        System.out.println("   - Telp : 08295543988\n");
        System.out.println();
        }
        if (ds == 2)
        {
         System.out.println("\n\tDaftar Dokter Spesialis");
         System.out.print("\t------------------------------\n");
         System.out.println("1. Dr. Haphap");
         System.out.println("   - Waktu praktek : Senin-Selasa , 08.00- 17.00");
         System.out.println("   - Telp : 08122425672\n");
         System.out.println("2. Dr. Sony Wakwaw");
         System.out.println("   - Waktu Praktek : Rabu-Kamis , 08.00- 17.00");
         System.out.println("   - Telp : 08299864329\n");
         System.out.println("3. Dr. Marlong");
         System.out.println("   - Waktu Praktek : jum'at-Sabtu , 08.00- 17.00");
         System.out.println("   - Telp : 08342756377\n");
         System.out.println();
         }
        break;
        
        case 3 :
        System.out.println("\nPilih tipe Kamar yang Anda inginkan");
        System.out.println("1. Kamar VVIP I");
        System.out.println("2. Kamar VVIP II");
        System.out.println("3. Kamar VIP I");
        System.out.println("4. Kamar VIP II");
        System.out.println("5. Kamar Umum I");
        System.out.println("6. Kamar Umum II");
        System.out.print("Pilih Kamar yang akan anda pesan = ");
            kmr = input.nextInt();
        if (kmr == 1)
        {
        System.out.println("\n\t=== Kamar VVIP ===");
        System.out.print("Nama Anda : ");
            nama = input.next();
        System.out.println(nama+" Telah memilih kamar VVIP\n");
        System.out.println("Harga sewa Kamar = Rp. 2.500.000/Hari");
        System.out.print("Berapa hari Anda dirawat = ");
            hari = input.nextInt();
        bayar = 2500000*hari;
        System.out.print(" Total Harga Sewa yang harus Anda bayar adalah : Rp."+bayar);
        System.out.println("\n");
        }
        if (kmr == 2)
        {
        System.out.println("\n\t=== Kamar VVIP ===");
        System.out.print("Nama Anda : ");
            nama = input.next();
        System.out.println(nama+" Telah memilih kamar VVIP\n");
        System.out.println("Harga sewa Kamar = Rp. 2.500.000/Hari");
        System.out.print("Berapa hari Anda dirawat = ");
            hari = input.nextInt();
        bayar = 2500000*hari;
        System.out.print(" Total Harga Sewa yang harus Anda bayar adalah : Rp."+bayar);
        System.out.println("\n");
        }
        if (kmr == 3)
        {
        System.out.println("\n\t=== Kamar VIP I ===");
        System.out.print("Nama Anda : ");
            nama = input.next();
        System.out.println(nama+" Telah memilih kamar VVIP\n");
        System.out.println("Harga sewa Kamar = Rp. 1.750.000/Hari");
        System.out.print("Berapa hari Anda dirawat = ");
            hari = input.nextInt();
        bayar = 1750000*hari;
        System.out.print(" Total Harga Sewa yang harus Anda bayar adalah : Rp."+bayar);
        System.out.println("\n");
        }
        if (kmr==4)
            {
        System.out.println("\n\t=== Kamar VIP II ===");
        System.out.print("Nama Anda : ");
            nama = input.next();
        System.out.println(nama+" Telah memilih kamar VVIP\n");
        System.out.println("Harga sewa Kamar = Rp. 1.750.000/Hari");
        System.out.print("Berapa hari Anda dirawat = ");
            hari = input.nextInt();
        bayar = 1750000*hari;
        System.out.print(" Total Harga Sewa yang harus Anda bayar adalah : Rp."+bayar);
        System.out.println("\n");
        }
        if (kmr == 5)
            {
        System.out.println("\n\t=== Kamar Umum I ===");
        System.out.print("Nama Anda : ");
            nama = input.next();
        System.out.println(nama+" Telah memilih kamar Umum 1\n");
        System.out.println("Harga sewa Kamar = Rp. 1.000.000/Hari");
        System.out.print("Berapa hari Anda dirawat = ");
            hari = input.nextInt();
        bayar = 1000000*hari;
        System.out.print(" Total Harga Sewa yang harus Anda bayar adalah : Rp."+bayar);
        System.out.println("\n");
        }
        if (kmr == 6)
            {
        System.out.println("\n\t=== Kamar Umum II ===");
        System.out.print("Nama Anda : ");
            nama = input.next();
        System.out.println(nama+" Telah memilih kamar Umum 2\n");
        System.out.println("Harga sewa Kamar = Rp. 1.000.000/Hari");
        System.out.print("Berapa hari Anda dirawat = ");
            hari = input.nextInt();
        bayar = 1000000*hari;
        System.out.print(" Total Harga Sewa yang harus Anda bayar adalah : Rp."+bayar);
        System.out.println("\n");
            }
        break;
    
        case 4 :
        System.out.print("Exit?¦\n");
        break;
default:
        System.out.print("Menu tidak tersedia\n");
        break;
        }
System.out.print("Kembali ke Menu ? Y/T : ");
        kembali = input.next();
} }}

     