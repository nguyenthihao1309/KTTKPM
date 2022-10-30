package com.example.tuan04.repo;

import com.example.tuan04.model.Nhanvien;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanvienRepo extends JpaRepository<Nhanvien, String> {
    public List<Nhanvien> findByLuongLessThan(int luong);

    @Query("select SUM(n.luong) from Nhanvien n")
    public Double getSumLuong();

    @Query(value = "select n.* from nhanvien n inner join chungnhan c on n.manv = c.manv inner join maybay m on m.mamb = c.mamb\n" +
            "where loai like '%Boeing%'\n" +
            "group by n.manv", nativeQuery = true)
    public List<Nhanvien> getNhanvienIsPhicong();

    @Query(value = "select n.* from nhanvien n inner join chungnhan c on n.manv = c.manv\n" +
            "where c.mamb = ?1\n" +
            "group by n.manv", nativeQuery = true)
    public List<Nhanvien> findNhanVienByMamb(int mamb);

    @Query(value = "select n.* from nhanvien n join chungnhan c on n.manv = c.manv join maybay m on m.mamb = c.mamb\n" +
            "where m.loai like %?1% and n.manv in (select n.manv from nhanvien n join chungnhan c on n.manv = c.manv join maybay m on m.mamb = c.mamb\n" +
            "                                           where m.loai like %?2%)\n" +
            "group by n.manv", nativeQuery = true)
    public List<Nhanvien> getNhanvienBy2LoaiMaybay(String loai1, String loai2);

    @Query(value = "select n.* from maybay m join chungnhan c on m.mamb = c.mamb join nhanvien n on n.manv = c.manv\n" +
            "where loai like %?1%" +
            " group by n.manv", nativeQuery = true)
    public List<Nhanvien> findByLoaiMaybay(String loai);

    @Query(value = "select n.*, count(m.loai) from nhanvien n join chungnhan c on n.manv = c.manv join maybay m on m.mamb = c.mamb\n" +
            "group by n.manv\n" +
            "having count(loai) = ?1 \n", nativeQuery = true)
    public List<Nhanvien> findBySoLoaiMaybay(int soloai);

    @Query(value = "select n.manv, count(m.loai), max(m.tambay) from nhanvien n join chungnhan c on n.manv = c.manv join maybay m on m.mamb = c.mamb\n" +
            "group by n.manv\n" +
            "having count(m.loai) > ?1 ", nativeQuery = true)
    public List<?> findMaxTambayBySoLoaiMaybayGreaterThan(int soloai);

    @Query(value = "select n.manv, count(m.loai) from nhanvien n join chungnhan c on n.manv = c.manv join maybay m on m.mamb = c.mamb\n" +
            "group by n.manv", nativeQuery = true)
    public List<?> getCountSoLoaiMaybay();

    @Query(value = "select nv.* from nhanvien nv\n" +
            "where nv.manv not in (select n.manv from nhanvien n join chungnhan c on n.manv = c.manv join maybay m on m.mamb = c.mamb)", nativeQuery = true)
    public List<Nhanvien> findNhanvienKhongLaPhicong();

    @Query(value = "select * from nhanvien\n" +
            "where luong >= all (\n" +
            "    select luong from nhanvien\n" +
            "    )", nativeQuery = true)
    public List<Nhanvien> findByLuongMax();

    @Query(value = "select n.manv, sum(n.luong) from nhanvien n join chungnhan c on n.manv = c.manv join maybay m on m.mamb = c.mamb\n" +
            "group by n.manv", nativeQuery = true)
    public List<?> getSumLuongPhiCong();
}
