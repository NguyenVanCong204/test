package com.example.a124lttd04_travelappproject.model.flight;

public class DatVeMayBayModel {
    private float tongtien;
    private int soluongve;
    private int makh;
    private  int mavemaybay;
    private  int mahanhly;

    public DatVeMayBayModel() {
    }

    public DatVeMayBayModel(int soluogve, float tongtien, int makh, int mavemaybay, int mahanhly) {
        this.soluongve = soluogve;
        this.tongtien = tongtien;
        this.makh = makh;
        this.mavemaybay = mavemaybay;
        this.mahanhly = mahanhly;
    }

    public int getSoluogve() {
        return soluongve;
    }

    public void setSoluogve(int soluogve) {
        this.soluongve = soluogve;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public int getMavemaybay() {
        return mavemaybay;
    }

    public void setMavemaybay(int mavemaybay) {
        this.mavemaybay = mavemaybay;
    }

    public int getMahanhly() {
        return mahanhly;
    }

    public void setMahanhly(int mahanhly) {
        this.mahanhly = mahanhly;
    }
    @Override
    public String toString() {
        return "DatVeMayBayModel{" +
                "soluogve=" + soluongve +
                ", tongtien=" + tongtien +
                ", makh=" + makh +
                ", mavemaybay=" + mavemaybay +
                ", mahanhly=" + mahanhly +
                '}';
    }
}
