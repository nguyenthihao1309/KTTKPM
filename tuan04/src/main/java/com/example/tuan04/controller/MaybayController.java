package com.example.tuan04.controller;

import com.example.tuan04.model.Maybay;
import com.example.tuan04.repo.MaybayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MaybayController {
    @Autowired
    private MaybayRepo maybayRepo;

    @GetMapping("cau02")
    public List<Maybay> cau02() {
        return maybayRepo.findByTambayGreaterThan(10000);
    }

    @GetMapping("cau07")
    public List<Maybay> cau07() {
        return maybayRepo.findByLoaiContaining("Boeing");
    }

    @GetMapping("cau11")
    public List<String> cau11() {
        List<Maybay> dsMaybay = maybayRepo.findMaybayByHoNhanvien("Nguyen");
        List<String> dsMa = new ArrayList<>();
        for (Maybay maybay : dsMaybay) {
            dsMa.add(maybay.getMamb() + "");
        }
        return dsMa;
    }

}
