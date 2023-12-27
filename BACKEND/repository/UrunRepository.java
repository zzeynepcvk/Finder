package com.example.finderproject.projeclass.GenelSınıflar.repository;


import com.example.finderproject.projeclass.Decorator.UrunDecorator;
import com.example.finderproject.projeclass.GenelSınıflar.URUN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface UrunRepository extends JpaRepository<URUN ,Long> {
    @Query("SELECT i.urunResim, u.urunUrl ,u.urunIsim, u.urunFiyat FROM  URUN u JOIN URUNISIMLER i ON u.urunId = i.urunId WHERE i.urunIsim = :searchKeyword ORDER BY u.urunFiyat ASC")
    List<Object[]> searchAndCompareProducts(@Param("searchKeyword") String searchKeyword);

}


//method parametre ismi ile sorgudaki parametre ismi
// arasında bir fark varsa, bu durumda @Param