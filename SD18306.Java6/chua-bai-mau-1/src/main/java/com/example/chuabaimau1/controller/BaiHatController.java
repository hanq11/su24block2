package com.example.chuabaimau1.controller;

import com.example.chuabaimau1.entity.BaiHat;
import com.example.chuabaimau1.repository.BaiHatRepository;
import com.example.chuabaimau1.repository.CaSiRepository;
import com.example.chuabaimau1.request.BaiHatRequest;
import com.example.chuabaimau1.response.BaiHatResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BaiHatController {
    @Autowired
    BaiHatRepository baiHatRepository;

    @Autowired
    CaSiRepository caSiRepository;

    @GetMapping("/hien-thi")
    public List<BaiHat> getAll() {
        return baiHatRepository.findAll();
    }

    @GetMapping("/hien-thi-response")
    public List<BaiHatResponse> getAllResponse() {
        return baiHatRepository.getAllResponse();
    }

    @GetMapping("/phan-trang")
    public List<BaiHatResponse> phanTrang(@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage) {
        int size = 5;
        Pageable pageable = PageRequest.of(currentPage, size);
        return baiHatRepository.phanTrang(pageable).getContent();
    }

    @PostMapping("/add")
    public String add(@RequestBody @Valid BaiHatRequest baiHatRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "them loi";
        }
        BaiHat bh = new BaiHat();
        BeanUtils.copyProperties(baiHatRequest, bh);
        baiHatRepository.save(bh);
        return "them thanh cong";
    }

    @PutMapping("/update")
    public String update(@RequestBody @Valid BaiHatRequest baiHatRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "sua loi";
        }
        BaiHat bh = new BaiHat();
        BeanUtils.copyProperties(baiHatRequest, bh);
        baiHatRepository.save(bh);
        return "sua thanh cong";
    }
}
