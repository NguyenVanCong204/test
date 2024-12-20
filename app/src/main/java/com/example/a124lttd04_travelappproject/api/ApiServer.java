package com.example.a124lttd04_travelappproject.api;

import com.example.a124lttd04_travelappproject.model.hotel.hotel_datkhachsan_Model;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_diadiemks_Model;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_khachsan_Model;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_phongkhachsan_Model;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_voucher_Model;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_response_Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServer {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyy").create();
    ApiServer apiServer = new Retrofit.Builder()
            .baseUrl("http://192.168.3.5:3009/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServer.class);
    @GET("khachsan")
    Call<List<hotel_khachsan_Model>> getListKhachsan();
    @GET("diadiemks")
    Call<List<hotel_diadiemks_Model>> getListdiadiem();
    @GET("phong")
    Call<List<hotel_phongkhachsan_Model>> getListphong();
    @GET("voucher")
    Call<List<hotel_voucher_Model>> getListVoucher();
    @POST("datkhachsan")
    Call<hotel_response_Model> insert(@Body hotel_datkhachsan_Model datkhachsanModel);
}
