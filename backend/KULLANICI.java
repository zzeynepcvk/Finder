package com.example.finderproject.projeclass.GenelSınıflar;
import com.example.finderproject.projeclass.GenelSınıflar.service.UrunService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class KULLANICI {
    @Id
    public Long uyeId;
    public String mail;


    public  Long getUyeId(){
        return uyeId;

    }
    public void setUyeId(Long uyeId) {
        this.uyeId = uyeId;
    }

    public  String getUyeMail(){
        return mail;

    }
    public void setUyeMail(String mail) {
        this.mail = mail;
    }
    protected void urunleriListeleme(){

    }
    protected void urunInceleme(){

    }
    protected void urunFiyatKarsilastirmaGor(String kategori){
        UrunService urunService = new UrunService();
        List<URUN> enUcuzFiyat = urunService.getUrunEnDusukFiyatByKategori(kategori);
    }

    protected void urunAra(){

    }
}
