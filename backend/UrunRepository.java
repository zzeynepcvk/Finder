package com.example.finderproject.projeclass.GenelSınıflar.repository;


import com.example.finderproject.projeclass.GenelSınıflar.URUN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UrunRepository extends JpaRepository<URUN, Long> {
     List<URUN>  findTopByKategoriOrderByUrunFiyatiAsc(@Param("kategori") String kategori);

     Double findAvgGunlukOrtalamaFiyatByKategori(@Param("kategori") String kategori);

     List<URUN> findFirstByKategoriOrderByUrunGunlukMaxFiyatDesc(@Param("kategori") String kategori);


}


//method parametre ismi ile sorgudaki parametre ismi
// arasında bir fark varsa, bu durumda @Param