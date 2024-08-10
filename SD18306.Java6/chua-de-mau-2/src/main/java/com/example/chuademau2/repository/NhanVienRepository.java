package com.example.chuademau2.repository;

import com.example.chuademau2.entity.NhanVien;
import com.example.chuademau2.response.NhanVienResponse;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    @Query("""
        SELECT new com.example.chuademau2.response.NhanVienResponse(
                nv.id,
                nv.ma,
                concat(nv.ho, nv.tenDem, nv.ten),
                nv.gioiTinh,
                nv.diaChi,
                nv.chucVu.ten
            )
        FROM NhanVien nv
    """)
    List<NhanVienResponse> getAll();

    @Query("""
        SELECT new com.example.chuademau2.response.NhanVienResponse(
                nv.id,
                nv.ma,
                concat(nv.ho, nv.tenDem, nv.ten),
                nv.gioiTinh,
                nv.diaChi,
                nv.chucVu.ten
            )
        FROM NhanVien nv
    """)
    Page<NhanVienResponse> phanTrang(Pageable pageable);

    @Query("""
        SELECT new com.example.chuademau2.response.NhanVienResponse(
                nv.id,
                nv.ma,
                concat(nv.ho, nv.tenDem, nv.ten),
                nv.gioiTinh,
                nv.diaChi,
                nv.chucVu.ten
            )
        FROM NhanVien nv WHERE nv.id = :id
    """)
    NhanVienResponse getNhanVienResponseById(@Param("id") Integer id);
}
