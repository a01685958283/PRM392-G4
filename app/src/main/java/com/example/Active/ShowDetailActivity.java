package com.example.Active;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.Domain.FoodDomain;
import com.example.Helper.ManagementCart;
import com.example.teamprm392.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt,totalPriceTxt,starTxt,caloryTxt,timeTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private FoodDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;
    protected void OnCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart=new ManagementCart(this);

        iniView();
        getBundle();
    }

    private void getBundle(){
        object=(FoodDomain)getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);
        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        caloryTxt.setText(object.getCalories()+"calorires");
        starTxt.setText(object.getStar()+"");
        timeTxt.setText(object.getTime()+"minutes");
        totalPriceTxt.setText("$"+numberOrder * object.getFee());

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$"+numberOrder*object.getFee());
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$"+numberOrder * object.getFee());
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            object.setNumberInCart(numberOrder);
            managementCart.insertFood(object);
                }
        });
    }

        private void iniView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberItemTxt);
        plusBtn=findViewById(R.id.plusCardBtn);
        minusBtn=findViewById(R.id.minusCardBtn);
        picFood=findViewById(R.id.foodPic);
        totalPriceTxt=findViewById(R.id.totalPriceTxt);
        starTxt=findViewById(R.id.starTxt);
        caloryTxt=findViewById(R.id.caloriesTxt);
        timeTxt=findViewById(R.id.timeTxt);
    }
}