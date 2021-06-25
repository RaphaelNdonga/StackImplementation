package com.example.stackimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.stackimplementation.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private final CustomStack stk = new CustomStack();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setAdapter(new StackAdapter(stk));

        binding.push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = stk.push("hello");
                Objects.requireNonNull(binding.recyclerView.getAdapter())
                        .notifyDataSetChanged();
                Log.i("MainActivity", "Push has been clicked");
                Snackbar.make(binding.constraintLayout, "Pushed this item to the stack: " + item, Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String item = stk.pop();

                    Objects.requireNonNull(binding.recyclerView.getAdapter())
                            .notifyDataSetChanged();
                    Snackbar.make(binding.recyclerView, "Popped this item off the stack: " + item, Snackbar.LENGTH_SHORT).show();
                }catch (NegativeArraySizeException sizeException){
                    Snackbar.make(binding.constraintLayout, "The stack is empty. Stop popping", Snackbar.LENGTH_SHORT).show();

                }
            }
        });

        binding.isEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bool = stk.isEmpty();
                if (bool) {
                    Snackbar.make(binding.recyclerView, "The stack is empty", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(binding.recyclerView, "The stack is not empty", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        binding.size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = stk.size();
                Snackbar.make(binding.recyclerView, "The size of this stack is: " + size, Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = stk.peek();
                Snackbar.make(binding.recyclerView, "The stack item at the top is: " + item, Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}