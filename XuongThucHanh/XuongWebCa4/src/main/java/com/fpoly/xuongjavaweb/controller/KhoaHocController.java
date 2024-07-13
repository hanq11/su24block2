package com.fpoly.xuongjavaweb.controller;

import com.fpoly.xuongjavaweb.entity.KhoaHoc;
import com.fpoly.xuongjavaweb.service.KhoaHocService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "KhocHocController", value = {
        "/khoa-hoc/hien-thi",
        "/khoa-hoc/view-add",
        "/khoa-hoc/view-update",
        "/khoa-hoc/detail",
        "/khoa-hoc/delete",
        "/khoa-hoc/add",
        "/khoa-hoc/update",
        "/khoa-hoc/search"
})
public class KhoaHocController extends HttpServlet {
    KhoaHocService service = new KhoaHocService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-add")) {
            viewAdd(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("detail")) {
            detail(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        } else if(uri.contains("search")) {
            search(req, resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", service.searchKhoaHoc(req.getParameter("ten")));
        req.getRequestDispatcher("/buoi2/hien-thi.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        service.deleteKhoaHoc(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect("/khoa-hoc/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("khoaHoc", service.getDetail(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/buoi2/detail.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("khoaHoc", service.getDetail(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/buoi2/view-update.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/buoi2/view-add.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", service.getAll());
        req.getRequestDispatcher("/buoi2/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addKhoaHoc(req, resp);
        } else if(uri.contains("update")) {
            updateKhoaHoc(req, resp);
        }
    }

    private void updateKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        float hocPhi = Float.valueOf(req.getParameter("hocPhi"));
        String ten = req.getParameter("ten");
        boolean kho = Boolean.valueOf(req.getParameter("kho"));
        String boMon = req.getParameter("boMon");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(req.getParameter("ngayNhapHoc"), formatter);
        KhoaHoc kh = new KhoaHoc(id, hocPhi, ten, kho, boMon, date);
        service.updateKhoaHoc(kh);
        resp.sendRedirect("/khoa-hoc/hien-thi");
    }

    private void addKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        float hocPhi = Float.valueOf(req.getParameter("hocPhi"));
        String ten = req.getParameter("ten");
        boolean kho = Boolean.valueOf(req.getParameter("kho"));
        String boMon = req.getParameter("boMon");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(req.getParameter("ngayNhapHoc"), formatter);
        KhoaHoc kh = new KhoaHoc(id, hocPhi, ten, kho, boMon, date);
        service.addKhoaHoc(kh);
        resp.sendRedirect("/khoa-hoc/hien-thi");
    }
}
