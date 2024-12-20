package com.example.a124lttd04_travelappproject.view.hotel;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_Location_Adapter;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_CategoryPay_Adapter;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class hotel_MainInf_Activity extends AppCompatActivity {

    private Spinner spinner;
    private hotel_CategoryPay_Adapter categoryPayAdapter;
    private EditText checkInput;
    private EditText checkOutput;
    private TextView editTextRoomNumber; // Hiển thị số phòng
    private TextView editTextTotalPrice; // Hiển thị tổng giá
    private MaterialButton button;
    private ImageView img;

    private Double roomPrice ;
    private int numberOfRooms = 1; // Số phòng mặc định là 1

    @Override
    public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter) {
        return super.registerReceiver(receiver, filter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel_activity_main_inf);

        // Cấu hình padding để tương thích với system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_pay);

        // Đặt mục action_hotel là mặc định
        bottomNavigationView.setSelectedItemId(R.id.action_hotel);

        // Xử lý sự kiện nhấn trên từng mục
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(hotel_MainInf_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    // Nếu là mục Hotel (hoặc hiện tại là Hotel), không cần chuyển activity
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(hotel_MainInf_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(hotel_MainInf_Activity.this, Taikhoan.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        // Khởi tạo Spinner
        spinner = findViewById(R.id.spn_room);
        categoryPayAdapter = new hotel_CategoryPay_Adapter(this, R.layout.hotel_item_selected_pay1, getListCategoryPay());
        spinner.setAdapter(categoryPayAdapter);

        // Xử lý sự kiện chọn ngày check-in, check-out
        checkInput = findViewById(R.id.editText_check_in);
        checkOutput = findViewById(R.id.editText_check_out);

        checkInput.setOnClickListener(view -> showDateDialog(checkInput));
        checkOutput.setOnClickListener(view -> showDateDialog(checkOutput));

        // Khởi tạo các trường nhập liệu
        editTextRoomNumber = findViewById(R.id.editText_room_number);
        editTextTotalPrice = findViewById(R.id.TongTien);

        // Lấy giá phòng từ Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("giaphong")) {
            roomPrice = intent.getDoubleExtra("giaphong", 0); // Giá trị mặc định là 0
            Log.d("HotelActivity", "Giá phòng: " + roomPrice); // Log giá trị nhận được
        } else {
            Log.d("HotelActivity", "Không nhận được giá phòng từ Intent");
        }

        editTextRoomNumber.setText(String.valueOf(numberOfRooms)); // Số phòng mặc định
        updateTotalPrice();

        // Cập nhật tổng giá khi số phòng thay đổi
        editTextRoomNumber.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                updateTotalPrice();
            }
        });

        // Xử lý sự kiện chọn phòng trong Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedRoom = categoryPayAdapter.getItem(position).getName();
                numberOfRooms = Integer.parseInt(selectedRoom.split(" ")[0]);
                editTextRoomNumber.setText(String.valueOf(numberOfRooms));
                updateTotalPrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Xử lý sự kiện nhấn nút thanh toán
        button = findViewById(R.id.btn_pay);
        button.setOnClickListener(view -> {
            // Lấy dữ liệu cần truyền
            String checkInDate = checkInput.getText().toString();   // Ngày đặt phòng
            String checkOutDate = checkOutput.getText().toString(); // Ngày trả phòng
            String totalPrice = editTextTotalPrice.getText().toString(); // Tổng tiền

            // Tạo Intent để truyền dữ liệu
            Intent intent1 = new Intent(hotel_MainInf_Activity.this, hotel_MainActivityPay_Activity.class);
            intent1.putExtra("checkInDate", checkInDate);
            intent1.putExtra("checkOutDate", checkOutDate);
            intent1.putExtra("totalPrice", totalPrice);
            // Chuyển sang Activity hotel_MainActivityPay_Activity
            startActivity(intent1);
        });

        // Xử lý sự kiện nhấn nút quay lại
        img = findViewById(R.id.img_back_Inf);
        img.setOnClickListener(view -> startActivity(new Intent(hotel_MainInf_Activity.this, hotel_MainRoom_Activity.class)));
    }

    // Phương thức lấy danh sách các loại phòng
    private List<hotel_Location_Adapter.model_CategoryPay> getListCategoryPay() {
        List<hotel_Location_Adapter.model_CategoryPay> list = new ArrayList<>();
        list.add(new hotel_Location_Adapter.model_CategoryPay("1 phòng"));
        list.add(new hotel_Location_Adapter.model_CategoryPay("2 phòng"));
        list.add(new hotel_Location_Adapter.model_CategoryPay("3 phòng"));
        return list;
    }

    // Phương thức cập nhật tổng giá dựa trên số phòng và giá phòng
    private void updateTotalPrice() {
        try {
            numberOfRooms = Integer.parseInt(editTextRoomNumber.getText().toString());
        } catch (NumberFormatException e) {
            numberOfRooms = 1; // Giá trị mặc định nếu nhập sai
        }

        // Lấy ngày check-in và check-out
        String checkInDate = checkInput.getText().toString();
        String checkOutDate = checkOutput.getText().toString();

        // Kiểm tra xem người dùng đã nhập đầy đủ ngày check-in và check-out chưa
        if (!checkInDate.isEmpty() && !checkOutDate.isEmpty()) {
            try {
                // Định dạng ngày theo định dạng yyyy-MM-dd
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                // Chuyển đổi ngày check-in và check-out thành Date
                Calendar checkInCalendar = Calendar.getInstance();
                checkInCalendar.setTime(sdf.parse(checkInDate));

                Calendar checkOutCalendar = Calendar.getInstance();
                checkOutCalendar.setTime(sdf.parse(checkOutDate));

                // Tính số ngày giữa check-in và check-out
                long diffInMillis = checkOutCalendar.getTimeInMillis() - checkInCalendar.getTimeInMillis();
                long diffInDays = diffInMillis / (1000 * 60 * 60 * 24); // Chuyển đổi sang số ngày

                if (diffInDays < 0) {
                    // Nếu ngày check-out trước ngày check-in, thông báo lỗi
                    Log.d("HotelActivity", "Ngày check-out không hợp lệ");
                    return;
                }

                // Tính tổng giá phòng: Giá phòng * số phòng * số ngày
                Double totalPrice = roomPrice * numberOfRooms * diffInDays;

                // Định dạng lại tổng giá phòng
                DecimalFormat decimalFormat = new DecimalFormat("#,###");
                String totalPriceFormatted = decimalFormat.format(totalPrice);

                // Cập nhật giá phòng lên TextView
                editTextTotalPrice.setText(totalPriceFormatted + " VND");

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("HotelActivity", "Lỗi khi tính toán ngày: " + e.getMessage());
            }
        } else {
            // Nếu chưa chọn đủ ngày, tính theo mặc định
            Double totalPrice = roomPrice * numberOfRooms;
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String totalPriceFormatted = decimalFormat.format(totalPrice);
            editTextTotalPrice.setText(totalPriceFormatted + " VND");
        }
    }


    // Phương thức hiển thị hộp thoại chọn ngày
    private void showDateDialog(final EditText dateField) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateField.setText(simpleDateFormat.format(calendar.getTime())); // Đặt ngày vào EditText
            updateTotalPrice(); // Cập nhật lại giá phòng sau khi chọn ngày
        };
        new DatePickerDialog(hotel_MainInf_Activity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}
