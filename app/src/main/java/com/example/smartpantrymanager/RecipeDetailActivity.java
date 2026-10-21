package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {
    TextView tvTitle, tvIngredients, tvSteps;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        tvTitle = findViewById(R.id.tvDetailTitle);
        tvIngredients = findViewById(R.id.tvDetailIngredients);
        tvSteps = findViewById(R.id.tvDetailSteps);

        String title = getIntent().getStringExtra("title");
        String ing = getIntent().getStringExtra("ingredients");
        String steps = getIntent().getStringExtra("steps");

        if (title == null) title = "Recipe";
        if (ing == null) ing = "All ingredients available in pantry";
        if (steps == null) steps = "1. Prepare ingredients\n2. Cook with love\n3. Serve hot";

        tvTitle.setText(title);
        tvIngredients.setText("Ingredients: " + ing);
        tvSteps.setText(steps);
    }
}
