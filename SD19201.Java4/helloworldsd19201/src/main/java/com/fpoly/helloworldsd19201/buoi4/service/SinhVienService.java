package com.fpoly.helloworldsd19201.buoi4.service;

import com.fpoly.helloworldsd19201.buoi4.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    List<SinhVien> danhSach = new ArrayList<>();

    public SinhVienService() {
        danhSach.add(new SinhVien("SV01", "A", 8, true));
        danhSach.add(new SinhVien("SV02", "B", 9, true));
        danhSach.add(new SinhVien("SV03", "C", 10, false));
        danhSach.add(new SinhVien("SV04", "D", 11, true));
        danhSach.add(new SinhVien("SV05", "E", 12, false));
    }

    public List<SinhVien> getAll() {
        return danhSach;
    }
    public SinhVien getByMaSinhVien(String maSinhVien) {
        for(SinhVien sv: danhSach) {
            if(sv.getMaSinhVien().equals(maSinhVien)) {
                return sv;
            }
        }
        return null;
    }
    public void addSinhVien(SinhVien sv) {
        danhSach.add(sv);
    }
    public void deleteSinhVien(String maSinhVien) {
        List<SinhVien> temp = new ArrayList<>();
        for(SinhVien sv: danhSach) {
            if(sv.getMaSinhVien().equals(maSinhVien)) {
                temp.add(sv);
            }
        }
        danhSach.removeAll(temp);
    }
    public void updateSinhVien(SinhVien sv) {
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getMaSinhVien().equals(sv.getMaSinhVien())) {
                danhSach.set(i, sv);
            }
        }
    }
}
