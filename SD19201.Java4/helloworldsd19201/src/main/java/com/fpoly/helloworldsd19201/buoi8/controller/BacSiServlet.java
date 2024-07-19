package com.fpoly.helloworldsd19201.buoi8.controller;

import com.fpoly.helloworldsd19201.buoi8.entity.BacSi;
import com.fpoly.helloworldsd19201.buoi8.repositories.BacSiRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BacSiServlet", value = {
        "/bac-si/hien-thi"
})
public class BacSiServlet extends HttpServlet {
    BacSiRepository bacSiRepository = new BacSiRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", bacSiRepository.getAll());
        req.getRequestDispatcher("/buoi8/hien-thi.jsp").forward(req, resp);
    }
}
