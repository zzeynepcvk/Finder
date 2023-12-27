package com.example.finderproject.projeclass.GenelSınıflar;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Table(name="Site")

public class SITE {
    @Id
    @Column(name = "SiteID")

    public int siteId;

    @Column(name = "SiteAdi")
    public String siteAdi;






}
