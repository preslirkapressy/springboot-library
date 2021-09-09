package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Pelanggan;
import com.example.library.repository.PelangganRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PelangganService {
    @Autowired
    public PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggan() {
        return pelangganRepository.findAll();
    }

    public Pelanggan getPelangganById(Long pelangganId) {
        Optional<Pelanggan> pelanggan = pelangganRepository.findById(pelangganId);

        if (pelanggan.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }
        return pelanggan.get();
    }

    public List<Pelanggan> getPelangganByNama(String pelanggannama) {
        List<Pelanggan> pelanggan = pelangganRepository.findByNAMAContainingIgnoreCase(pelanggannama);

        if(pelanggan.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching Nama was found!");
        }

        return pelanggan;
    }

    public void addPelanggan(Pelanggan pelanggan) {
        Optional<Pelanggan> kodePelanggan = pelangganRepository.findByKODEPELIgnoreCase(pelanggan.getKODEPEL());
        Optional<Pelanggan> emailPelanggan = pelangganRepository.findByEMAILIgnoreCase(pelanggan.getEMAIL());

        if (kodePelanggan.isPresent() || emailPelanggan.isPresent()) { 
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Pelanggan with matching kode pelanggan and email was found!");
        }
        pelangganRepository.save(pelanggan);
        throw new ResponseStatusException(HttpStatus.OK, "Pelanggan was added!");
    }

    public void deletePelanggan(Long pelangganId) {
        Optional<Pelanggan> tempPelanggan = pelangganRepository.findById(pelangganId);

        if (tempPelanggan.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching Pelanggan was found!");
        }
        pelangganRepository.deleteById(pelangganId);
        throw new ResponseStatusException(HttpStatus.OK, "Pelanggan was successfully removed!");
    }

    public void updatePelanggan(Pelanggan pelanggan) {
        Optional<Pelanggan> tempPelanggan = pelangganRepository.findById(pelanggan.getID());

        if (tempPelanggan.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching pelanggan was found!");
        }
        pelangganRepository.save(pelanggan);
        throw new ResponseStatusException(HttpStatus.OK, "Pelanggan was successfully updated!");
    }
}
