package com.example.tuan04;

import com.example.tuan04.model.Chuyenbay;
import com.example.tuan04.model.Maybay;
import com.example.tuan04.model.Nhanvien;
import com.example.tuan04.repo.ChuyenbayRepo;
import com.example.tuan04.repo.MaybayRepo;
import com.example.tuan04.repo.NhanvienRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class Tuan04ApplicationTests {

    @Autowired
    private NhanvienRepo nhanvienRepo;
    @Autowired
    private MaybayRepo maybayRepo;
    @Autowired
    private ChuyenbayRepo chuyenbayRepo;

    @Test
    public void cau01() {
        List<Chuyenbay> dschuyChuyenbay = chuyenbayRepo.findByGaden("DAD");
        System.out.println(dschuyChuyenbay);
    }

    @Test
    public void cau02() {
        List<Maybay> dsMaybay = maybayRepo.findByTambayGreaterThan(10000);
        for (Maybay maybay : dsMaybay) {
            System.out.println(maybay.getLoai());
        }
    }

    @Test
    public void cau03() {
        List<Nhanvien> dsNhanvien = nhanvienRepo.findByLuongLessThan(10000);
        for (Nhanvien nhanvien : dsNhanvien) {
            System.out.println(nhanvien);
        }
    }

    @Test
    public void cau04() {
        List<Chuyenbay> dschuyChuyenbay = chuyenbayRepo.findByDodaiBetween(8000, 10000);
        for (Chuyenbay chuyenbay : dschuyChuyenbay) {
            System.out.println(chuyenbay);
        }
    }

    @Test
    public void cau05() {
        List<Chuyenbay> dschuyChuyenbay = chuyenbayRepo.findByGadiAndGaden("SGN", "BMV");
        for (Chuyenbay chuyenbay : dschuyChuyenbay) {
            System.out.println(chuyenbay);
        }
    }

    @Test
    public void cau06() {
        List<Chuyenbay> dsChuyenbay = chuyenbayRepo.findByGadi("SGN");
        for (Chuyenbay chuyenbay : dsChuyenbay) {
            System.out.println(chuyenbay);
        }
    }

    @Test
    public void cau07() {
        List<Maybay> dsMaybay = maybayRepo.findByLoaiContaining("Boeing");
        for (Maybay maybay : dsMaybay) {
            System.out.println(maybay);
        }
    }

    @Test
    public void cau08() {
        Double luong = nhanvienRepo.getSumLuong();
        System.out.println("Tổng lương phải trả cho nhân viên: " + luong);

    }

    @Test
    public void cau09() {
        List<Nhanvien> dsNhanvien = nhanvienRepo.getNhanvienIsPhicong();
        for (Nhanvien nhanvien : dsNhanvien) {
            System.out.println(nhanvien.getManv());
        }

    }

    @Test
    public void cau10() {
        List<Nhanvien> dsNhanvien = nhanvienRepo.findNhanVienByMamb(747);
        for (Nhanvien nhanvien : dsNhanvien) {
            System.out.println(nhanvien.getManv());
        }

    }

    @Test
    public void cau11() {
        List<Maybay> dsMaybay = maybayRepo.findMaybayByHoNhanvien("Nguyen");
        for (Maybay maybay : dsMaybay) {
            System.out.println(maybay.getMamb());
        }
    }

    @Test
    public void cau12() {
        List<Nhanvien> dsNhanvien = nhanvienRepo.getNhanvienBy2LoaiMaybay("Boeing", "Airbus");
        for (Nhanvien nhanvien : dsNhanvien) {
            System.out.println(nhanvien.getManv());
        }

    }

    @Test
    public void cau13() {
        List<Maybay> dsMaybay = maybayRepo.findByMacb("VN280");
        for (Maybay maybay : dsMaybay) {
            System.out.println(maybay.getLoai());
        }
    }

    @Test
    public void cau14() {
        List<Chuyenbay> dsChuyenbay = chuyenbayRepo.findByLoaiMaybay("Airbus A320");//
        for (Chuyenbay chuyenbay : dsChuyenbay) {
            System.out.println(chuyenbay);
        }
    }

    @Test
    public void cau15() {
        List<Nhanvien> dsNhanvien = nhanvienRepo.findByLoaiMaybay("Boeing");
        for (Nhanvien nhanvien : dsNhanvien) {
            System.out.println(nhanvien.getTen());
        }

    }

    @Test
    public void cau16() {
        List<?> dsThongKe = maybayRepo.getCountNhanvien();
        dsThongKe.forEach(o -> {
            Object[] objs = (Object[]) o;
            System.out.println(objs[0] + "  " + objs[1] + "  " + objs[3]);
        });

    }

    @Test
    public void cau17() {
        //chua kiem tra gio, truyen tham so
        List<Chuyenbay> dsChuyenbay = chuyenbayRepo.findByComeback();
        for (Chuyenbay chuyenbay : dsChuyenbay) {
            System.out.println(chuyenbay);
        }
    }

    @Test
    public void cau18() {
        List<?> dsThongKe = chuyenbayRepo.getCountChuyenbayByGadi("");
        dsThongKe.forEach(o -> {
            Object[] objs = (Object[]) o;
            System.out.println("Ga khởi hành: " + objs[0] + ", Số chuyến bay: " + objs[1]);
        });

    }

    @Test
    public void cau19() {
        List<?> dsThongKe = chuyenbayRepo.getCountSumByGadi("");
        dsThongKe.forEach(o -> {
            Object[] objs = (Object[]) o;
            System.out.println("Ga khởi hành: " + objs[0] + ", Số chuyến bay: " + objs[1] + ", Tổng chi phí: " + objs[2]);
        });

    }

    @Test
    public void cau20() {
        //chua kiem tra gio, truyen tham so
        Date date = new Date();
        date.setHours(12);
        List<Chuyenbay> dsChuyenbay = chuyenbayRepo.findByGiodiBefore(date);
        for (Chuyenbay chuyenbay : dsChuyenbay) {
            System.out.println(chuyenbay);
        }
    }

    @Test
    public void cau21() {
        Date date = new Date();
        date.setHours(12);
        List<?> dsThongKe = chuyenbayRepo.findByGiodiBeforeAtGadi("", date);
        dsThongKe.forEach(o -> {
            Object[] objs = (Object[]) o;
            System.out.println("Ga khởi hành: " + objs[0] + ", Số chuyến bay: " + objs[1]);
        });

    }

    @Test
    public void cau22() {
        List<Nhanvien> dsNhanvien = nhanvienRepo.findBySoLoaiMaybay(3);
        for (Nhanvien nhanvien : dsNhanvien) {
            System.out.println(nhanvien.getManv());
        }

    }

    @Test
    public void cau23() {
        List<?> dsNhanVien = nhanvienRepo.findMaxTambayBySoLoaiMaybayGreaterThan(3);
        dsNhanVien.forEach(o -> {
            Object[] objs = (Object[]) o;
            System.out.println("Mã nhân viên: " + objs[0] + ", Loại máy bay: " + objs[1] + ", Tầm bay lớn nhất: " + objs[2]);
        });

    }

    @Test
    public void cau24() {
        List<?> dsNhanVien = nhanvienRepo.getCountSoLoaiMaybay();
        dsNhanVien.forEach(o -> {
            Object[] objs = (Object[]) o;
            System.out.println("Mã nhân viên: " + objs[0] + ", Số loại máy bay có thể lái: " + objs[1] );
        });

    }

    @Test
    public void cau25(){
        List<Nhanvien> dsNhanvien = nhanvienRepo.findNhanvienKhongLaPhicong();
        for (Nhanvien nhanvien : dsNhanvien) {
            System.out.println(nhanvien);
        }
    }

    @Test
    public void cau26(){
        List<Nhanvien> dsNhanvien = nhanvienRepo.findByLuongMax();
        for (Nhanvien nhanvien : dsNhanvien) {
            System.out.println(nhanvien);
        }
    }

    @Test
    public void cau27() {
        List<?> dsNhanVien = nhanvienRepo.getSumLuongPhiCong();
        dsNhanVien.forEach(o -> {
            Object[] objs = (Object[]) o;
            System.out.println("Mã phi công: " + objs[0] + ", Tổng lương phải trả: " + objs[1] );
        });

    }

   @Test
    public void cau28(){
        List<Chuyenbay> dsChuyenbay = chuyenbayRepo.findByAllLoaiMaybay("Boeing");
        for (Chuyenbay chuyenbay : dsChuyenbay) {
            System.out.println(chuyenbay);
        }

    }

}
