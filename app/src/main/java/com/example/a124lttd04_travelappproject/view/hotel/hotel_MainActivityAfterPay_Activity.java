package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.api.ApiServer;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_datkhachsan_Model;
import com.example.a124lttd04_travelappproject.view.tour.tour_ThanhToanThanhCong_Activity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;

public class hotel_MainActivityAfterPay_Activity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tongTien;
    private TextView tenVoucher;
    private String tenKhachSan;
    private String tenPhong;
    private int soNguoi;
    private String ngaydatphong;
    private String ngaytraphong;
    private BigDecimal tongtienBigDecimal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_activity_main_afterpay);

        // Áp dụng Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.img_back_pay);
        imageView.setOnClickListener(view -> {
            Intent intent = new Intent(hotel_MainActivityAfterPay_Activity.this, hotel_MainInf_Activity.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        String tongtien = intent.getStringExtra("tongtien");
        String tenvoucher = intent.getStringExtra("tenvoucher");
        tongTien = findViewById(R.id.tv_tongtien_after);
        tenVoucher = findViewById(R.id.tv_tenvoucher_after);
        tongTien.setText(tongtien);
        tenVoucher.setText(tenvoucher);

        // Lấy dữ liệu từ SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("HotelData", MODE_PRIVATE);
        tenKhachSan = sharedPreferences.getString("tenKhachSan", "");
        tenPhong = sharedPreferences.getString("tenPhong", "");
        soNguoi = sharedPreferences.getInt("soNguoi", 0);
        ngaydatphong = sharedPreferences.getString("checkInDate", "");
        ngaytraphong = sharedPreferences.getString("checkOutDate", "");

        TextView tv_tenkhachsan_tt = findViewById(R.id.tv_tenkhachsan_tt);
        tv_tenkhachsan_tt.setText(tenKhachSan);
        TextView tv_tenphong_tt = findViewById(R.id.tv_tenphong_tt);
        tv_tenphong_tt.setText(tenPhong);
        TextView tv_songuoi_tt = findViewById(R.id.tv_songuoi_tt);
        tv_songuoi_tt.setText("Số người: " + soNguoi);
        TextView tv_ngaydat = findViewById(R.id.tv_ngaydat_tt);
        TextView tv_ngaytra = findViewById(R.id.tv_ngaytra_tt);
        tv_ngaydat.setText("Ngày đặt phòng: " + ngaydatphong);
        tv_ngaytra.setText("Ngày trả phòng: " + ngaytraphong);

        // Lấy mã khách hàng và mã phòng
        SharedPreferences sharedPreferences1 = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int makh = sharedPreferences1.getInt("makh", 1);
        int maphong = sharedPreferences1.getInt("maphong", 1);

        // Định dạng ngày (thay đổi nếu cần)
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");

        Date ngaydat = null;
        Date ngaytra = null;

        try {
            // Chuyển đổi chuỗi sang Date
            ngaydat = sdfInput.parse(ngaydatphong);
            ngaytra = sdfInput.parse(ngaytraphong);

            // Định dạng lại ngày để hiển thị theo "yyyy-MM-dd"
            String formattedNgaydat = sdfOutput.format(ngaydat);
            String formattedNgaytra = sdfOutput.format(ngaytra);

            // Hiển thị ngày đã được định dạng
            tv_ngaydat.setText("Ngày đặt phòng: " + formattedNgaydat);
            tv_ngaytra.setText("Ngày trả phòng: " + formattedNgaytra);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Chuyển đổi chuỗi tongtien sang BigDecimal
        try {
            String cleanedString = tongtien.replaceAll("[^\\d.]", ""); // Loại bỏ dấu phẩy và ký tự không phải số
            tongtienBigDecimal = new BigDecimal(cleanedString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Xử lý sự kiện khi nhấn nút Thanh toán
        Button thanhToanThanhCong = findViewById(R.id.thanhtoanthanhcong);
        Date finalNgaydat = ngaydat;
        Date finalNgaytra = ngaytra;
        thanhToanThanhCong.setOnClickListener(view -> {
            // Gọi API để thêm dữ liệu
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String formattedNgaydat = sdf.format(finalNgaydat);
            String formattedNgaytra = sdf.format(finalNgaytra);
            hotel_datkhachsan_Model datkhachsanModel = new hotel_datkhachsan_Model(
                    null,       // Không truyền madatphong
                    formattedNgaydat,    // Đã chuyển đổi sang Date
                    formattedNgaytra,    // Đã chuyển đổi sang Date
                    1,          // Số phòng đặt
                    tongtienBigDecimal,     // Tổng tiền
                    makh,       // Mã khách hàng
                    maphong     // Mã phòng
            );
            Log.d("InsertData", "Data to insert: " + datkhachsanModel.toString());
            ApiServer.apiServer.insert(datkhachsanModel).enqueue(new Callback<hotel_response_Model>() {
                @Override
                public void onResponse(Call<hotel_response_Model> call, retrofit2.Response<hotel_response_Model> response) {
                    if (response.isSuccessful()) {
                        hotel_response_Model responseBody = response.body();
                        Toast.makeText(hotel_MainActivityAfterPay_Activity.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                        int madatkhachsan = responseBody.getMadatkhachsan();
                        Intent intent = new Intent(hotel_MainActivityAfterPay_Activity.this, tour_ThanhToanThanhCong_Activity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(hotel_MainActivityAfterPay_Activity.this, "Insert failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<hotel_response_Model> call, Throwable t) {
                    Toast.makeText(hotel_MainActivityAfterPay_Activity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
