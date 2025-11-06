package com.example.listazakupow;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button buttonDodaj;
    private EditText editTextProdukt;
    private ListView listViewProdukty;
    private ArrayList<String> produktyLista;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDodaj = findViewById(R.id.buttonDodaj);
        editTextProdukt = findViewById(R.id.editTextProdukt);
        listViewProdukty = findViewById(R.id.listView);
        produktyLista =new ArrayList<>();
        //testowo
        produktyLista.add("mleko");
        produktyLista.add("Woda");
        produktyLista.add("sok");

        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,produktyLista);
        listViewProdukty.setAdapter(arrayAdapter);

        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String dodawanyProdukt = editTextProdukt.getText().toString();
                        produktyLista.add(dodawanyProdukt);
                        arrayAdapter.notifyDataSetChanged();//aktualizowanie wyswietlanej listy
                    }
                }
        );
        listViewProdukty.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        view.setBackgroundColor(Color.RED);
                        TextView textView =(TextView) view;
                        textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                        //produktyLista.remove(i);
                        arrayAdapter.notifyDataSetChanged();

                    }
                }
        );
    }
}