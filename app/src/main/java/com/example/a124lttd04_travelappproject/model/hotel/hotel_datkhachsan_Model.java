package com.example.a124lttd04_travelappproject.model.hotel;

import java.math.BigDecimal;
import java.util.Date;

public class hotel_datkhachsan_Model {
    private  Integer madatphong;
    private String ngaydat;
    private String ngaytra;
    private int sophongdat;
    private BigDecimal tongtien;
    private int makh;
    private int maphong;

    public hotel_datkhachsan_Model(Integer madatphong,  String ngaydat, String ngaytra, int sophongdat, BigDecimal tongtien ,int makh, int maphong) {
        this.madatphong = madatphong;
        this.makh = makh;
        this.maphong = maphong;
        this.ngaydat = ngaydat;
        this.ngaytra = ngaytra;
        this.sophongdat = sophongdat;
        this.tongtien = tongtien;
    }

    public Integer getMadatphong() {
        return madatphong;
    }

    public void setMadatphong(Integer madatphong) {
        this.madatphong = madatphong;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public int getMaphong() {
        return maphong;
    }

    public void setMaphong(int maphong) {
        this.maphong = maphong;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public int getSophongdat() {
        return sophongdat;
    }

    public void setSophongdat(int sophongdat) {
        this.sophongdat = sophongdat;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "hotel_datkhachsan_Model{" +
                "madatphong=" + madatphong +
                ", ngaydat=" + ngaydat +
                ", ngaytra=" + ngaytra +
                ", sophongdat=" + sophongdat +
                ", tongtien=" + tongtien +
                ", makh=" + makh +
                ", maphong=" + maphong +
                '}';
    }
}
