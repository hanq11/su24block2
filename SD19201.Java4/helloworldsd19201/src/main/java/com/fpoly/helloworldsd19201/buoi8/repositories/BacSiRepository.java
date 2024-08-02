package com.fpoly.helloworldsd19201.buoi8.repositories;

import com.fpoly.helloworldsd19201.buoi8.entity.BacSi;
import com.fpoly.helloworldsd19201.buoi8.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class BacSiRepository {
    public ArrayList<BacSi> getAll() {
        ArrayList<BacSi> danhSach = new ArrayList<>();
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            danhSach = (ArrayList<BacSi>) session.createQuery("FROM BacSi").list();
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<BacSi> searchByTen(String ten) {
        ArrayList<BacSi> danhSach = new ArrayList<>();
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM BacSi WHERE ten like :ten");
            query.setParameter("ten", "%" + ten + "%");
            danhSach = (ArrayList<BacSi>) query.list();
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addBacSi(BacSi bs) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(bs);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public BacSi getDetailBacSi(int id) {
        BacSi bacSi = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            bacSi = session.get(BacSi.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bacSi;
    }
    public void updateBacSi(BacSi bs) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(bs);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void deleteBacSi(BacSi bs) {
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(bs);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
