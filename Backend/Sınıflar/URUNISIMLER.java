package com.example.finderproject.projeclass.GenelSınıflar;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="Urunisim")

public class URUNISIMLER {

    @Id
    @Column(name = "UrunID")
    public int urunId;

    @Column(name = "UrunIsim")
    public int urunIsim;

    @Column(name = "UrunResim")
    public int urunResim;





}
