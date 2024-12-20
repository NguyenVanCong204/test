package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
=======
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
<<<<<<< HEAD
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_voucher_Adapter;
import com.example.a124lttd04_travelappproject.api.ApiServer;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_voucher_Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hotel_Voucher extends AppCompatActivity {
    private List<hotel_voucher_Model> mListVoucher;
    private hotel_voucher_Adapter voucherAdapter;
    private RecyclerView recyclerView;
    private double originalTotal; // Tổng tiền gốc
    private double currentTotal;  // Tổng tiền sau khi áp dụng voucher
    private TextView tv_tongtien;
    private Button xacnhan;

    // Danh sách các voucher được chọn
    private List<String> selectedVoucherNames = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_activity_voucher);

        // Thiết lập Edge to Edge
=======

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.tour.tour_DatVe_SauThanhToan_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Voucher;

public class hotel_Voucher extends AppCompatActivity {
    boolean check=true;
    Button giamgia;
    Button xacnhan;
    TextView tongtien;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_activity_voucher);

>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.voucher), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

<<<<<<< HEAD
        recyclerView = findViewById(R.id.rcv_voucher);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        tv_tongtien = findViewById(R.id.tongtien_voucher);
        mListVoucher = new ArrayList<>();

        // Nhận tổng tiền từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String tongTien = intent.getStringExtra("tongtien");
            originalTotal = Double.parseDouble(tongTien.replace(",", "").replace(" VND", ""));
            currentTotal = originalTotal;
            tv_tongtien.setText(String.format("%,.0f VND", originalTotal));
        }

        // Gọi API lấy danh sách voucher
        callApiVoucher();

        xacnhan = findViewById(R.id.xacnhan);
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedVoucherNames.isEmpty()) {
                    Toast.makeText(hotel_Voucher.this, "Chưa chọn voucher nào!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String tongtien = tv_tongtien.getText().toString();
                String tenvoucher = String.join(", ", selectedVoucherNames);
                Intent intent1 = new Intent(hotel_Voucher.this, hotel_MainActivityAfterPay_Activity.class);
                intent1.putExtra("tongtien", tongtien);
                intent1.putExtra("tenvoucher", tenvoucher); // Truyền tên voucher
                startActivity(intent1);
            }
        });
    }

    private void callApiVoucher() {
        ApiServer.apiServer.getListVoucher().enqueue(new Callback<List<hotel_voucher_Model>>() {
            @Override
            public void onResponse(Call<List<hotel_voucher_Model>> call, Response<List<hotel_voucher_Model>> response) {
                mListVoucher = response.body();
                voucherAdapter = new hotel_voucher_Adapter(hotel_Voucher.this, mListVoucher, new hotel_voucher_Adapter.OnVoucherSelectedListener() {
                    @Override
                    public void onVoucherSelected(double discount, String voucherName) {
                        currentTotal -= originalTotal * discount;
                        selectedVoucherNames.add(voucherName); // Thêm tên voucher vào danh sách
                        updateTotalTextView();
                    }

                    @Override
                    public void onVoucherDeselected(double discount, String voucherName) {
                        currentTotal += originalTotal * discount;
                        selectedVoucherNames.remove(voucherName); // Xóa tên voucher khỏi danh sách
                        updateTotalTextView();
                    }
                });
                recyclerView.setAdapter(voucherAdapter);
            }

            @Override
            public void onFailure(Call<List<hotel_voucher_Model>> call, Throwable t) {
                Log.e("API_ERROR", "API Call Failed", t);
                Toast.makeText(hotel_Voucher.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateTotalTextView() {
        tv_tongtien.setText(String.format("%,.0f VND", currentTotal));
    }
=======
        giamgia=findViewById(R.id.applygiamgia);
        tongtien=findViewById(R.id.TongTien);
        xacnhan=findViewById(R.id.xacnhan);
        giamgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==true){
                    tongtien.setText("1.573.528 VND (TCBDOMBAY)");
                    check=false;
                }
                else {
                    tongtien.setText("1.773.528 VND");
                    check=true;
                }
            }
        });
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(hotel_Voucher.this, hotel_MainActivityAfterPay_ACtivity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
    }
>>>>>>> eacce588508483ac794f56ee58d84522b302fb2e
}
