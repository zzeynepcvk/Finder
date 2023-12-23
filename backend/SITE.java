package com.example.finderproject.projeclass.GenelSınıflar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SITE {
    @Id
    public Long siteId;
    public String siteAdi;

    public String siteIcıUrunAdi;
    public float siteIcıUrunFiyati;
    public String siteUrl;

    public  Long getSiteId(){
        return siteId;

    }
    public void setSiteId(Long siteId) {

        this.siteId = siteId;
    }

    public  String getSiteAdi(){
        return siteAdi;

    }
    public void setSiteAdi(String siteAdi) {

        this.siteAdi = siteAdi;
    }
    public  String getSiteIcıUrunAdi(){
        return siteIcıUrunAdi;

    }
    public void setSiteIcıUrunAdi(String siteIcıUrunAdi) {

        this.siteIcıUrunAdi = siteIcıUrunAdi;
    }

    public  Float getSiteIcıUrunFiyati(){
        return siteIcıUrunFiyati;

    }
    public void setSiteIcıUrunFiyati(Float siteIcıUrunFiyati) {

        this.siteIcıUrunFiyati = siteIcıUrunFiyati;
    }

    public  String getSiteUrl(){
        return siteUrl;

    }
    public void setSiteUrl(String siteUrl) {

        this.siteUrl = siteUrl;
    }




    private void siteGuncelBilgiCekme(){


    }

}
