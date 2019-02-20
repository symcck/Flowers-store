/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author ORCUN
 */
public class DosyaIslemleri {
    public Scanner oku()             // DOsyayi okur.
    {           
        Scanner okuma = null;
        
      try {   
        okuma = new Scanner(new FileInputStream("cicekler.txt"));
         } 
      catch (FileNotFoundException i) {
             
        System.err.println("Dosya bulunamadi");
        System.exit(0);        
        }
      return okuma ;  
    } 
     
    public int satirSayisi()               // Okunacak dosyadaki satir sayisini dondurur.
    {
        int sayac = 0;
        Scanner okuma = null;
        try {
            okuma = new Scanner(new FileInputStream("cicekler.txt"));
        }
        catch (FileNotFoundException i) {
            System.err.println("Dosya bulunamadi");
            System.exit(0);
        }   
        while (okuma.hasNextLine())    
        {   
            String str = okuma.nextLine();
            sayac++ ;
        }    
       return sayac ;               
    }
    public String satirOku(Scanner okuma)       // Dosyadan bir satiri okur.
    {
        String a = okuma.nextLine();
        return a;
    }
    
    public void dosyayiBosalt()           // Dosyayi bosaltir.
    {
        try{
             File dosya = new File("cicekler.txt");
             FileWriter yazici = new FileWriter(dosya);
             BufferedWriter yaz = new BufferedWriter(yazici);
             yaz.write("");             
             yaz.close();
            }
         catch (Exception hata){
              hata.printStackTrace();
            }
    }
    
    
     public void veriEkle(String veri)        // Bu methot dosyaya bir veri eklemek icindir.Guncelleme yapar dosyanin uzerine yazmaz.
   {    
       try{
             File dosya = new File("cicekler.txt");
             FileWriter yazici = new FileWriter(dosya,true);
             BufferedWriter yaz = new BufferedWriter(yazici);
             yaz.write(veri);
             yaz.close();
             
            }
         catch (Exception hata){
              hata.printStackTrace();
            }
   }
     
      public void yeniSatir()              // Veri ekle methoduyla sinerjisi vardir.Basitce dosyada alt satira gecilir.
    {
        try{
             File dosya = new File("cicekler.txt");
             FileWriter yazici = new FileWriter(dosya,true);
             BufferedWriter yaz = new BufferedWriter(yazici);
             yaz.newLine();
             yaz.close();
             
            }
         catch (Exception hata){
              hata.printStackTrace();
            }
        
    }
      public void dosyayiGuncelle()                        // Main methodundan cicekler arraylistini alıp text dosyasini bosaltip icini arraylistin elemanlarıyla
      {                                                    // verilen formata gore doldurur.
          dosyayiBosalt();
          for(int i =0 ; i<Main.cicekler.size() ; i++)
          {   
              float degisken1 = (float) Main.cicekler.get(i).getcUzunluk();
              float degisken2 = (float) Main.cicekler.get(i).getcGenislik() ;
              float degisken3 = (float) Main.cicekler.get(i).gettUzunluk();             
              float degisken4 = (float) Main.cicekler.get(i).gettGenislik();
              veriEkle(Float.toString(degisken1));
              veriEkle(",");
              veriEkle(Float.toString(degisken2));
              veriEkle(",");
              veriEkle(Float.toString(degisken3));
              veriEkle(",");
              veriEkle(Float.toString(degisken4));
              veriEkle(",");
              veriEkle(Main.cicekler.get(i).getCicekTur());
              yeniSatir();
          }
          
      }
    
}
