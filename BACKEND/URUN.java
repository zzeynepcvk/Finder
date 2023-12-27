package com.example.finderproject.projeclass.GenelSınıflar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Urun_Fiyat")
public class URUN {

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




}