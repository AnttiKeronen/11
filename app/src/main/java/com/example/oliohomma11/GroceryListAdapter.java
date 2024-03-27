package com.example.oliohomma11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.GroceryViewHolder> {
    private List<Grocery> groceryList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public GroceryListAdapter(List<Grocery> groceryList) {
        this.groceryList = groceryList;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grocery, parent, false);
        return new GroceryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        Grocery grocery = groceryList.get(position);
        holder.textGroceryName.setText(grocery.getGroceryName());
        holder.textGroceryNote.setText(grocery.getGroceryNote());
    }

    @Override
    public int getItemCount() {
        return groceryList.size();
    }

    public void sortGroceriesByAlphabet() {
        Collections.sort(groceryList, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery grocery1, Grocery grocery2) {
                return grocery1.getGroceryName().compareToIgnoreCase(grocery2.getGroceryName());
            }
        });
        notifyDataSetChanged();
    }

    public void sortGroceriesByTime() {
        Collections.sort(groceryList, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery grocery1, Grocery grocery2) {
                return grocery1.getTimestamp().compareTo(grocery2.getTimestamp());
            }
        });
        notifyDataSetChanged();
    }

    public void updateGroceries(List<Grocery> groceries) {
        groceryList.clear();
        groceryList.addAll(groceries);
        notifyDataSetChanged();
    }

    public static class GroceryViewHolder extends RecyclerView.ViewHolder {
        TextView textGroceryName;
        TextView textGroceryNote;
        ImageButton imageDelete;

        public GroceryViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
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
}








