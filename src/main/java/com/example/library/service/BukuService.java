package com.example.library.service;


import java.util.List;
import java.util.Optional;


import com.example.library.entity.Buku;
import com.example.library.repository.BukuRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository; 


    // public BukuService(BukuRepository bukuRepository) {
    //     this.bukuRepository = bukuRepository;
    // }


    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }


    public Buku getBukuById(Long bukuId) {
        Optional<Buku> buku = bukuRepository.findById(bukuId);
        
        if (buku.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }


        return buku.get();
    }


    public List<Buku> getBukuByJudul(String judul) {
        List<Buku> buku = bukuRepository.findByJUDULContainingIgnoreCase(judul);


        if (buku.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }


        return buku;
    }


    public List<Buku> getBukuByPenerbit(String penerbit) {
        List<Buku> buku = bukuRepository.findByPENERBITContainingIgnoreCase(penerbit);


        if (buku.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching penerbit was found!");
        }


        return buku;
    }


    public void addBuku(Buku buku) {
        Optional<Buku> tempBuku = bukuRepository.findByISBNIgnoreCase(buku.getISBN());
        if (tempBuku.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Buku with matching ISBN was found!");
        }
        bukuRepository.save(buku);
        throw new ResponseStatusException(HttpStatus.OK, "Buku was added!");
    }


    public void deleteBuku(Long bukuId) {
        Optional<Buku> buku = bukuRepository.findById(bukuId);


        if (buku.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching buku was found!");
        }
        bukuRepository.deleteById(bukuId);
        throw new ResponseStatusException(HttpStatus.OK, "Buku was successfully removed!");
    }


    public void updateBuku(Long bukuId, Buku buku) {
        Optional<Buku> tempBuku = bukuRepository.findById(bukuId);


        if (tempBuku.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching buku was found!");
        }
        bukuRepository.save(buku);
        throw new ResponseStatusException(HttpStatus.OK, "Buku was successfully updated!");
    }
}