package com.example.finder_demo.repository;

import com.example.finder_demo.urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface urunRepository extends JpaRepository<urun, Integer> {
    /*city veritabanı tablosu için ayrı paketlerde olduğundan paketi
      import etmem gerekir.
      List<city> getAll();
      void add(city city);
      void update(city city);
      void delete(city city);*/

       @Query("SELECT u FROM urun u WHERE u.urunIsim = :urunIsim ORDER BY u.urunFiyat ASC")
    List<urun> findAndOrderByUrunFiyat(@Param("urunIsim") String urunIsim);
    @Query("SELECT u.urunUrl ,u.urunIsim, u.urunFiyat FROM  urun u JOIN urunisimler i ON u.urunId = i.urunId WHERE i.urunIsim = :searchKeyword ORDER BY u.urunFiyat ASC")
    List<Object[]> searchAndCompareProducts(@Param("searchKeyword") String searchKeyword);




}
