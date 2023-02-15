package com.example.servepoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DonateActivity extends AppCompatActivity {

    String TAG = "ServePoor_DonateActivity";
    ListView simpleList;
    ArrayList<Item> donateItemList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        donateItemList.add(new Item("Food", R.drawable.food_donate));
        donateItemList.add(new Item("Clothes", R.drawable.cloth_donate));
        donateItemList.add(new Item("Grocery", R.drawable.grocery));
        donateItemList.add(new Item("Money", R.drawable.money));
        donateItemList.add(new Item("Utensils", R.drawable.utensil));
        donateItemList.add(new Item("Medicine", R.drawable.medicine));

        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_view_item, donateItemList);
        simpleList.setAdapter(myAdapter);

        Button continueButton = findViewById(R.id.button_continue);
        continueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonateActivity.this, PutAddressActivity.class);
                startActivity(intent);
                Log.d(TAG, "Login button clicked!!");
            }
        });

    }
}