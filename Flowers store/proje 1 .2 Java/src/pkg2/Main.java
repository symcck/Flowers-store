/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ORCUN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
     public static List<Cicek> cicekler = new ArrayList<Cicek>();            // bu listenin amacı cicek nesnesi icindeki ozellik arraylistlerini bir yerde tutmaktır.
    public static void main(String[] args) {
        
        Scanner klavye = new Scanner(System.in);
        
        ArrayList<Float> alinanCicek = new ArrayList<Float>();
        ArrayList<Integer> enYakinIndisler = new ArrayList<Integer>();
        Scanner okuma  = null ;
        String satir,gecici ;   
        int satirSay ;
        float cnkUznlk,cnkGnslk,tcUznlk,tcGnslk;
        DosyaIslemleri dosya = new DosyaIslemleri();        
        okuma = dosya.oku();       
        satirSay = dosya.satirSayisi();      
        
       for(int i=0 ; i<satirSay ; i++)
        {
           satir = dosya.satirOku(okuma);
           StringTokenizer tknzr = new StringTokenizer(satir,",");             // artık dosyadaki verileri parcalayıp okuyabiliriz.
           Cicek cck = new Cicek();
           cck.setcUzunluk(Float.parseFloat(tknzr.nextToken()));
           cck.setcGenislik(Float.parseFloat(tknzr.nextToken()));
           cck.settUzunluk(Float.parseFloat(tknzr.nextToken()));
           cck.settGenislik(Float.parseFloat(tknzr.nextToken()));
           cck.setCicekTur(tknzr.nextToken());
           cicekler.add(cck);
       }
       
                                                                                // veri ekleme baslangic        
       menu();
       
    
       
       
} 
    public static void veriEkle()
    {
       DosyaIslemleri dosya = new DosyaIslemleri();
       ArrayList<Float> alinanCicek = new ArrayList<Float>();
       String isim ;
       Knn knn = new Knn();
       Scanner klavye = new Scanner(System.in);
       System.out.println("Yeni çiçeğin verilerini giriniz");                        //KUllanıcıdan cicek verisi alıyoruz.
       System.out.print("Canak yaprak uzunlugu :");
       float cnkUznlk =klavye.nextFloat();
       System.out.println();
       System.out.print("Canak yaprak genisligi :");
       float cnkGnslk=klavye.nextFloat();
       System.out.println();
       System.out.print("Tac yaprak uzunlugu :");
       float tcUznlk=klavye.nextFloat();
       System.out.println();
       System.out.print("Tac yaprak genisligi :");
       float tcGnslk=klavye.nextFloat();
       alinanCicek.clear();
       alinanCicek.add(cnkUznlk);                                                          // tek bir bitki alma
       alinanCicek.add(cnkGnslk);
       alinanCicek.add(tcUznlk);
       alinanCicek.add(tcGnslk);
      
       System.out.println("Cicegin Adini girecek misiniz E(evet) / H(hayir)");
       String giris = klavye.next();
       if(giris.equals(("E")))
       {
           System.out.print("Bitkinin ismi : ");
           isim = klavye.next();
       }
       else{
           System.out.print("Tahmin icin k : ");
           int k = klavye.nextInt();
           isim = knn.EnYakinIndisler(k, cicekler, alinanCicek);
       }
       Cicek cicek = new Cicek();
       cicek.setCicekTur(isim);
       cicek.setcGenislik(cnkGnslk);
       cicek.setcUzunluk(cnkUznlk);
       cicek.settGenislik(tcGnslk);
       cicek.settUzunluk(tcUznlk);
       cicekler.add(cicek);
       dosya.dosyayiGuncelle();
    }
    public static void veriSil()
    {
        DosyaIslemleri dosya = new DosyaIslemleri();
        Scanner klavye = new Scanner(System.in);
        System.out.println("silinecek verinin indisini giriniz :");
        int indis = klavye.nextInt() -1;
        cicekler.remove(indis);
        dosya.dosyayiGuncelle();
        
    }
    public static void Listeleme()
    {
        System.out.println("VERI SETİNDEKI CICEK BILGILERI");
        for(Cicek cck : cicekler)
        {
            System.out.print("Cicegin adi :" +cck.getCicekTur());
            System.out.print("  Canak Yaprak Uzunlugu :" +cck.getcUzunluk());
            System.out.print("  Canak Yaprak Genisligi : "+cck.getcGenislik());
            System.out.print("  Tac Yaprak Uzunlugu : "+cck.gettUzunluk());
            System.out.print("  Tac Yaprak Genisligi : "+cck.gettGenislik());
            System.out.println();
        }
    }
    public static void basariOlcumu(int k)
    {
             
        int[] testVerisi ={40,41,42,43,44,45,46,47,48,49,90,91,92,93,94,95,96,97,98,99,140,141,142,143,144,145,146,147,148,149};                        // Test verisiyle kontrol kısmı baslangıc.
        float dogru =0 ;
        ArrayList<Float> alinanCicek = new ArrayList<>();
        Knn knn = new Knn();
        
        for(int i =0 ; i<testVerisi.length ; i++)
        {   alinanCicek.clear();
           alinanCicek.add(cicekler.get(testVerisi[i]).getcUzunluk());
           alinanCicek.add(cicekler.get(testVerisi[i]).getcGenislik());
           alinanCicek.add(cicekler.get(testVerisi[i]).gettUzunluk());
           alinanCicek.add(cicekler.get(testVerisi[i]).gettGenislik());
                                                                                                        // alinan cicek arraylistini tekrar yarattık cunku knn methodu bu listeye ihtiyac duyuyor.
           
           String  isim =knn.EnYakinIndisler(k, cicekler, alinanCicek);                               // Knn in icindeki methot cagrılarak cicek ismi tahmin edilir.                      
           
           System.out.print("1-");
           System.out.print("orjinal tur: "+cicekler.get(testVerisi[i]).getCicekTur()+"  ");
           System.out.print("isim :"+isim);
           System.out.print("  fark : "+knn.getYedek().get(i));
           System.out.println("");
           if(isim.equals(cicekler.get(testVerisi[i]).getCicekTur()))
           {
               dogru++;
           }
        }
        System.out.println("basari orani = %"+100*(dogru/30)); 
     
    }
    
   public static void sınıflandırma()
   {
       
       DosyaIslemleri dosya = new DosyaIslemleri();
       ArrayList<Float> alinanCicek = new ArrayList<Float>();
       String isim ;
       Knn knn = new Knn();
       Scanner klavye = new Scanner(System.in);
       System.out.println("Yeni çiçeğin verilerini giriniz");                        //KUllanıcıdan cicek verisi alıyoruz.
       System.out.print("Canak yaprak uzunlugu :");
       float cnkUznlk =klavye.nextFloat();
       System.out.println();
       System.out.print("Canak yaprak genisligi :");
       float cnkGnslk=klavye.nextFloat();
       System.out.println();
       System.out.print("Tac yaprak uzunlugu :");
       float tcUznlk=klavye.nextFloat();
       System.out.println();
       System.out.print("Tac yaprak genisligi :");
       float tcGnslk=klavye.nextFloat();
       System.out.println("k degerini giriniz :" );
       int k = klavye.nextInt();
       
       alinanCicek.add(cnkUznlk);                                                          // tek bir bitki alma
       alinanCicek.add(cnkGnslk);
       alinanCicek.add(tcUznlk);
       alinanCicek.add(tcGnslk);
       
       isim = knn.EnYakinIndisler(k, cicekler, alinanCicek);
       
       
       
                                                             // en yakın k degerin isimleri ve farklar .       
       for(int l=0 ; l<knn.getEnYakinlar().size() ; l++)
       {
           System.out.print("  isim  :"+cicekler.get(knn.getIndisler().get(l)).getCicekTur()+ " fark : "+knn.getEnYakinlar().get(l) );               // en yakın k degerlerini yazdırma.Knn deki global private
       }                                                                                                                                                // degiskenleri kullanıyoruz.

   }
   public static void menu()
   {
       Scanner klavye = new Scanner(System.in);
       System.out.println("HOS GELDİNİZ ....");
       System.out.println("           MENU      ");
       System.out.println("1--> Bitki Sınıflandırma ");
       System.out.println("2--> Basari Olcumu ");
       System.out.println("3--> Ekleme Silme Islemleri");
       System.out.println("4--> Listeleme ");
       System.out.println("5--> Cikis");
       
       int giris = klavye.nextInt();
       while(giris>5)
       {
           System.out.println("opsss yanlıs rakam tekrar dene");
           giris = klavye.nextInt();
       }
       while(giris<5)
       {
           if (giris ==1)
           {
               sınıflandırma();
               System.out.println();
           }
           else if (giris ==2)
           {    
               System.out.print("k degerini giriniz : ");
               int k = klavye.nextInt();
               basariOlcumu(k);
               System.out.println();
               
           }
           else if (giris ==3)
           {
               int secenek=0;
               while(secenek!=3)
               {
                  System.out.println();
                  System.out.println("Devam etmek istediginiz secenegi seciniz :");
                  System.out.println("1--> Veri Ekleme ");
                  System.out.println("2--> Veri Silme ");
                  System.out.println("3--> Ust menu");
                  secenek = klavye.nextInt();
                  if(secenek == 1)
                   {
                      veriEkle();
                   }
                   else if (secenek ==2)
                   {
                       veriSil();
                   }
                   else if(secenek ==3)
                   {
                       
                   }
                   else
                    {
                        while((giris!=1)||(giris!=2))
                    {
                           System.out.print("opps hatali giris lutfen seciniz(ust menu icin 3)");
                           giris=klavye.nextInt();
                           if(giris==3)
                            {
                               break;
                            }
                    }
                   
                    }
                  System.out.println();
                } 
               
           }
           else if (giris ==4)
           {
               Listeleme();
               System.out.println();
               
           }
           else
           {
               break ;
           }
       System.out.println();   
       System.out.println("HOS GELDİNİZ ....");
       System.out.println("           MENU      ");
       System.out.println("1--> Bitki Sınıflandırma ");
       System.out.println("2--> Basari Olcumu ");
       System.out.println("3--> Ekleme Silme Islemleri");
       System.out.println("4--> Listeleme ");
       System.out.println("5--> Cikis");
       giris = klavye.nextInt();
       }
   }
   
   
    
}