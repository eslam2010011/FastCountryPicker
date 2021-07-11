package com.ex;

import android.os.Bundle;

import com.fastcountrycode.Country;
import com.fastcountrycode.CountryPickerListener;
import com.fastcountrycode.widget.CountryCodeOnlyM;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    CountryCodeOnlyM cancel_button;
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