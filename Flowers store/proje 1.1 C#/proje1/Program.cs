using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proje1
{
    class Program
    {
        static Random r = new Random();
        static void Main(string[] args)
        {
            kisiye_gore_cakismalar(50);
            kisiye_gore_cakismalar(100);
            kisiye_gore_cakismalar(500);
            kisiye_gore_cakismalar(1000);

            Console.WriteLine("\nDoğum günü çakışmalarını gidermek için kaldırılan çakışma sayıları: ");
            dogumgunucakistirmama(50);
            dogumgunucakistirmama(100);
            dogumgunucakistirmama(250);
            Console.ReadKey();
        }
        static int[] Dogum_gunu_cakistir(int kisisayisi)
        {
            int[] cakisma = new int[367];
            int[] dogumgunleri = new int[kisisayisi];
            for (int i = 0; i < kisisayisi; i++)
            {
                dogumgunleri[i] = r.Next(0, 366);
            }
            for (int i = 0; i < kisisayisi; i++)
            {
                for (int j = i + 1; j < kisisayisi; j++)
                {
                    if (dogumgunleri[i] == dogumgunleri[j])
                    {
                        cakisma[dogumgunleri[i]] += 1;
                        break;
                    }
                }
            }
           aylargunler(cakisma);
            return cakisma;
        }
       static void aylargunler(int[] cakisma)
        {
            Console.Write("\nocak;    ");
            for (int i = 0; i < 31; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\nşubat;   ");
            for (int i = 31; i < 60; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\nmart;    ");
            for (int i = 60; i < 91; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\nnisan;   ");
            for (int i = 91; i < 121; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\nmayıs;   ");
            for (int i = 121; i < 152; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\nhaziran; ");
            for (int i = 152; i < 182; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\ntemmuz;  ");
            for (int i = 182; i < 213; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\nağustos; ");
            for (int i = 213; i < 244; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\neylül;   ");
            for (int i = 244; i < 274; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\nekim;    ");
            for (int i = 274; i < 305; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\nkasım;   ");
            for (int i = 305; i < 335; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.Write("\naralık;  ");
            for (int i = 335; i < 366; i++)
            {
                Console.Write(cakisma[i] + " ");
            }
            Console.WriteLine("\n");
        }
        static void kisiye_gore_cakismalar(int kisisayisi)
        {
            int[] cakisma_toplam = new int[367];
            int[] cakistirma_final = new int[367];
            int[] yillarincakismasi = new int[10];
            int toplam;
            int deneytoplam = 0;
                Console.WriteLine(kisisayisi + " kişi için: ");
                for (int a = 0; a < 10; a++)
                {
                    {
                    Console.WriteLine("\n" + (a + 1) + ". deney");
                    cakisma_toplam = Dogum_gunu_cakistir(kisisayisi);
                    toplam = 0;
                    for (int i = 0; i < 367; i++)
                    {
                        cakistirma_final[i] += cakisma_toplam[i];
                        toplam += cakisma_toplam[i];
                    }
                    yillarincakismasi[a] = toplam;
                        Console.WriteLine("devam etmek için tuşa basın");
                        Console.ReadLine();
                    }
                }
            Console.WriteLine("\n");
            for (int b = 0; b < 10; b++)
            {
                deneytoplam += yillarincakismasi[b];
                Console.WriteLine((b + 1) + ". deney çakışma toplamı: " + yillarincakismasi[b]);
            }
            Console.WriteLine(kisisayisi + " kişi için 10 deney toplam: " + deneytoplam + " çakışma olmuşltur.");
            Console.WriteLine("ortalama çakışma: " + deneytoplam / 10 + "." + deneytoplam % 10);
            Console.WriteLine("devam etmek için tuşa basın");
            Console.ReadLine();    
         }
        static void dogumgunucakistirmama(int kisisayisi)
        {
            int[] dizi = new int[kisisayisi];
            int cakisma_sayisi = 0;
            for (int i = 0; i < kisisayisi; i++)
            {
                dizi[i] = r.Next(1, 367);
                for (int j = 0; j < i; j++)
                {
                    if (dizi[j] == dizi[i])
                    {
                        dizi[i] = r.Next(1, 367);
                        cakisma_sayisi++;
                        j = -1;
                    }
                }
            }
            Console.WriteLine(kisisayisi + " kişide çakışma sayısı: " + cakisma_sayisi);
        }
    }
}