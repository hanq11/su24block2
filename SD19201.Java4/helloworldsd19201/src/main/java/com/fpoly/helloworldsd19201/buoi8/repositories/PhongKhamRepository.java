package com.fpoly.helloworldsd19201.buoi8.repositories;

import com.fpoly.helloworldsd19201.buoi8.entity.BacSi;
import com.fpoly.helloworldsd19201.buoi8.entity.PhongKham;
import com.fpoly.helloworldsd19201.buoi8.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class PhongKhamRepository {
    public ArrayList<PhongKham> getAll() {
        ArrayList<PhongKham> danhSach = new ArrayList<>();
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            danhSach = (ArrayList<PhongKham>) session.createQuery("FROM PhongKham").list();
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
