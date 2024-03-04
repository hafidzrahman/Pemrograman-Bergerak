package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static String panjang, lebar;

    private EditText inputPanjang, inputLebar;
    private Button buttonProcess;
    private TextView textHasil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputPanjang = (EditText) findViewById(R.id.input_panjang);
        inputLebar = (EditText) findViewById(R.id.input_lebar);
        buttonProcess = (Button) findViewById(R.id.button_process);
        textHasil = (TextView) findViewById(R.id.text_hasil);

        buttonProcess.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v) {
                panjang = inputPanjang.getText().toString();
                lebar = inputLebar.getText().toString();

                if (TextUtils.isEmpty(panjang)) {
                    inputPanjang.setError("Mohon masukkan input dengan benar");
                    inputPanjang.requestFocus();
                } else if (TextUtils.isEmpty(lebar)) {
                    inputLebar.setError("Mohon masukkan input dengan benar");
                    inputLebar.requestFocus();
                } else {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });

    }
}