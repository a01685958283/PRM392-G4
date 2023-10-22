package com.example.teamprm392.Active;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.Adapter.CategoryAdapter;
import com.example.Adapter.RecommendedAdapter;
import com.example.teamprm392.R;
import com.example.temprm392.Domain.CategoryDomain;
import com.example.temprm392.Domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList,recyclerViewPopularlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
    }
    private void recyclerViewPopular() {
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularlist = findViewById(R.id.btn_view2);
        recyclerViewPopularlist.setLayoutManager(linerLayoutManager);


        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza","pizza1", "slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",
                35.0,5 ,20,1000  ));
        foodlist.add(new FoodDomain("Chesse burger","burger", "beef, gouda chesse, special sauce, lettuce, tomat",
                30.0,4 ,17,1500  ));
        foodlist.add(new FoodDomain("Vagetable pizza","pizza3", "olive oil, vegetable, pitted kalamata, cherry tomatoas, fresh oregano, basil",
                45.0,4 ,20,900  ));
        adapter2 = new RecommendedAdapter(foodlist);
        recyclerViewPopularlist.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linerLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.btn_view1);
        recyclerViewCategoryList.setLayoutManager(linerLayoutManager);

        ArrayList<CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Burger","cat_2"));
        categoryList.add(new CategoryDomain("Hotdog","cat_3"));
        categoryList.add(new CategoryDomain("Drink","cat_4"));
        categoryList.add(new CategoryDomain("Donut","cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}