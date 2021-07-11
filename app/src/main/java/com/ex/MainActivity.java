package com.ex;

import android.os.Bundle;

import com.fastcountrycode.Country;
import com.fastcountrycode.CountryPickerListener;
import com.fastcountrycode.widget.FastCountryCodeOnlyM;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    FastCountryCodeOnlyM cancel_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        cancel_button=findViewById(R.id.cancel_button);
        textView.setText(cancel_button.getCountry_().getDialCode());
        cancel_button.setCountryPickerListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(Country country) {
                textView.setText(country.getDialCode());
            }
        });
    }
}