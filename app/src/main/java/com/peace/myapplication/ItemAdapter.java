package com.peace.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemViewHolder> {
    private ArrayList<Items> itemsArrayList;
    public static class itemViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView2;
        public RelativeLayout relativeLayout;

        public itemViewHolder(View itemView){
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
            relativeLayout=itemView.findViewById(R.id.relativeLayout);
        }
    }
    public ItemAdapter(ArrayList<Items> itemArrayList){
        this.itemsArrayList=itemArrayList;
    }
    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.smart,parent,false);
        itemViewHolder vh= new itemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        Items current=itemsArrayList.get(position);
        holder.imageView.setImageResource(current.getImageRes());
        holder.textView.setText(current.getLine1());
        holder.textView2.setText(current.getLine2());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"item clicked: ", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }
}