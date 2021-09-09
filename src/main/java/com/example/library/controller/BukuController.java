package com.example.library.controller;

import java.util.List;

import com.example.library.entity.Buku;
import com.example.library.service.BukuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buku")
public class BukuController {
    @Autowired
    private BukuService bukuService;
    
    // public BukuController(BukuService bukuService) {
    //     this.bukuService = bukuService;
    // }

    @GetMapping("")
    public List<Buku> getAllBuku() {
        return bukuService.getAllBuku();
    }

    @GetMapping("/id/{bukuId}")
    public Buku getBukuById(@PathVariable(name = "bukuId") Long bukuId) {
        return bukuService.getBukuById(bukuId);
    }

    @GetMapping("/judul/{judul}")
    public List<Buku> getBukuByJudul(@PathVariable(name = "judul") String judul) {
        return bukuService.getBukuByJudul(judul);
    }
    
    @GetMapping("/penerbit/{penerbit}")
    public List<Buku> getBukuByPenerbit(@PathVariable(name = "penerbit") String penerbit) {
        return bukuService.getBukuByPenerbit(penerbit);
    }

    @PostMapping("")
    public void addBuku(@RequestBody final Buku buku) {
        bukuService.addBuku(buku);
    }
    
    @DeleteMapping("/id/{bukuId}")
    public void deleteBuku(@PathVariable(name = "bukuId") Long bukuId) {
        bukuService.deleteBuku(bukuId);
    }

    @PutMapping("/id/{bukuId}")
    public void updateBuku(@PathVariable(name = "bukuId") Long bukuId, @RequestBody Buku buku) {
        bukuService.updateBuku(bukuId, buku);
    }
}
