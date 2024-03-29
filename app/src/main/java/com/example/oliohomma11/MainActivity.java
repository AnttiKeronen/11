package com.example.oliohomma11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView rvGroceries;
    public static GroceryListAdapter adapter;
    private ImageView imageAlphabet;
    private ImageView imageTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGroceries = findViewById(R.id.rvGroceries);
        imageAlphabet = findViewById(R.id.imageAlphabet);
        imageTime = findViewById(R.id.imageTime);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvGroceries.setLayoutManager(layoutManager);

        adapter = new GroceryListAdapter(new ArrayList<>());
        rvGroceries.setAdapter(adapter);

        Button buttonAddNewGrocery = findViewById(R.id.buttonAddNewGrocery);
        buttonAddNewGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddGroceryActivity.class));
            }
        });

        imageAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.sortGroceriesByAlphabet();
            }
        });

        imageTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.sortGroceriesByTime();
            }
        });
    }


    public static void updateGroceryList() {
        List<Grocery> groceries = ListGrocery.getInstance().getGroceries();
        adapter.updateGroceries(groceries);
    }
}




























































































