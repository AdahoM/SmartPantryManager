package com.example.smartpantrymanager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    Context context;
    List<Recipe> list;

    public RecipeAdapter(Context context, List<Recipe> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Recipe r = list.get(position);
        holder.tvTitle.setText(r.getTitle());
        holder.tvIng.setText(r.getIngredients());
        holder.itemView.setOnClickListener(v->{
            Intent i = new Intent(context, RecipeDetailActivity.class);
            i.putExtra("title", r.getTitle());
            i.putExtra("ingredients", r.getIngredients());
            i.putExtra("steps", r.getSteps());
            context.startActivity(i);
        });
    }

    @Override public int getItemCount(){ return list.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvIng;
        ViewHolder(View itemView){
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvRecipeTitle);
            tvIng = itemView.findViewById(R.id.tvRecipeIngredients);
        }
    }
}
