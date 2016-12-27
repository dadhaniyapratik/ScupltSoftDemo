package com.bkp.sculptsoft;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bkp.sculptsoft.Pojo.SellingList;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 24-12-2016.
 */

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<SellingList> sellingLists;
    LayoutInflater mInflater;

    public CustomBaseAdapter(Context context, List<SellingList> items) {
        this.context = context;
        this.sellingLists = items;

        mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }


    /*private view holder class*/
    class ViewHolder {
        //        ImageView imageView;
        TextView txt_id;
        TextView txt_distance;
        TextView txt_make;
        TextView txt_miles;
        TextView txt_model;
        TextView txt_price;
//        TextView txt_shareurl;
        TextView txt_status;
        TextView txt_year;
        CheckBox checkBox;
        LinearLayout llImageList;


    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();


            holder.txt_id = (TextView) convertView.findViewById(R.id.tv_id);
            holder.txt_distance = (TextView) convertView.findViewById(R.id.tv_distance);
            holder.txt_make = (TextView) convertView.findViewById(R.id.tv_make);
            holder.txt_miles = (TextView) convertView.findViewById(R.id.tv_miles);
            holder.txt_model = (TextView) convertView.findViewById(R.id.tv_model);
            holder.txt_price = (TextView) convertView.findViewById(R.id.tv_price);
//            holder.txt_shareurl = (TextView) convertView.findViewById(R.id.tv_shareurl);
            holder.txt_status = (TextView) convertView.findViewById(R.id.tv_status);
            holder.txt_year = (TextView) convertView.findViewById(R.id.tv_year);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
            holder.llImageList = (LinearLayout) convertView.findViewById(R.id.ll_imageList);

            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckBox cb = (CheckBox) view;
                    SellingList sellingList = (SellingList) cb.getTag();
                    sellingList.setCheckBox(cb.isChecked());

                    Toast.makeText(context.getApplicationContext(),

                            "Clicked on Checkbox: " + cb.getText() +
                                    " is " + cb.isChecked(),
                            Toast.LENGTH_SHORT).show();

                }
            });


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        SellingList sellingList = (SellingList) getItem(position);

        holder.llImageList.removeAllViews();
        if(!sellingList.getImagelist().isEmpty())
        {
            for(String str : sellingList.getImagelist())
            {
                    ImageView iv = (ImageView) mInflater.inflate(R.layout.row_image, null);

                    Picasso.with(context).load("http://push.cartradernow.com/CarTrader/images/advertiseImages/" + sellingList.getId() +
                            "/" + str).resize(250, 250).into(iv);


                    holder.llImageList.addView(iv);


            }
        }

        holder.txt_distance.setText("Distance : " + sellingList.getDistance());
        holder.txt_id.setText("Id : " + sellingList.getId().toString());
        holder.txt_make.setText("Make : " + sellingList.getMake().toString());
        holder.txt_miles.setText("Miles : " + sellingList.getMiles().toString());
        holder.txt_model.setText("Model : " + sellingList.getModel().toString());
        holder.txt_price.setText("Price : " + sellingList.getPrice().toString());
        holder.txt_status.setText("Status : " + sellingList.getStatus().toString());
        holder.txt_year.setText("Year : " + sellingList.getYear().toString());
        holder.checkBox.setChecked(sellingList.getCheckBox());
        holder.checkBox.setTag(sellingList);

        return convertView;
    }

    @Override
    public int getCount() {
        return sellingLists.size();
    }

    @Override
    public Object getItem(int position) {
        return sellingLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return sellingLists.indexOf(getItem(position));
    }
}