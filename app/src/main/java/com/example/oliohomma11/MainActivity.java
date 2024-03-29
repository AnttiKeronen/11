package com.example.oliohomma11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView imageAlphabet;
    private ImageView imageTime;
    private RecyclerView rvGroceries;
    private Button buttonAddNewGrocery; // Change the type to Button
    public static GroceryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageAlphabet = findViewById(R.id.imageAlphabet);
        imageTime = findViewById(R.id.imageTime);
        rvGroceries = findViewById(R.id.rvGroceries);
        buttonAddNewGrocery = findViewById(R.id.buttonAddNewGrocery); // Initialize Button

        ListGrocery listGrocery = ListGrocery.getInstance();
        adapter = new GroceryListAdapter(listGrocery.getGroceries());
        rvGroceries.setAdapter(adapter);
        rvGroceries.setLayoutManager(new LinearLayoutManager(this));

        imageAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listGrocery.sortGroceriesByAlphabet();
                adapter.notifyDataSetChanged();
            }
        });

        imageTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listGrocery.sortGroceriesByTime();
                adapter.notifyDataSetChanged();
            }
        });

        buttonAddNewGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddGroceryActivity();
            }
        });
    }

    public static void updateGroceryList() {
        adapter.notifyDataSetChanged();
    }

    private void openAddGroceryActivity() {
        Intent intent = new Intent(this, AddGroceryActivity.class);
        startActivity(intent);
    }
}
































































































