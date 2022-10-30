package com.example.tuan04.controller;

import com.example.tuan04.model.Chuyenbay;
import com.example.tuan04.repo.ChuyenbayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChuyenbayController {
    @Autowired
    private ChuyenbayRepo chuyenbayRepo;

    @GetMapping("cau01")
    public List<Chuyenbay> cau01() {
        return chuyenbayRepo.findByGaden("DAD");
    }

    @GetMapping("cau04")
    public List<Chuyenbay> cau04() {
        return chuyenbayRepo.findByDodaiBetween(8000, 10000);
    }

    @GetMapping("cau05")
    public List<Chuyenbay> cau05() {
        return chuyenbayRepo.findByGadiAndGaden("SGN", "BMV");
    }

    @GetMapping("cau06")
    public List<Chuyenbay> cau06() {
        return chuyenbayRepo.findByGadi("SGN");
    }
}
