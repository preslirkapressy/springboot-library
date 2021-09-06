package com.example.library.repository;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Buku;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long>{
    List<Buku> findByJUDULContaining(String judul);
    List<Buku> findByJUDULContainingIgnoreCase(String judul);
    List<Buku> findByPENERBITContaining(String penerbit);
    List<Buku> findByPENERBITContainingIgnoreCase(String penerbit);

    Optional<Buku> findByISBNIgnoreCase(String ISBN);
    
}
