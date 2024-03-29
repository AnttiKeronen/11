package com.example.oliohomma11;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class GroceryViewHolder extends RecyclerView.ViewHolder {
    public TextView textGroceryName;
    public TextView textGroceryNote;
    public ImageView imageDelete;
    public ImageView imageEdit;

    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        textGroceryName = itemView.findViewById(R.id.textGroceryName);
        textGroceryNote = itemView.findViewById(R.id.textGroceryNote);
        imageDelete = itemView.findViewById(R.id.imageDelete);
        imageEdit = itemView.findViewById(R.id.imageEdit);
    }
}



