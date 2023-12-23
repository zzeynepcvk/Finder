package com.example.finderproject.projeclass.GenelSınıflar.service;

import com.example.finderproject.projeclass.GenelSınıflar.URUN;
import com.example.finderproject.projeclass.GenelSınıflar.repository.UrunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UrunService {
    @Autowired
    private UrunRepository urunRepository;

    public List<URUN>  getUrunEnDusukFiyatByKategori(String kategori){

        return urunRepository.findTopByKategoriOrderByUrunFiyatiAsc(kategori);
    }

    public Double getGunlukOrtalamaFiyatByKategori(String kategori) {
        return urunRepository.findAvgGunlukOrtalamaFiyatByKategori(kategori);
    }



}
