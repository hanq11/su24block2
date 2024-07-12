package com.fpoly.helloworldsd19201.buoi5.service;

import com.fpoly.helloworldsd19201.buoi5.entity.GiangVien;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    private List<GiangVien> danhSach = new ArrayList<>();

    public GiangVienService() {
        danhSach.add(new GiangVien("GV1", "HN", Float.valueOf("6.5"), LocalDate.now(), true));
        danhSach.add(new GiangVien("GV2", "BG", Float.valueOf("6.5"), LocalDate.now(), true));
        danhSach.add(new GiangVien("GV3", "BN", Float.valueOf("7.5"), LocalDate.now(), false));
        danhSach.add(new GiangVien("GV4", "TN", Float.valueOf("9.5"), LocalDate.now(), true));
        danhSach.add(new GiangVien("GV5", "TH", Float.valueOf("10.5"), LocalDate.now(), false));
    }

    public GiangVien getByMaGiangVien(String maGiangVien) {
        for (GiangVien gv: danhSach) {
            if(gv.getMaGiangVien().equals(maGiangVien)) {
                return gv;
            }
        }
        return null;
    }

    public void deleteGiangVien(String maGiangVien) {
        for (GiangVien gv: danhSach) {
            if(gv.getMaGiangVien().equals(maGiangVien)) {
                danhSach.remove(gv);
                break;
            }
        }
    }

    public void addGiangVien(GiangVien gv) {
        danhSach.add(gv);
    }

    public List<GiangVien> getAll() {
        return danhSach;
    }

    public void updateGiangVien(GiangVien gv) {
        for (int i = 0; i < danhSach.size(); i++) {
            if(gv.getMaGiangVien().equals(danhSach.get(i).getMaGiangVien())) {
                danhSach.set(i, gv);
                break;
            }
        }
    }
}
