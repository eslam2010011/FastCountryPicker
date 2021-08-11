package com.fastcountrycode.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import com.fastcountrycode.BottomSheetCountryCode;
import com.fastcountrycode.Country;
import com.fastcountrycode.CountryPickerListener;
import com.fastcountrycode.R;
public class FastCountryCodeM extends LinearLayout {
    TextView code_country;
    CountryPickerListener countryPickerListener;
    EditText Phone_number;
    ImageView delete;
    Country country_;

    public FastCountryCodeM(Context context) {
        super(context);
        init(context, null, 0);
    }

    public FastCountryCodeM(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyle) {
        inflate(context, R.layout.edittext_layout_m, this);
        code_country = findViewById(R.id.code_country);
        Phone_number = findViewById(R.id.Phone_number);
        delete = findViewById(R.id.delete);
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
        Phone_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    delete.setVisibility(VISIBLE);
                }else {
                    delete.setVisibility(INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone_number.getText().clear();
            }
        });
    }

    public void setCountryPickerListener(CountryPickerListener countryPickerListener) {
        this.countryPickerListener = countryPickerListener;
    }

    public Country getCountry_() {
        return country_;
    }
    
    public String getPhone_number() {
        return Phone_number.getText().toString();
    }
    
     public EditText getPhone_number() {
        return Phone_number;
    }
}
