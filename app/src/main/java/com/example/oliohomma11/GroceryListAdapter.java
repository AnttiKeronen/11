package com.example.oliohomma11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder> {
    private final List<Grocery> groceryList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);

        void onEditClick(int position);

    }

    public GroceryListAdapter(List<Grocery> groceryList) {
        this.groceryList = groceryList;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grocery, parent, false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        Grocery grocery = groceryList.get(position);
        holder.Name.setText(grocery.getName());
        holder.Note.setText(grocery.getNote());

        holder.Delete.setOnClickListener(view -> {
            int adapterPosition = holder.getAdapterPosition();
            if (listener != null && adapterPosition != RecyclerView.NO_POSITION) {
                listener.onDeleteClick(adapterPosition);
            }
        });

        holder.Edit.setOnClickListener(view -> {
            int adapterPosition = holder.getAdapterPosition();
            if (listener != null && adapterPosition != RecyclerView.NO_POSITION) {
                listener.onEditClick(adapterPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return groceryList.size();
    }


}






