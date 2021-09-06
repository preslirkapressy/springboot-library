package com.example.library.repository;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.SewaDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SewaDetailRepository extends JpaRepository<SewaDetail, Long> {
    
    @Query(value = 
    "SELECT "
    + "S.ID, S.TGLSEWA, S.LAMASEWA, S.KETERANGAN, "
    + "S.ISBN, B.JUDUL, B.PENGARANG, "
    + "S.PELANGGANID, P.KODEPEL, P.NAMA, P.TELP, P.EMAIL "
    + "FROM SEWA S "
    + "INNER JOIN BUKU B ON S.ISBN = B.ISBN "
    + " INNER JOIN PELANGGAN P ON S.PELANGGANID = P.ID "
    , nativeQuery = true)
    public List<SewaDetail>getAllSewaDetail();
    
    @Query(value = 
        "SELECT "
        + "S.ID, S.TGLSEWA, S.LAMASEWA, S.KETERANGAN, "
        + "S.ISBN, B.JUDUL, B.PENGARANG, "
        + "S.PELANGGANID, P.KODEPEL, P.NAMA, P.TELP, P.EMAIL "
        + "FROM SEWA S "
        + "INNER JOIN BUKU B ON S.ISBN = B.ISBN "
        + " INNER JOIN PELANGGAN P ON S.PELANGGANID = P.ID "
        + "WHERE S.ID=:sewaId", nativeQuery = true)
        
        Optional<SewaDetail>getSewaDetailById(@Param("sewaId") Long sewaId);
}
