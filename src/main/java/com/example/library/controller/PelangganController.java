package com.example.library.controller;

import java.util.List;

import com.example.library.entity.Pelanggan;
import com.example.library.service.PelangganService;

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
@RequestMapping("/pelanggan")
public class PelangganController {
    @Autowired
    private PelangganService pelangganService;


    // public PelangganController(PelangganService pelangganService) {
    //     this.pelangganService = pelangganService;
    // }

    @GetMapping("")
    public List<Pelanggan> getAllPelanggan() {
        return pelangganService.getAllPelanggan();
    }

    @GetMapping("/id/{pelangganId}")
    public Pelanggan getPelangganById(@PathVariable(name = "pelangganId") Long pelangganId) {
        return pelangganService.getPelangganById(pelangganId);
    }

    @GetMapping("/pelanggannama/{pelanggannama}")
    public List<Pelanggan> getPelangganByName(@PathVariable(name = "pelanggannama") String pelanggannama) {
        return pelangganService.getPelangganByNama(pelanggannama);
    }

    @PostMapping("")
    public void addPelanggan(@RequestBody final Pelanggan pelanggan) {
        pelangganService.addPelanggan(pelanggan);
    }
    
    @DeleteMapping("/id/{pelangganId}")
    public void deletePelanggan(@PathVariable(name = "pelangganId") Long pelangganId){
        pelangganService.deletePelanggan(pelangganId);
    }

    @PutMapping("")
    public void updatepelanggan(@RequestBody Pelanggan pelanggan) {
        pelangganService.updatePelanggan(pelanggan);
    }
    
        
}
