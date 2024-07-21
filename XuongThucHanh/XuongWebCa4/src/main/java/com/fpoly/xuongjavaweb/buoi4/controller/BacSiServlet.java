package com.fpoly.xuongjavaweb.buoi4.controller;

import com.fpoly.xuongjavaweb.buoi4.entity.BacSi;
import com.fpoly.xuongjavaweb.buoi4.repositories.BacSiRepository;
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
        "/bac-si/delete",
        "/bac-si/view-update",
        "/bac-si/view-detail",
        "/bac-si/add",
        "/bac-si/update"

})
public class BacSiServlet extends HttpServlet {
    BacSiRepository bacSiRepository = new BacSiRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("view-detail")) {
            viewDetail(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addBacSi(req, resp);
        } else if(uri.contains("update")) {
            updateBacSi(req, resp);
        }
    }

    private void updateBacSi(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        BacSi bs = new BacSi();
        BeanUtils.populate(bs, req.getParameterMap());
        System.out.println(bs.toString());
        bacSiRepository.updateBacSi(bs);
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void addBacSi(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        BacSi bs = new BacSi();
        BeanUtils.populate(bs, req.getParameterMap());
        bacSiRepository.addBacSi(bs);
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void viewDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bs", bacSiRepository.getById(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/buoi4/view-detail.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bs", bacSiRepository.getById(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/buoi4/view-update.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Cach 1 - ngan hon, chay cham hon
//        BacSi bs = bacSiRepository.getById(Integer.valueOf(req.getParameter("id")));
//        bacSiRepository.deleteBacSi(bs);

        // Cach 2 - dai hon, chay nhanh hon
        BacSi bs = new BacSi();
        bs.setId(Integer.valueOf(req.getParameter("id")));
        bacSiRepository.deleteBacSi(bs);
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", bacSiRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }
}
