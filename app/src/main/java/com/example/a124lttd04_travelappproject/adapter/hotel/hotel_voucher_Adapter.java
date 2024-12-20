package com.example.a124lttd04_travelappproject.adapter.hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_voucher_Model;

import java.util.List;

public class hotel_voucher_Adapter extends RecyclerView.Adapter<hotel_voucher_Adapter.VoucherViewHolder> {

    public interface OnVoucherSelectedListener {
        void onVoucherSelected(double discount, String voucherName);
        void onVoucherDeselected(double discount, String voucherName);
    }

    private final List<hotel_voucher_Model> mListVoucher;
    private final Context context;
    private final OnVoucherSelectedListener listener;

    public hotel_voucher_Adapter(Context context, List<hotel_voucher_Model> mListVoucher, OnVoucherSelectedListener listener) {
        this.context = context;
        this.mListVoucher = mListVoucher;
        this.listener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_ds_voucher, parent, false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherViewHolder holder, int position) {
        hotel_voucher_Model voucher = mListVoucher.get(position);
        if (voucher == null) {
            return;
        }
        holder.tv_voucher.setText(voucher.getTenvoucher());
        holder.tv_giamgia.setText(String.valueOf(voucher.getGiamgia() * 100) + "%");

        holder.checkboxVoucher.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                listener.onVoucherSelected(voucher.getGiamgia(), voucher.getTenvoucher());
            } else {
                listener.onVoucherDeselected(voucher.getGiamgia(), voucher.getTenvoucher());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListVoucher != null ? mListVoucher.size() : 0;
    }

    public static class VoucherViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_voucher;
        private final TextView tv_giamgia;
        private final CheckBox checkboxVoucher;

        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_voucher = itemView.findViewById(R.id.tv_tenvoucher);
            tv_giamgia = itemView.findViewById(R.id.tv_giamgia);
            checkboxVoucher = itemView.findViewById(R.id.checkbox_voucher);
        }
    }
}
