package com.example.oliohomma11;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView Name, Note;
    EditText EditNote;
    ImageView Delete, Edit;
    boolean isEditMode = false;
    Grocery grocery;

    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);

        Name = itemView.findViewById(R.id.textGroceryName);
        Note = itemView.findViewById(R.id.textGroceryNote);
        EditNote = itemView.findViewById(R.id.editTextGroceryNote);
        Delete = itemView.findViewById(R.id.imageDelete);
        Edit = itemView.findViewById(R.id.imageEdit);

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEditMode = !isEditMode;
                if (isEditMode) {
                    EditNote.setVisibility(View.VISIBLE);
                    Note.setVisibility(View.GONE);
                    EditNote.setText(Note.getText());
                } else {
                    EditNote.setVisibility(View.GONE);
                    Note.setVisibility(View.VISIBLE);
                    String updatedNote = EditNote.getText().toString();
                    updateNoteInGrocery(updatedNote);
                }
            }
        });

        EditNote.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    isEditMode = false;
                    Edit.performClick();
                    return true;
                }
                return false;
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListGrocery.getInstance().removeGrocery(grocery.getName());
                if (MainActivity.adapter != null) {
                    MainActivity.adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void updateNoteInGrocery(String updatedNote) {
        if (!TextUtils.isEmpty(updatedNote)) {
            grocery.setNote(updatedNote);
            ListGrocery.getInstance().updateGrocery(grocery);
        }
    }

    public void bind(Grocery grocery) {
        this.grocery = grocery;
        Name.setText(grocery.getName());
        Note.setText(grocery.getNote());

        if (isEditMode) {
            EditNote.setVisibility(View.VISIBLE);
            Note.setVisibility(View.GONE);
            EditNote.setText(grocery.getNote());
        } else {
            EditNote.setVisibility(View.GONE);
            Note.setVisibility(View.VISIBLE);
        }
    }
}














