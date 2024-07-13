package com.fpoly.xuongjavaweb.service;

import com.fpoly.xuongjavaweb.entity.KhoaHoc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class KhoaHocService {
    private List<KhoaHoc> list = new ArrayList<>();

    public KhoaHocService() {
        list.add(new KhoaHoc(1, Float.valueOf("4.4"), "Lap trinh", true, "ptpm", LocalDate.of(2024, 7, 13)));
        list.add(new KhoaHoc(2, Float.valueOf("5.4"), "Sua dien", true, "ptpm", LocalDate.of(2022, 7, 13)));
        list.add(new KhoaHoc(3, Float.valueOf("6.4"), "Sua nuoc", false, "udpm", LocalDate.of(2023, 7, 13)));
        list.add(new KhoaHoc(4, Float.valueOf("4.8"), "May giat", false, "udpm", LocalDate.of(2021, 7, 13)));
    }

    public List<KhoaHoc> getAll() {
        return list;
    }

    public KhoaHoc getDetail(int id) {
        for(KhoaHoc kh: list) {
            if(kh.getId().equals(id)) {
                return kh;
            }
        }
        return null;
    }

    public void addKhoaHoc(KhoaHoc kh) {
        list.add(kh);
    }

    public void updateKhoaHoc(KhoaHoc kh) {
        for(int i = 0; i < list.size(); i++) {
            if(kh.getId().equals(list.get(i).getId())) {
                list.set(i, kh);
                break;
            }
        }
    }

    public void deleteKhoaHoc(int id) {
        for(KhoaHoc kh: list) {
            if(kh.getId().equals(id)) {
                list.remove(kh);
                break;
            }
        }
    }

    public List<KhoaHoc> searchKhoaHoc(String key) {
        List<KhoaHoc> ketQua = new ArrayList<>();
        for(KhoaHoc kh: list) {
            if(kh.getTen().toLowerCase().contains(key.toLowerCase())) {
                ketQua.add(kh);
            }
        }
        return ketQua;
    }
}
