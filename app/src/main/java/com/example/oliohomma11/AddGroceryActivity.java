package com.example.oliohomma11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class AddGroceryActivity extends AppCompatActivity {
    private EditText editGroceryName;
    private EditText editGroceryNote;
    private Button buttonAddGrocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);

        editGroceryName = findViewById(R.id.editGroceryName);
        editGroceryNote = findViewById(R.id.editGroceryNote);
        buttonAddGrocery = findViewById(R.id.buttonAddGrocery);

        buttonAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textGroceryName = editGroceryName.getText().toString();
                String textGroceryNote = editGroceryNote.getText().toString();
                Date timestamp = new Date();

                Grocery grocery = new Grocery(textGroceryName, textGroceryNote, timestamp);

                ListGrocery.getInstance().addGrocery(grocery);

                MainActivity.updateGroceryList();

                finish();
            }
        });
    }
}











