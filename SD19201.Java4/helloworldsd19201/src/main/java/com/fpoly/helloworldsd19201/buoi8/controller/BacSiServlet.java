package com.fpoly.helloworldsd19201.buoi8.controller;

import com.fpoly.helloworldsd19201.buoi8.entity.BacSi;
import com.fpoly.helloworldsd19201.buoi8.entity.PhongKham;
import com.fpoly.helloworldsd19201.buoi8.repositories.BacSiRepository;
import com.fpoly.helloworldsd19201.buoi8.repositories.PhongKhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "BacSiServlet", value = {
        "/bac-si/hien-thi",
        "/bac-si/view-add",
        "/bac-si/view-update",
        "/bac-si/add",
        "/bac-si/update",
        "/bac-si/delete",
        "/bac-si/detail",
        "/bac-si/search",
        "/bac-si/paging"
})
public class BacSiServlet extends HttpServlet {
    private final int PAGE_SIZE = 5;
    BacSiRepository bacSiRepository = new BacSiRepository();
    PhongKhamRepository phongKhamRepository = new PhongKhamRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-add")) {
            viewAdd(req,resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req,resp);
        } else if(uri.contains("delete")) {
            delete(req,resp);
        } else if(uri.contains("detail")) {
            detail(req,resp);
        } else if(uri.contains("search")) {
            search(req, resp);
        } else if(uri.contains("paging")) {
            hienThiPaging(req, resp);
        }
    }

    private void hienThiPaging(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = 1;
        if(req.getParameter("page") != null) {
            pageNo = Integer.valueOf(req.getParameter("page"));
        }
        req.setAttribute("pageNo", pageNo);
        req.setAttribute("danhSach", bacSiRepository.getAllPaging(pageNo, PAGE_SIZE));
        req.getRequestDispatcher("/buoi8/hien-thi.jsp").forward(req, resp);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", bacSiRepository.searchByTen(req.getParameter("ten")));
        req.getRequestDispatcher("/buoi8/hien-thi.jsp").forward(req, resp);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bs", bacSiRepository.getDetailBacSi(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/buoi8/detail.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bacSiRepository.deleteBacSi(new BacSi(Integer.valueOf(req.getParameter("id")), null, null, null));
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSachPhongKham", phongKhamRepository.getAll());
        req.setAttribute("bs", bacSiRepository.getDetailBacSi(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/buoi8/view-update.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSachPhongKham", phongKhamRepository.getAll());
        req.getRequestDispatcher("/buoi8/view-add.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", bacSiRepository.getAll());
        req.getRequestDispatcher("/buoi8/hien-thi.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            add(req, resp);
        } else if(uri.contains("update")) {
            update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        BacSi bs = new BacSi();
        bs.setTen(req.getParameter("ten"));
        bs.setTuoi(Integer.valueOf(req.getParameter("tuoi")));
        bs.setId(Integer.valueOf(req.getParameter("id")));
        PhongKham pk = new PhongKham();
        pk.setId(Integer.valueOf(req.getParameter("phongKham")));
        bs.setPhongKham(pk);
        bacSiRepository.updateBacSi(bs);
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        BacSi bs = new BacSi();
        String ten = req.getParameter("ten");
        String tuoiString = req.getParameter("tuoi");
        // flag = 0: Khong loi
        // flag = 1: Co loi
        int flag = 0;
        if(ten.trim().length() == 0) {
            req.setAttribute("errorTen", "Vui long nhap ten");
            flag = 1;
        }
        if(tuoiString.length() == 0) {
            req.setAttribute("errorTuoi", "Vui long nhap tuoi");
            flag = 1;
        }
        if(flag == 1) {
            req.setAttribute("danhSachPhongKham", phongKhamRepository.getAll());
            req.getRequestDispatcher("/buoi8/view-add.jsp").forward(req, resp);
        }

        bs.setTen(ten);
        bs.setTuoi(Integer.valueOf(tuoiString));
        PhongKham pk = new PhongKham();
        pk.setId(Integer.valueOf(req.getParameter("phongKham")));
        bs.setPhongKham(pk);
        bacSiRepository.addBacSi(bs);
        resp.sendRedirect("/bac-si/hien-thi");
    }
}
