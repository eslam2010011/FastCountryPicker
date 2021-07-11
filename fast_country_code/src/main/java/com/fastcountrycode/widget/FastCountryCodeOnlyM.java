package com.fastcountrycode.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fastcountrycode.BottomSheetCountryCode;
import com.fastcountrycode.Country;
import com.fastcountrycode.CountryPickerListener;
import com.fastcountrycode.R;


public class FastCountryCodeOnlyM extends LinearLayout {
    TextView code_country;
    CountryPickerListener countryPickerListener;
    Country country_;

    public FastCountryCodeOnlyM(Context context) {
        super(context);
        init(context, null, 0);
    }

    public FastCountryCodeOnlyM(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyle) {
        inflate(context, R.layout.edittext_only_layout_m, this);
        code_country = findViewById(R.id.code_country);
        country_=Country.getCountryFromSIM(getContext());
        code_country.setText(Country.getCountryFromSIM(getContext()).getCode() + " " + Country.getCountryFromSIM(getContext()).getDialCode());
        code_country.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetCountryCode bottomSheetCountryCode = new BottomSheetCountryCode(context);
                bottomSheetCountryCode.show();
                bottomSheetCountryCode.getAdapter().setCountryPickerListener(new CountryPickerListener() {
                    @Override
                    public void onSelectCountry(Country country) {
                        country_=country;
                        code_country.setText(country.getCode() + " " + country.getDialCode());
                        bottomSheetCountryCode.dismiss();
                        if (countryPickerListener != null) {
                            countryPickerListener.onSelectCountry(country);
                        }

                    }
                });
            }
        });

    }

    public void setCountryPickerListener(CountryPickerListener countryPickerListener) {
        this.countryPickerListener = countryPickerListener;
    }

    public Country getCountry_() {
        return country_;
    }
}
