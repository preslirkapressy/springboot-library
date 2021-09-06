package com.example.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class SewaDetail {
    @Id
    @SequenceGenerator(name = "SEWA_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "SEWA_SEQ", strategy = GenerationType.SEQUENCE)
    private Long ID;

    @Column    
    private String TGLSEWA;

    @Column
    private Long LAMASEWA;

    @Column
    private String KETERANGAN;

    @Column
    private String ISBN;

    @Column
    private String JUDUL;

    @Column
    private String PENGARANG;

    @Column
    private String KODEPEL;

    @Column
    private String NAMA;

    @Column
    private String TELP;

    @Column
    private String EMAIL;


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTGLSEWA() {
        return this.TGLSEWA;
    }

    public void setTGLSEWA(String TGLSEWA) {
        this.TGLSEWA = TGLSEWA;
    }

    public Long getLAMASEWA() {
        return this.LAMASEWA;
    }

    public void setLAMASEWA(Long LAMASEWA) {
        this.LAMASEWA = LAMASEWA;
    }

    public String getKETERANGAN() {
        return this.KETERANGAN;
    }

    public void setKETERANGAN(String KETERANGAN) {
        this.KETERANGAN = KETERANGAN;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getJUDUL() {
        return this.JUDUL;
    }

    public void setJUDUL(String JUDUL) {
        this.JUDUL = JUDUL;
    }

    public String getPENGARANG() {
        return this.PENGARANG;
    }

    public void setPENGARANG(String PENGARANG) {
        this.PENGARANG = PENGARANG;
    }

    public String getKODEPEL() {
        return this.KODEPEL;
    }

    public void setKODEPEL(String KODEPEL) {
        this.KODEPEL = KODEPEL;
    }

    public String getNAMA() {
        return this.NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getTELP() {
        return this.TELP;
    }

    public void setTELP(String TELP) {
        this.TELP = TELP;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

}
