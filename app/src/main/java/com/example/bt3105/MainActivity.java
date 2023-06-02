package com.example.bt3105;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> mListDate;
    private ArrayAdapter<String> mAdapter;
    private static final int CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListDate = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mListDate);

        Button button = findViewById(R.id.bt_open_act);
        ListView listView = findViewById(R.id.l_so);
        listView.setAdapter(mAdapter);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, NhapLieuActivity.class);
            startActivityForResult(intent, CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == CODE) {
            String so = data.getStringExtra(NhapLieuActivity.KEY);
            mListDate.add(so);
            mAdapter.notifyDataSetChanged();
        }
    }
}