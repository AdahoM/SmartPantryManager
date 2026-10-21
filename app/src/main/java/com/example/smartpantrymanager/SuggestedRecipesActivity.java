package com.example.smartpantrymanager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SuggestedRecipesActivity extends AppCompatActivity {
    RecyclerView rv;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_recipes);
        db = new DatabaseHelper(this);
        rv = findViewById(R.id.rvRecipes);
        rv.setLayoutManager(new LinearLayoutManager(this));

        List<PantryItem> pantryItems = db.getAllPantryItems();
        List<Recipe> allRecipes = db.getAllRecipes();

        // Strict matching: recipe can be made ONLY if ALL its ingredients are in pantry
        List<String> pantryNames = new ArrayList<>();
        for(PantryItem p: pantryItems) pantryNames.add(p.getName().toLowerCase().trim());

        List<Recipe> matched = new ArrayList<>();
        for(Recipe r: allRecipes){
            String[] needed = r.getIngredients().toLowerCase().split(",");
            boolean canMake = true;
            for(String need: needed){
                String n = need.trim();
                boolean found = false;
                for(String have: pantryNames){
                    if(have.contains(n) || n.contains(have)){ found=true; break; }
                }
                if(!found){ canMake=false; break; }
            }
            if(canMake) matched.add(r);
        }

        RecipeAdapter adapter = new RecipeAdapter(this, matched.isEmpty()? allRecipes : matched);
        rv.setAdapter(adapter);
    }
}
