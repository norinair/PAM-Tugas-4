package com.example.tugas4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNama, editTextNim;
    private Button buttonTambah;
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private ArrayList<DataModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = findViewById(R.id.editTextNama);
        editTextNim = findViewById(R.id.editTextNim);
        buttonTambah = findViewById(R.id.buttonTambah);
        recyclerView = findViewById(R.id.recyclerView);

        dataList = new ArrayList<>();
        adapter = new DataAdapter(dataList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNama.getText().toString();
                String nim = editTextNim.getText().toString();

                if (!nama.isEmpty() && !nim.isEmpty()) {
                    dataList.add(new DataModel(nama, nim));
                    adapter.notifyDataSetChanged();
                    editTextNama.setText("");
                    editTextNim.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Nama dan NIM harus diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
