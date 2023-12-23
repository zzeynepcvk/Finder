package com.example.finderproject.projeclass.GenelSınıflar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class URUN {
    @Id
    public int urunId;
    public String urunAdi;

    public float urunFiyati;
    public String urunSitesi;
    private String kategori;
    public double urunEnDusukFiyat;
    public double urunGunlukMaxFiyat;
    public double urunGunlukMinFiyat;
    public double urunGunlukOrtalamaFiyat;


    // Getter ve Setter metotları
    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public float getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunFiyati(float urunFiyati) {
        this.urunFiyati = urunFiyati;
    }

    public String getUrunSitesi() {
        return urunSitesi;
    }

    public void setUrunSitesi(String urunSitesi) {
        this.urunSitesi = urunSitesi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public double getUrunEnDusukFiyat() {
        return urunEnDusukFiyat;
    }

    public void setUrunEnDusukFiyat(double urunEnDusukFiyat) {
        this.urunEnDusukFiyat = urunEnDusukFiyat;
    }

    public double getUrunGunlukMaxFiyat() {
        return urunGunlukMaxFiyat;
    }

    public void setUrunGunlukMaxFiyat(double urunGunlukMaxFiyat) {
        this.urunGunlukMaxFiyat = urunGunlukMaxFiyat;
    }

    public double getUrunGunlukMinFiyat() {
        return urunGunlukMinFiyat;
    }

    public void setUrunGunlukMinFiyat(double urunGunlukMinFiyat) {
        this.urunGunlukMinFiyat = urunGunlukMinFiyat;
    }

    public double getUrunGunlukOrtalamaFiyat() {
        return urunGunlukOrtalamaFiyat;
    }

    public void setUrunGunlukOrtalamaFiyat(double urunGunlukOrtalamaFiyat) {
        this.urunGunlukOrtalamaFiyat = urunGunlukOrtalamaFiyat;
    }



  //SORU:!!fiyat karşılaştırmada zaten en ucuz gelmiyor mu bunuda en alttaki fonksiyon sağlamıyrmu
    public void urunFiyatKarsilastirma(){
    }

    //SORU:!!Python ile çekilip analiz edilecek mi?
    private void urunGunlukMinDegeriniHesaplama(){

    }
    private void urunGunlukMaxDegeriniHesaplama(){

    }
    private void urunGunlukOrtalamaDegeriniHesaplama(){

    }

    private void urunEnUcuzFiyatGetirme(){

    }

}
