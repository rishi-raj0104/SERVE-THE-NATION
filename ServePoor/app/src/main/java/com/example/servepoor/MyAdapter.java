package com.example.servepoor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Item> {

    String TAG = "ServePoor_MyAdapter";
    ArrayList<Item> donateItemList = new ArrayList<>();
    Button button = null;
//    List<Integer> itemClicked = null;
    ArrayList<Integer> itemClicked = new ArrayList<Integer>();

    private static class ViewHolder{
        TextView txtView;
        Button buttonAction;
        ImageView imageView;
    }

    public MyAdapter(Context context, int donateItemImage, ArrayList<Item> obj) {
        super(context, donateItemImage, obj);
        donateItemList = obj;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
//            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_view_item, null);
            viewHolder.txtView = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.buttonAction = (Button) convertView.findViewById(R.id.button_donate);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.txtView.setText(donateItemList.get(position).getItemName());
            viewHolder.imageView.setImageResource(donateItemList.get(position).getDonateItemImage());
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Log.d(TAG, "pos:" + position);
                    Integer integer = Integer.valueOf(position);
                    if(!itemClicked.contains(integer)) {
                        itemClicked.add(integer);
                        Log.d(TAG, "Clicked on donate item: " + donateItemList.get(position).getItemName());
                        Toast.makeText(getContext(), "Clicked on donate item: " + donateItemList.get(position).getItemName(), Toast.LENGTH_SHORT).show();
                        viewHolder.buttonAction.setEnabled(false);
                        Log.d(TAG, viewHolder.buttonAction.toString());
                    }
                    else {
                        viewHolder.buttonAction.setEnabled(false);
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                    Log.d(TAG, ex.getMessage());
                }
            }
        });
        return convertView;
    }

    @Override
    public int getPosition(@Nullable Item item) {
        int pos = -1;
        for(int i = 0; i < donateItemList.size(); i++) {
            if(donateItemList.get(i) == item) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
