package com.fpoly.helloworldsd19201.buoi5.controller;

import com.fpoly.helloworldsd19201.buoi5.entity.GiangVien;
import com.fpoly.helloworldsd19201.buoi5.service.GiangVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "GiangVienController", value = {
        "/giang-vien/hien-thi",
        "/giang-vien/view-add",
        "/giang-vien/view-update",
        "/giang-vien/detail",
        "/giang-vien/delete",
        "/giang-vien/add",
        "/giang-vien/update",
})
public class GiangVienController extends HttpServlet {
    private GiangVienService service = new GiangVienService();

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
            showDetail(req, resp);
        } else if(uri.contains("delete")) {
            deleteGiangVien(req, resp);
        }
    }

    private void deleteGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        service.deleteGiangVien(req.getParameter("id"));
        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("giangVien", service.getByMaGiangVien(req.getParameter("id")));
        req.getRequestDispatcher("/buoi5/detail.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("giangVien", service.getByMaGiangVien(req.getParameter("id")));
        req.getRequestDispatcher("/buoi5/update.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/buoi5/add.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", service.getAll());
        req.getRequestDispatcher("/buoi5/hien-thi.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addGiangVien(req, resp);
        } else {
            updateGiangVien(req, resp);
        }
    }

    private void updateGiangVien(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        GiangVien gv = new GiangVien();
//        BeanUtils.populate(gv, req.getParameterMap());

        gv.setMaGiangVien(req.getParameter("maGiangVien"));
        gv.setDiaChi(req.getParameter("diaChi"));
        gv.setLuong(Float.valueOf(req.getParameter("luong")));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(req.getParameter("ngaySinh"), formatter);
        gv.setNgaySinh(date);

        gv.setGioiTinh(Boolean.valueOf(req.getParameter("gioiTinh")));

        service.updateGiangVien(gv);
        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void addGiangVien(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        GiangVien gv = new GiangVien();
//        BeanUtils.populate(gv, req.getParameterMap());

        gv.setMaGiangVien(req.getParameter("maGiangVien"));
        gv.setDiaChi(req.getParameter("diaChi"));
        gv.setLuong(Float.valueOf(req.getParameter("luong")));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(req.getParameter("ngaySinh"), formatter);
        gv.setNgaySinh(date);

        gv.setGioiTinh(Boolean.valueOf(req.getParameter("gioiTinh")));

        service.addGiangVien(gv);
        resp.sendRedirect("/giang-vien/hien-thi");
    }
}
