package com.example.smartpantrymanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder> {
    Context context;
    List<PantryItem> list;
    OnItemActionListener listener;

    public interface OnItemActionListener{
        void onEdit(PantryItem item);
        void onDelete(PantryItem item);
    }

    public PantryAdapter(Context context, List<PantryItem> list, OnItemActionListener listener){
        this.context=context; this.list=list; this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.item_pantry, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        PantryItem item = list.get(position);
        String emoji = "🍚";
        String n = item.getName().toLowerCase();
        if(n.contains("egg")) emoji="🥚";
        else if(n.contains("milk")) emoji="🥛";
        else if(n.contains("tomato")) emoji="🍅";
        else if(n.contains("cheese")) emoji="🧀";
        else if(n.contains("bread")) emoji="🍞";
        else if(n.contains("butter")) emoji="🧈";

        holder.tvName.setText(emoji+" "+item.getName());
        holder.tvDetails.setText(item.getQuantity()+" "+item.getUnit()+" | Expires in "+item.getExpiry()+" days");
        holder.btnEdit.setOnClickListener(v-> listener.onEdit(item));
        holder.btnDelete.setOnClickListener(v-> listener.onDelete(item));
    }

    @Override public int getItemCount(){ return list.size(); }

    public void updateList(List<PantryItem> newList){
        this.list=newList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvDetails, btnEdit, btnDelete;
        ViewHolder(View itemView){
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvDetails=itemView.findViewById(R.id.tvDetails);
            btnEdit=itemView.findViewById(R.id.btnEdit);
            btnDelete=itemView.findViewById(R.id.btnDelete);
        }
    }
}
