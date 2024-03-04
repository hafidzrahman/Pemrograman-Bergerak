package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView textPanjang, textLebar, textKeliling, textLuas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textPanjang = (TextView) findViewById(R.id.text_panjang);
        textLebar = (TextView) findViewById(R.id.text_lebar);
        textKeliling = (TextView) findViewById(R.id.text_keliling);
        textLuas = (TextView) findViewById(R.id.text_luas);

        double panjang = Double.parseDouble(MainActivity.panjang);
        double lebar = Double.parseDouble(MainActivity.lebar);

        textPanjang.setText("Panjang : " + panjang);
        textLebar.setText("Lebar : " + lebar);

        double keliling = (panjang + lebar) * 2;
        double luas = panjang * lebar;

        textKeliling.setText("Keliling : " + keliling);
        textLuas.setText("Luas : " + luas);

    }


}