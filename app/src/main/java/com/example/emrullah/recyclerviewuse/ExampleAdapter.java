package com.example.emrullah.recyclerviewuse;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(@NonNull View itemView) {
            //For our View, we define the items in our ViewHolder Constructor.
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageView);
            mTextView1=itemView.findViewById(R.id.textView1);
            mTextView2=itemView.findViewById(R.id.textView2);
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleItems){
        //to use the data we need to get items in constructor of Adapter
        mExampleList=exampleItems;
    }

    @NonNull
    @Override//we are inflating the layout of which we are going to show in our recyclerview
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item,viewGroup,false);
        ExampleViewHolder eVholder = new ExampleViewHolder(view);
        return eVholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int position) {
        //gets the items from ExampleItem class via ArrayList.
        //And sets the items to the their places
        ExampleItem currentItem=mExampleList.get(position);

        exampleViewHolder.mImageView.setImageResource(currentItem.getImageResource());
        exampleViewHolder.mTextView1.setText(currentItem.getmText1());
        exampleViewHolder.mTextView2.setText(currentItem.getmText2());

    }

    @Override
    public int getItemCount() {//it counts items in the list we defined.
        return mExampleList.size();
    }
}
