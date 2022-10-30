package com.example.tuan04.repo;

import com.example.tuan04.model.Chuyenbay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ChuyenbayRepo extends JpaRepository<Chuyenbay, String> {
    public List<Chuyenbay> findByGaden(String gaden);

    public List<Chuyenbay> findByDodaiBetween(int min, int max);

    public List<Chuyenbay> findByGadiAndGaden(String gadi, String gaden);

    public List<Chuyenbay> findByGadi(String gadi);

    @Query(value = "select c from Chuyenbay c\n" +
            "where c.dodai < (select m.tambay from Maybay m where m.loai like %?1%)")
    public List<Chuyenbay> findByLoaiMaybay(String loai);

    @Query(value = "select * from chuyenbay c\n" +
            "where gaden in (select gadi from chuyenbay)\n" +
            "and gadi in (select gaden from chuyenbay)", nativeQuery = true)
    public List<Chuyenbay> findByComeback();

    @Query(value = "select c.gadi, count(c.gadi) from chuyenbay c\n" +
            "where  c.gadi like %?1% \n" +
            "group by c.gadi", nativeQuery = true)
    public List<?> getCountChuyenbayByGadi(String gadi);

    @Query(value = "select c.gadi, count(c.gadi), sum(c.chiphi) from chuyenbay c\n" +
            "where  c.gadi like %?1% \n" +
            "group by c.gadi", nativeQuery = true)
    public List<?> getCountSumByGadi(String gadi);

    public List<Chuyenbay> findByGiodiBefore(Date giodi);

    @Query(value = "select c.gadi, count(c.gadi) from chuyenbay c \n" +
            "where  c.gadi like %?1% and c.giodi < ?2 \n" +
            "group by c.gadi", nativeQuery = true)
    public List<?> findByGiodiBeforeAtGadi(String gadi, Date giodi);

    @Query(value = "select c.* from chuyenbay c where c.dodai < all (select m.tambay from maybay m where m.loai like %?1%)", nativeQuery = true)
    public List<Chuyenbay> findByAllLoaiMaybay(String loai);


}
