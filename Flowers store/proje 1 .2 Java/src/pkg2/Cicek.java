/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2;



/**
 *
 * @author ORCUN
 */
public class Cicek {
    private float tUzunluk,tGenislik,cUzunluk,cGenislik ; // t ve c  : tac ve canak yaprak ozellikleri
    private String cicekTur ;
    
    public Cicek()
    {
        this.tUzunluk  = 0;
        this.tGenislik = 0;
        this.cUzunluk  = 0;
        this.cGenislik = 0;
        cicekTur = "";
    }
    public Cicek(float cUzunluk,float cGenislik , float tUzunluk, float tGenislik,String cicekTur)
    {
        this.tUzunluk  = tUzunluk ;               
        this.tGenislik = tGenislik;
        this.cUzunluk  = cUzunluk ;
        this.cGenislik = cGenislik;
        this.cicekTur = cicekTur;
        
    
    }

    /**
     * @return the tUzunluk
     */
    public float gettUzunluk() {
        return tUzunluk;
    }

    /**
     * @param tUzunluk the tUzunluk to set
     */
    public void settUzunluk(float tUzunluk) {
        this.tUzunluk = tUzunluk;
    }

    /**
     * @return the tGenislik
     */
    public float gettGenislik() {
        return tGenislik;
    }

    /**
     * @param tGenislik the tGenislik to set
     */
    public void settGenislik(float tGenislik) {
        this.tGenislik = tGenislik;
    }

    /**
     * @return the cUzunluk
     */
    public float getcUzunluk() {
        return cUzunluk;
    }

    /**
     * @param cUzunluk the cUzunluk to set
     */
    public void setcUzunluk(float cUzunluk) {
        this.cUzunluk = cUzunluk;
    }

    /**
     * @return the cGenislik
     */
    public float getcGenislik() {
        return cGenislik;
    }

    /**
     * @param cGenislik the cGenislik to set
     */
    public void setcGenislik(float cGenislik) {
        this.cGenislik = cGenislik;
    }

    /**
     * @return the cicekTur
     */
    public String getCicekTur() {
        return cicekTur;
    }

    /**
     * @param cicekTur the cicekTur to set
     */
    public void setCicekTur(String cicekTur) {
        this.cicekTur = cicekTur;
    }

  
}