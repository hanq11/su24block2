package com.example.chuabaimau1.repository;

import com.example.chuabaimau1.entity.BaiHat;
import com.example.chuabaimau1.response.BaiHatResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, Integer> {
    @Query("""
       SELECT new com.example.chuabaimau1.response.BaiHatResponse(
        bh.id,
        bh.tenBaiHat,
        bh.tenTacGia,
        bh.thoiLuong,
        bh.ngaySanXuat,
        bh.gia,
        bh.ngayRaMat,
        bh.caSi.tenCaSi,
        bh.caSi.queQuan
       ) FROM BaiHat bh
       """)
    List<BaiHatResponse> getAllResponse();

    @Query("""
       SELECT new com.example.chuabaimau1.response.BaiHatResponse(
        bh.id,
        bh.tenBaiHat,
        bh.tenTacGia,
        bh.thoiLuong,
        bh.ngaySanXuat,
        bh.gia,
        bh.ngayRaMat,
        bh.caSi.tenCaSi,
        bh.caSi.queQuan
       ) FROM BaiHat bh
       """)
    Page<BaiHatResponse> phanTrang(Pageable pageable);
}
