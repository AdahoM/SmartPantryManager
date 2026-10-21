//SmartPantryManager - Developed by Adaho - Richfield Project
//version 1.0 - 2026
//TODO: Add delete item feature
// Author: AdahoM -Richfield Graduate Institute
// Last update: Oct 22 2026 - Before submission
package com.example.smartpantrymanager;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
// Main screen that shows pantry items
public class MainActivity extends AppCompatActivity implements PantryAdapter.OnItemActionListener {

    private RecyclerView rvPantry;
    private DatabaseHelper dbHelper;
    private PantryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        rvPantry = findViewById(R.id.rvPantry);
        rvPantry.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.btnAdd).setOnClickListener(v ->
                startActivity(new Intent(this, AddEditActivity.class)));

        findViewById(R.id.btnRecipes).setOnClickListener(v ->
                startActivity(new Intent(this, SuggestedRecipesActivity.class)));

        findViewById(R.id.btnSuggested).setOnClickListener(v ->
                startActivity(new Intent(this, SuggestedRecipesActivity.class)));

        findViewById(R.id.btnMessages).setOnClickListener(v ->
                startActivity(new Intent(this, MessagesActivity.class)));

        findViewById(R.id.btnSettings).setOnClickListener(v ->
                startActivity(new Intent(this, SettingsActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<PantryItem> items = dbHelper.getAllPantryItems();
        adapter = new PantryAdapter(this, items, this);
        rvPantry.setAdapter(adapter);
    }

    @Override
    public void onEdit(PantryItem item) {
        Intent intent = new Intent(this, AddEditActivity.class);
        intent.putExtra("item_id", item.getId());
        startActivity(intent);
    }

    @Override
    public void onDelete(PantryItem item) {
        dbHelper.deletePantryItem(item.getId());
        onResume();
    }
}