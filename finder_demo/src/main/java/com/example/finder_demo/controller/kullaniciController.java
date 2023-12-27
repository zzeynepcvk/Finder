package com.example.finder_demo.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Data
public class kullaniciController {

    @Autowired
    private kullaniciService kullaniciService;

}
