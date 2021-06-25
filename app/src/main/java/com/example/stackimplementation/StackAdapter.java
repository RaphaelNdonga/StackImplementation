package com.example.stackimplementation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class StackAdapter extends RecyclerView.Adapter<StackAdapter.ViewHolder> {
    private CustomStack stk;

    public StackAdapter(CustomStack customStk) {
        stk = customStk;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_txt, parent, false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("StackAdapter", "The position is " + position);
        String currentItem = stk.getStackArray()[position];
        holder.getTextView().setText(currentItem);
    }

    @Override
    public int getItemCount() {
        return stk.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.list_txt);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
