package com.example.finderproject.projeclass.GenelSınıflar;
import com.example.finderproject.projeclass.GenelSınıflar.service.KullaniciService;
import com.example.finderproject.projeclass.GenelSınıflar.service.UrunService;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="kullanici")
public class KULLANICI {
    @Id
    @Column(name="id")
    public int id;
    @Column(name="kullaniciAdi")
    public String kullaniciAdi;






}
