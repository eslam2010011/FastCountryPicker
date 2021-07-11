package com.fastcountrycode;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BottomSheetCountryCode extends BottomSheetDialog {
    RecyclerView list_country_code;
    EditText search_country;
    Adapter adapter;
    List<Country> countriesList = new ArrayList<>();
    List<Country> selectedCountriesList = new ArrayList<>();
    ImageView close;

    public BottomSheetCountryCode(@NonNull Context context) {
        super(context, R.style.SheetDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_code_layout);
        setCountriesList(Country.getAllCountries());
        init();
        setAdapter();
    }

    public void init() {
        list_country_code = findViewById(R.id.list_country_code);
        search_country = findViewById(R.id.search_country);
        close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public void setAdapter() {
        this.selectedCountriesList = new ArrayList(this.countriesList.size());
        this.selectedCountriesList.addAll(this.countriesList);
        adapter = new Adapter(selectedCountriesList);
        list_country_code.setLayoutManager(new LinearLayoutManager(getContext()));
        list_country_code.setAdapter(adapter);
        search_country.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search(s.toString());
            }
        });

    }

    public Adapter getAdapter() {
        return adapter;
    }

    private void search(String text) {
        this.selectedCountriesList.clear();
        for (Country country : this.countriesList) {
            if (country.getName().toLowerCase(Locale.ENGLISH).contains(text.toLowerCase())) {
                this.selectedCountriesList.add(country);
            }
        }

        this.adapter.notifyDataSetChanged();
    }

    public void setCountriesList(List<Country> newCountries) {
        this.countriesList.clear();
        this.countriesList.addAll(newCountries);
    }


}
