package com.fpoly.xuongjavaweb.buoi4.repositories;

import com.fpoly.xuongjavaweb.buoi4.entity.BacSi;
import com.fpoly.xuongjavaweb.buoi4.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;

public class BacSiRepository {
    public ArrayList<BacSi> getAll() {
        ArrayList<BacSi> danhSach;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            // Cach 1:
//            Query query = session.createQuery("FROM BacSi");
//            danhSach = (ArrayList<BacSi>) query.getResultList();
            // Cach 2:
            danhSach = (ArrayList<BacSi>) session.createQuery("FROM BacSi").list();
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BacSi getById(int id) {
        BacSi bs = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            bs = session.get(BacSi.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bs;
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
