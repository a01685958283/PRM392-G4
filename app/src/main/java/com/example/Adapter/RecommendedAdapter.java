package com.example.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Active.ShowDetailActivity;
import com.example.teamprm392.R;
import com.example.Domain.FoodDomain;
import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    ArrayList<FoodDomain> RecommendedDomains;

    public RecommendedAdapter(ArrayList<FoodDomain> categoryDomains) {
        this.RecommendedDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended,parent,false);
        return new ViewHolder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.title.setText(RecommendedDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(RecommendedDomains.get(position).getFee()));


        int drawableResourceId = holder.itemView.getContext().getResources().
                getIdentifier(RecommendedDomains.get(position).getPic(), "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId).into(holder.pic);

        holder.btn_add.setOnClickListener(v -> {

//                Context con = holder.itemView.getContext();
//                Intent intent= new Intent(con, ShowDetailActivity.class);
//                intent.putExtra("object",RecommendedDomains.get(position));
//                con.startActivity(intent);

                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", RecommendedDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
        });

    }
    @Override
    public int getItemCount() { return RecommendedDomains.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, fee;
        ImageView pic;
        ImageView btn_add;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            fee= itemView.findViewById(R.id.fee);
            btn_add = itemView.findViewById(R.id.btn_add);
        }
    }
}
