package com.example.a124lttd04_travelappproject.model.flight;

public class TaoKhoanModel {
    private  int makh;
    private String taikhoan;
    private  String matkhau;

    public TaoKhoanModel() {
    }

    public TaoKhoanModel(String taikhoan, String matkhau) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "TaoKhoanModel{" +
                "taikhoan='" + taikhoan + '\'' +
                ", matkhau='" + matkhau + '\'' +
                '}';
    }
}
