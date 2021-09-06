package com.example.library.controller;

import java.util.List;

import com.example.library.entity.SewaDetail;
import com.example.library.service.SewaDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sewadetail")
public class SewaDetailController {
    @Autowired
    private SewaDetailService sewaDetailService;

    // @GetMapping("")
    // public List<SewaDetail> getAllBSewaDetail() {
    //     return sewaDetailService.getAllSewaDetail();
    // }

    @GetMapping("")
    public List<SewaDetail> getAllSewaDetail() {
        return sewaDetailService.getAllSewaDetail();
    }

    @GetMapping("/id/{sewaId}")
    public SewaDetail getSewaDetailById(@PathVariable(name = "sewaId") Long sewaId) {
        return sewaDetailService.getSewaDetailById(sewaId);
    }
}
