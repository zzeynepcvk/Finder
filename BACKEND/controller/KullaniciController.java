package com.example.finderproject.projeclass.GenelSınıflar.controller;


import com.example.finderproject.projeclass.GenelSınıflar.URUN;
import com.example.finderproject.projeclass.GenelSınıflar.service.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/kullanici")
@CrossOrigin(origins = "http://frontend-domaini.com")
public class KullaniciController {
    @Autowired
    private KullaniciService kullaniciService;




}
