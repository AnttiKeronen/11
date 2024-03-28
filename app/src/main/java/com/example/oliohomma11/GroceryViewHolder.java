package com.example.oliohomma11;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView textGroceryName;
    TextView textGroceryNote;
    ImageButton imageDelete;

    public GroceryViewHolder(@NonNull View itemView, final GroceryListAdapter.OnItemClickListener listener) {
        super(itemView);
        textGroceryName = itemView.findViewById(R.id.textGroceryName);
        textGroceryNote = itemView.findViewById(R.id.textGroceryNote);
        imageDelete = itemView.findViewById(R.id.imageDelete);

        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onDeleteClick(position);
                    }
                }
            }
        });
    }
}


