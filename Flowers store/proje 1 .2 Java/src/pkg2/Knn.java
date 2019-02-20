/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ORCUN
 */
public class Knn {

    /**
     * @return the indisler
     */
    public ArrayList<Integer> getIndisler() {
        return indisler;
    }

    /**
     * @param indisler the indisler to set
     */
    public void setIndisler(ArrayList<Integer> indisler) {
        this.indisler = indisler;
    }
    private ArrayList<Float> yakinliklar = new ArrayList<Float>();   // kucukten buyuge farklari tutar
    private ArrayList<Float> yedek = new ArrayList<Float>();        // orjinal halleriyle farklari tutar
    private ArrayList<Float> enYakinlar  = new ArrayList<Float>();  // en yakinlarin kucukten buyuge tutuldugu liste
    private ArrayList<Integer> indisler  = new ArrayList<Integer>();  // en yakinlarin indisleri (sirasiyla)
    
    public String EnYakinIndisler(int k,List<Cicek>cicekler,ArrayList alinanCicek)
    {   
        double toplam = 0,min;
        int minIndis =0;
        getYakinliklar().clear();
        getYedek().clear();
        getEnYakinlar().clear();
        getIndisler().clear();
        double cnkUznlk,cnkGnslk,tcUznlk,tcGnslk;
                
        for(int i = 0; i<cicekler.size() ; i++)
        {
            
                cnkUznlk = cicekler.get(i).getcUzunluk();
                cnkGnslk = cicekler.get(i).getcGenislik();
                tcUznlk  = cicekler.get(i).gettUzunluk();
                tcGnslk  = cicekler.get(i).gettGenislik();
                
                cnkUznlk = cnkUznlk - (float)alinanCicek.get(0);
                cnkGnslk = cnkGnslk - (float)alinanCicek.get(1);               
                tcUznlk  = tcUznlk  - (float)alinanCicek.get(2);
                tcGnslk  = tcGnslk  - (float)alinanCicek.get(3);
                
                cnkUznlk = Math.abs(cnkUznlk);
                cnkGnslk = Math.abs(cnkGnslk);              
                tcUznlk  = Math.abs(tcUznlk);                       
                tcGnslk  = Math.abs(tcGnslk);
                
                cnkUznlk =  Math.pow(cnkUznlk, 2);
                cnkGnslk =  Math.pow(cnkGnslk, 2);
                tcUznlk  =  Math.pow(tcUznlk, 2);
                tcGnslk  =  Math.pow(tcGnslk, 2);
                toplam = (cnkUznlk + cnkGnslk + tcUznlk + tcGnslk) ;
                toplam = Math.sqrt(toplam);                                            
                float toplam1 = (float) toplam;
                yakinliklar.add(toplam1);
                yedek.add(toplam1);
        }
        Collections.sort(yakinliklar); 
        min = getYakinliklar().get(0);
        for(int i = 0 ; i<k ; i++)
        {
            enYakinlar.add(yakinliklar.get(i));
        }
        
       Iterator<Float> iterator=yedek.iterator();
       
       float gecici ;
       int indis =0 ;
       while(iterator.hasNext())                         //yedek listesini iteratorle gezerek en kucuk degerlerin indislerini saptıyor.
       {
           gecici = iterator.next();
           for(float a : enYakinlar)
           {
              if(a == min)
              {
                  minIndis = indis ;
              }
              if(a==gecici)
              {
                    indisler.add(indis);
                  break;
              }
           }
           indis++;
       }
       int setosa=0,versicolor=0,virginia=0;
       for(int i =0 ;i<indisler.size() ; i++)
       {
           Cicek cicek = new Cicek();
           cicek = cicekler.get(indisler.get(i));
           String isim = cicek.getCicekTur();
           
           if(isim.equals("Iris-setosa")){         
               setosa++;
           }else if (isim.equals("Iris-versicolor"))
           {
               versicolor++;
           }else{
               virginia++;
           }          
       } 
       String isim ;
       if((setosa>versicolor)&&(setosa>virginia))
       {
           isim = "Iris-setosa";
       }
       else if((versicolor>setosa)&&(versicolor>virginia))
       {
           isim = "Iris-versicolor";
       }
       else if((virginia>setosa)&&(virginia>versicolor))
       {
           isim ="Iris-virginica";
       }
       else
       {
           Cicek cicek = new Cicek();
           cicek = cicekler.get(minIndis);
           isim = cicek.getCicekTur();
           
       }
       
       
    return isim ;   
    }

    /**
     * @return the yakinliklar
     */
    public ArrayList<Float> getYakinliklar() {
        return yakinliklar;
    }

    /**
     * @param yakinliklar the yakinliklar to set
     */
    public void setYakinliklar(ArrayList<Float> yakinliklar) {
        this.yakinliklar = yakinliklar;
    }

    /**
     * @return the yedek
     */
    public ArrayList<Float> getYedek() {
        return yedek;
    }

    /**
     * @param yedek the yedek to set
     */
    public void setYedek(ArrayList<Float> yedek) {
        this.yedek = yedek;
    }

    /**
     * @return the enYakinlar
     */
    public ArrayList<Float> getEnYakinlar() {
        return enYakinlar;
    }

    /**
     * @param enYakinlar the enYakinlar to set
     */
    public void setEnYakinlar(ArrayList<Float> enYakinlar) {
        this.enYakinlar = enYakinlar;
    }
    
    
   
}
