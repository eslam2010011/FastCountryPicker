package com.fastcountrycode;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private List<Country> data;
    CountryPickerListener countryPickerListener;

    @SuppressWarnings("WeakerAccess")
    protected class Holder extends RecyclerView.ViewHolder {
        private View root;
        TextView code;

        Holder(View itemView) {
            super(itemView);
            root = itemView;

            code = itemView.findViewById(R.id.code);


        }
    }

    public Adapter(List<Country> data) {
        this.data = data;

    }

    @SuppressWarnings("WeakerAccess")
    public void setData(@Nullable List<Country> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (isEmpty()) ? 0 : data.size();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_country_code, parent, false));
    }

    private boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Country country = data.get(position);
        holder.code.setText(country.getName());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countryPickerListener != null) {
                    countryPickerListener.onSelectCountry(country);
                }
            }
        });
    }

    public void search(String text) {
        this.data.clear();
        for (Country country : this.data) {
            if (country.getName().toLowerCase(Locale.ENGLISH).contains(text.toLowerCase())) {
                this.data.add(country);
            }
        }
        this.notifyDataSetChanged();
    }

    public CountryPickerListener getCountryPickerListener() {
        return countryPickerListener;
    }

    public void setCountryPickerListener(CountryPickerListener countryPickerListener) {
        this.countryPickerListener = countryPickerListener;
    }
}