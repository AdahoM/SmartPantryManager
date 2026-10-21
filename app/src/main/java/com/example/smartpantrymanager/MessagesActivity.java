package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMessages);
        Button btnBack = findViewById(R.id.btnBack);

        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            // Empty list for now - no crash
            List<String> messages = new ArrayList<>();
            messages.add("Welcome to Smart Pantry!");
            messages.add("Add food to see expiring alerts here.");

            // Simple adapter will show messages
            recyclerView.setAdapter(new MessagesAdapter(messages));
        }
    }
}
