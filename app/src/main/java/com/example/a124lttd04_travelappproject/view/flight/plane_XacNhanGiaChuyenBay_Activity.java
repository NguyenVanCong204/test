package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
=======
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.hotel.Taikhoan;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHotel_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_CoTheBanSeThich_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class plane_XacNhanGiaChuyenBay_Activity extends AppCompatActivity {
    Button xng;
    TextView xng1;
    TextView khoiluong;
<<<<<<< HEAD

    TextView TongTien;
    MaterialButton ThanhToan;
    Button Exit;
=======
    String TAG="//++";
    TextView TongTien;
    MaterialButton ThanhToan;
    Button Exit;

    EditText soluongvemua;
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plane_xacnhangiachuyenbay);
        xng=findViewById(R.id.themhanhly1);
        xng1=findViewById(R.id.themhanhly);
        ThanhToan=findViewById(R.id.thanhtoan);
        Exit=findViewById(R.id.exit);
        khoiluong=findViewById(R.id.khoiluong);
        TongTien=findViewById(R.id.tongtien);
<<<<<<< HEAD
=======
        soluongvemua=findViewById(R.id.soluongve);
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
<<<<<<< HEAD

=======
        soluongvemua.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Khi EditText được chọn, xóa văn bản
                    if (soluongvemua.getText().toString().equals("Nhập số lượng vé")) {
                        soluongvemua.setText("");
                        soluongvemua.setTextColor(Color.BLACK); // Đặt màu chữ nếu cần
                    }
                } else {
                    // Khi mất tiêu điểm, kiểm tra nếu rỗng thì đặt lại văn bản
                    if (soluongvemua.getText().toString().isEmpty()) {
                        soluongvemua.setText("Nhập số lượng vé");
                        soluongvemua.setTextColor(Color.parseColor("#A09F9F")); // Đặt lại màu chữ
                    }
                }
            }
        });
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
        String selectKhoiLuong= getIntent().getStringExtra("khoiluong");
        if (selectKhoiLuong != null) {
            khoiluong.setText(selectKhoiLuong); // Set the text of the TextView
        }
        String selectTongTien= getIntent().getStringExtra("Tongtien");
        if (selectTongTien != null) {
            if (selectTongTien.equals("230,000 VND")) {
<<<<<<< HEAD
                TongTien.setText("1,738,651 VND");
            }
            else if (selectTongTien.equals("420,000 VND")) {
                TongTien.setText("2,128,651 VND");
            }
            else if (selectTongTien.equals("490,000 VND")) {
                TongTien.setText("2,198,651 VND");
=======
                TongTien.setText("2,730,651 VND");
            }
            else if (selectTongTien.equals("420,000 VND")) {
                TongTien.setText("2,920,500 VND");
            }
            else if (selectTongTien.equals("490,000 VND")) {
                TongTien.setText("2,990,500 VND");
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
            }
        }


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        // Đặt mục action_hotel là mặc định
        bottomNavigationView.setSelectedItemId(R.id.action_plane);

        // Xử lý sự kiện nhấn trên từng mục
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    Intent intent = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, hotel_MainHotel_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, Taikhoan.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_ChonChuyenBay_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
        ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
=======

                String soluongText = soluongvemua.getText().toString().trim();
                int solv;
                try {
                    solv = Integer.parseInt(soluongText);
                } catch (NumberFormatException e) {
                    solv = 0; // Hoặc xử lý lỗi theo cách khác
                }

                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("soluongve", solv);
                editor.apply();

>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
                Context context = v.getContext(); // Lấy context từ view
                Intent m= new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_ChuyenBay_ThanhToan_Activity.class);
                m.putExtra("thanhtoan", TongTien.getText().toString());
                context.startActivity(m);
            }
        });
<<<<<<< HEAD
=======

>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
        xng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_ThemHanhLy_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
        xng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_ThemHanhLy_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
    }
}
