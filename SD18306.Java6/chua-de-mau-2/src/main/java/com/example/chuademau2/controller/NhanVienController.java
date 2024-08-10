package com.example.chuademau2.controller;

import com.example.chuademau2.entity.NhanVien;
import com.example.chuademau2.repository.NhanVienRepository;
import com.example.chuademau2.request.NhanVienRequest;
import com.example.chuademau2.response.NhanVienResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NhanVienController {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @GetMapping("/hien-thi")
    public List<NhanVienResponse> getAll() {
        return nhanVienRepository.getAll();
    }

    @GetMapping("/phan-trang")
    public List<NhanVienResponse> phanTrang(@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage) {
        int size = 5;
        Pageable pageable = PageRequest.of(currentPage, size);
        return nhanVienRepository.phanTrang(pageable).getContent();
    }

    @GetMapping("/detail/{id}")
    public NhanVienResponse getDetailNhanVien(@PathVariable("id") Integer id) {
        return nhanVienRepository.getNhanVienResponseById(id);
    }

    @PostMapping("/add")
    public String addNhanVien(@RequestBody NhanVienRequest nhanVienRequest) {
        NhanVien nv = new NhanVien();
        BeanUtils.copyProperties(nhanVienRequest, nv);
        NhanVien result = nhanVienRepository.save(nv);
        if(result == null) {
            return "Them that bai";
        }
        return "Them thanh cong";
    }

    @PutMapping("/update")
    public String updateNhanVien(@RequestBody NhanVienRequest nhanVienRequest) {
        NhanVien nv = new NhanVien();
        BeanUtils.copyProperties(nhanVienRequest, nv);
        NhanVien result = nhanVienRepository.save(nv);
        if(result == null) {
            return "Sua that bai";
        }
        return "Sua thanh cong";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        nhanVienRepository.deleteById(id);
        return "xoa thanh cong";
    }
}
