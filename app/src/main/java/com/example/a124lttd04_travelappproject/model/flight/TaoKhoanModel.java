package com.example.a124lttd04_travelappproject.model.flight;

public class TaoKhoanModel {
<<<<<<< HEAD
    private  int makh;
=======
    private int makh;
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
    private String taikhoan;
    private  String matkhau;

    public TaoKhoanModel() {
    }

<<<<<<< HEAD
    public TaoKhoanModel(String taikhoan, String matkhau) {
=======
    public TaoKhoanModel(int makh, String taikhoan, String matkhau) {
        this.makh = makh;
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

<<<<<<< HEAD
=======
    @Override
    public String toString() {
        return "TaoKhoanModel{" +
                "makh=" + makh +
                ", taikhoan='" + taikhoan + '\'' +
                ", matkhau='" + matkhau + '\'' +
                '}';
    }

>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
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

<<<<<<< HEAD
    @Override
    public String toString() {
        return "TaoKhoanModel{" +
                "taikhoan='" + taikhoan + '\'' +
                ", matkhau='" + matkhau + '\'' +
                '}';
    }
=======
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
}
