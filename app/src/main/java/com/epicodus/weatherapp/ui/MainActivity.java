package com.epicodus.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.weatherapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.cityEditText) EditText mCityEditText;
    @Bind(R.id.cityButton) Button mCityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mCityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cityButton:
                String city = mCityEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ForecastListActivity.class);
                intent.putExtra("city", city);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
