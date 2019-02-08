package com.example.emrullah.recyclerviewuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<ExampleItem> mExampleList;

    private EditText editTextInsert;
    private EditText editTextRemove;
    private Button buttonInsert;
    private Button buttonRemove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creatItems();
        buildRecyclerView();

        editTextInsert=findViewById(R.id.edit_insert);
        editTextRemove=findViewById(R.id.edit_remove);
        buttonInsert=findViewById(R.id.button_insert);
        buttonRemove=findViewById(R.id.button_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }




    public void insertItem(int position){
        mExampleList.add(position,new ExampleItem(R.drawable.beer_nav_icon,"New item added","Line"));
        mAdapter.notifyItemInserted(position);
    }
    public void removeItem(int position){
        mExampleList.remove(position);//Here, we remove item from arrayList
        mAdapter.notifyItemRemoved(position);//Here, we make adapter to notify that we removed an item.
    }

    public void buildRecyclerView(){

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter= new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
    public void creatItems(){
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.beer_nav_icon,"Line 1", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.beer_nav_icon,"Line 3", "Line 4"));
        mExampleList.add(new ExampleItem(R.drawable.beer_nav_icon,"Line 5", "Line 6"));
        mExampleList.add(new ExampleItem(R.drawable.beer_nav_icon,"Line 7", "Line 8"));
    }
}
