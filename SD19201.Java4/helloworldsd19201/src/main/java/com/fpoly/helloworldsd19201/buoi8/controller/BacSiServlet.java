package com.fpoly.helloworldsd19201.buoi8.controller;

import com.fpoly.helloworldsd19201.buoi8.entity.BacSi;
import com.fpoly.helloworldsd19201.buoi8.repositories.BacSiRepository;
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
        "/bac-si/detail"
})
public class BacSiServlet extends HttpServlet {
    BacSiRepository bacSiRepository = new BacSiRepository();

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
        }
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
        req.setAttribute("bs", bacSiRepository.getDetailBacSi(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/buoi8/view-update.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        BeanUtils.populate(bs, req.getParameterMap());
        bacSiRepository.updateBacSi(bs);
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        BacSi bs = new BacSi();
        BeanUtils.populate(bs, req.getParameterMap());
        bacSiRepository.addBacSi(bs);
        resp.sendRedirect("/bac-si/hien-thi");
    }
}
