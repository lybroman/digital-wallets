package com.example.lybro.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnDisplayQRcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplayQRcode = (Button) findViewById(R.id.id_display_qrcode);
        ImageView iv = findViewById(R.id.iv);
        btnDisplayQRcode.setOnClickListener(new btnDisplayQRcodeClick(this, iv));
    }
}
