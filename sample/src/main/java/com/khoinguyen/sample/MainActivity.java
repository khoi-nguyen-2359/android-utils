package com.khoinguyen.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.khoinguyen.util.log.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        L.get(this).d("test logging");
    }
}
