package com.example.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Domain.FoodDomain;
import com.example.Helper.ManagementCart;
import com.example.Interface.ChangeNumberItemsListener;
import com.example.teamprm392.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    ArrayList<FoodDomain> listFoodSelected;
    private ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<FoodDomain> listFoodSelected, Context context,ChangeNumberItemsListener changeNumberItemsListener ) {
        this.listFoodSelected = listFoodSelected;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener=changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.title.setText(listFoodSelected.get(position).getTitle());
        holder.feeEachItem.setText("$"+listFoodSelected.get(position).getFee());
        holder.totalEachItem.setText("$"+Math.round(listFoodSelected.get(position).getNumberInCart()*listFoodSelected.get(position).getFee()));
        holder.num.setText(String.valueOf(listFoodSelected.get(position).getNumberInCart()));


        int drawableResourceId = holder.itemView.getContext().getResources().
                getIdentifier(listFoodSelected.get(position).getPic(), "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId).into(holder.Pic);

        holder.plusItem.setOnClickListener(v -> managementCart.plustNumberFood(listFoodSelected,position,() -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

        holder.minusItem.setOnClickListener(v -> managementCart.minusNumberFood(listFoodSelected,position,() ->{
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));
    }
    @Override
    public int getItemCount() { return listFoodSelected.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, feeEachItem;
        ImageView Pic,plusItem,minusItem;
        TextView totalEachItem,num;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            Pic = itemView.findViewById(R.id.pic);
            feeEachItem= itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
            num = itemView.findViewById(R.id.numberItemTxt);

        }
    }
}
