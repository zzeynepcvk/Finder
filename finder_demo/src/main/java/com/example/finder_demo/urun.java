package com.example.finder_demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import javax.persistence.Table;
import java.util.List;
import com.example.finder_demo.repository.urunRepository;

@Data
@Table(name = "Urun_Fiyat")
@Entity
public class urun {

    @Id
    @Column(name = "ID")
    public int id;
    @Column(name = "URUNID")
    public float urunId;
    @Column(name="UrunIsim")
    public String urunIsim;
    @Column(name="UrunUrl")
    public String urunUrl;
    @Column(name="UrunFiyat")
    public double urunFiyat;



    public static String urunFiyatKarsilastirma(){

        return "FiyatKarşılaştırma Sonucu";
    }





    public double maxDegerHesaplama(){

        return 0;
    }

    public double ortDegerHesaplama(){

        return 0;
    }
    public void urunGrafikGoruntuleme(){

    }
    public double enUcuzFiyatGetirme(){

        return 0;
    }


    public double getFiyat() {

        return 0;
    }
}
