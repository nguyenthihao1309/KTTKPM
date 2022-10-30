package com.example.tuan04.controller;

import com.example.tuan04.model.Nhanvien;
import com.example.tuan04.repo.NhanvienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NhanvienController {
    @Autowired
    private NhanvienRepo nhanvienRepo;

    @GetMapping("cau03")
    public List<Nhanvien> cau03() {
        return nhanvienRepo.findByLuongLessThan(10000);
    }

    @GetMapping("cau08")
    public Double cau08() {
        return nhanvienRepo.getSumLuong();
    }

    @GetMapping("cau09")
    public List<Nhanvien> cau09() {
        return nhanvienRepo.getNhanvienIsPhicong();
    }

    @GetMapping("cau10")
    public List<Nhanvien> cau10() {
        return nhanvienRepo.findNhanVienByMamb(747);
    }
}
