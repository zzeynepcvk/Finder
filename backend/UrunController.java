package com.example.finderproject.projeclass.GenelSınıflar.controller;

import com.example.finderproject.projeclass.GenelSınıflar.URUN;
import com.example.finderproject.projeclass.GenelSınıflar.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/urun")
public class UrunController {

    private  UrunService urunService;

    @Autowired
    public  UrunController(UrunService urunService) {
        this.urunService = urunService;
    }

    @GetMapping("/enDusukFiyatliUrun")
    public ResponseEntity<String> getEnDusukFiyatliUrun(@RequestParam String kategori) {
        try {
            URUN enDusukFiyatliUrun = (URUN) urunService.getUrunEnDusukFiyatByKategori(kategori);

            if (enDusukFiyatliUrun != null) {
                return ResponseEntity.ok("En düşük fiyatlı ürün: " + enDusukFiyatliUrun.getUrunAdi() + " - Fiyat: " + enDusukFiyatliUrun.getUrunFiyati());
            } else {
                return ResponseEntity.ok("Belirtilen kategoride ürün bulunamadı.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("İşlem sırasında bir hata oluştu.");
        }

    }
    @GetMapping("/gunlukOrtalamaFiyat")
    public ResponseEntity<Double> getGunlukOrtalamaFiyat(@RequestParam String kategori){
        try {
            Double gunlukOrtalamaFiyat = urunService.getGunlukOrtalamaFiyatByKategori(kategori);

            if (gunlukOrtalamaFiyat != null) {
                return ResponseEntity.ok(gunlukOrtalamaFiyat);
            } else {
                return ResponseEntity.ok(0.0); // veya başka bir değer döndürebilirsiniz
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(0.0);
        }

    }

}

///api/urun/enDusukFiyatliUrun endpoint'ine yapılan
// GET isteğinde, search bar'dan gelen kategori değeri
// @RequestParam ile alınmış ve bu değer urunService
// sınıfındaki getEnDusukFiyatliUrunByKategori metoduna
// iletilmiştir.
