package com.example.finder_demo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Urunisim")
public class urunisimler {
    @Id
    @Column(name = "UrunID")
    public int urunId;

    @Column(name = "UrunIsim")
    public int urunIsim;

    @Column(name = "UrunResim")
    public int urunResim;

}
