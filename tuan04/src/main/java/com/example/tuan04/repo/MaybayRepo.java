package com.example.tuan04.repo;

import com.example.tuan04.model.Maybay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaybayRepo extends JpaRepository<Maybay, Integer> {
    public List<Maybay> findByTambayGreaterThan(int tambay);

    public List<Maybay> findByLoaiContaining(String loai);

    @Query(value = "select m.* from nhanvien n inner join chungnhan c on n.manv = c.manv inner join maybay m on m.mamb = c.mamb\n" +
            "where n.ten like ?1%", nativeQuery = true)
    public List<Maybay> findMaybayByHoNhanvien(String ho);

    @Query(value = "select * from maybay \n" +
            "where tambay > (select dodai from chuyenbay where macb = ?1)", nativeQuery = true)
    public List<Maybay> findByMacb(String ma);

    @Query(value = "select m.*, count(n.manv) from nhanvien n join chungnhan c on n.manv = c.manv join maybay m on m.mamb = c.mamb\n" +
            "group by m.mamb", nativeQuery = true)
    public List<?> getCountNhanvien();
}
