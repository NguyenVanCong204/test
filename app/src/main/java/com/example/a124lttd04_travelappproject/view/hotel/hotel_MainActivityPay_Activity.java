package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.tour.tour_DatVe_ThanhToan_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_ThanhToanThanhCong_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Voucher;

public class hotel_MainActivityPay_Activity extends AppCompatActivity {
    TextView Voucher;
    private ImageView imageView;
    private String tenKhachSan;
    private String tenPhong;
    private int soNguoi;
    private int soPhong;
    private TextView tvTotalPrice;
    private TextView tvCheckIn;
    private TextView tvCheckOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel_activity_main_pay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("HotelData", MODE_PRIVATE);

        tenKhachSan = sharedPreferences.getString("tenKhachSan", "");
        tenPhong = sharedPreferences.getString("tenPhong","");
        soNguoi = sharedPreferences.getInt("soNguoi",0);

        TextView tv_tenkhachsan_tt = findViewById(R.id.tv_tenkhachsan_tt);
        tv_tenkhachsan_tt.setText(tenKhachSan);
        TextView tv_tenphong_tt = findViewById(R.id.tv_tenphong_tt);
        tv_tenphong_tt.setText(tenPhong);
        TextView tv_songuoi_tt = findViewById(R.id.tv_songuoi_tt);
        tv_songuoi_tt.setText(String.valueOf( "Số người: " + soNguoi) );


        Intent intent = getIntent();
        if (intent != null) {
            String checkInDate = intent.getStringExtra("checkInDate");
            String checkOutDate = intent.getStringExtra("checkOutDate");
            String totalPrice = intent.getStringExtra("totalPrice");

            // Hiển thị dữ liệu lên giao diện (ví dụ: TextView)
             tvCheckIn = findViewById(R.id.tv_ngaydat_tt);
             tvCheckOut = findViewById(R.id.tv_ngaytra_tt);
             tvTotalPrice = findViewById(R.id.tv_tongtien_tt);

            tvCheckIn.setText("Ngày nhận phòng: " + checkInDate);
            tvCheckOut.setText("Ngày trả phòng: " + checkOutDate);
            tvTotalPrice.setText(totalPrice);


            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("checkInDate", checkInDate);   // Lưu ngày nhận phòng
            editor.putString("checkOutDate", checkOutDate); // Lưu ngày trả phòng
            editor.apply();
        }



        imageView = findViewById(R.id.img_back_pay);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainActivityPay_Activity.this, hotel_MainInf_Activity.class);
                startActivity(intent);
            }
        });

        // Chuyển sang trang voucher
        Voucher=findViewById(R.id.voucher);
        Voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tongtien = tvTotalPrice.getText().toString();
                Intent m = new Intent(hotel_MainActivityPay_Activity.this, hotel_Voucher.class);
                m.putExtra("tongtien",tongtien);// Kiểm tra lớp đích
                startActivity(m);
            }
        });

        Button thanhToanThanhCong = findViewById(R.id.thanhtoanthanhcong);
        thanhToanThanhCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainActivityPay_Activity.this, tour_ThanhToanThanhCong_Activity.class);
                startActivity(intent);
            }
        });
    }
}