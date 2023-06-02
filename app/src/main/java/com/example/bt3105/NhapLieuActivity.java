package com.example.bt3105;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NhapLieuActivity extends AppCompatActivity {
    public static final String KEY = "so";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity);

        Button bt1 = findViewById(R.id.bt_luu_bp);
        Button bt2 = findViewById(R.id.bt_luu_so);
        EditText editText = findViewById(R.id.et_so);

        bt1.setOnClickListener(view -> {
            int num = Integer.valueOf(editText.getText().toString().trim());
            String so = String.valueOf(num * num);
            Intent intent = new Intent();
            intent.putExtra(KEY, so);
            setResult(RESULT_OK, intent);
            finish();
        });

        bt2.setOnClickListener(view -> {
            int num = Integer.valueOf(editText.getText().toString().trim());
            String so = String.valueOf(num);
            Intent intent = new Intent();
            intent.putExtra(KEY, so);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
