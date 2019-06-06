package com.example.catfacts;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.view.View.*;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Fact> mData;
    Context mContext;
    Dialog myDialog;

    public RecyclerViewAdapter(List<Fact> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.fact_item, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        //Dialog ini

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_fact);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder vHolder, final int position) {

        //   vHolder.iv_factImage.setImageResource(mData.get(position).getImageURL());
        vHolder.tv_title.setText(mData.get(position).getId());
        vHolder.tv_text.setText(mData.get(position).getText());
        vHolder.chb_isFavorite.setChecked(mData.get(position).getFavorite());

        vHolder.chb_isFavorite.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fact fact = mData.get(position);
                fact.setFavorite(vHolder.chb_isFavorite.isChecked());
                mData.set(position, fact);
                Toast.makeText(mContext, "mp[" + String.valueOf(position)
                        + "]=" + String.valueOf(mData.get(position).getFavorite()), Toast.LENGTH_SHORT).show();
            }
        });

        vHolder.item_fact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Button dialog_btn_add= (Button)myDialog.findViewById(R.id.dialog_btn_add_to_fav);
                Button dialog_btn_remove=(Button)myDialog.findViewById(R.id.dialog_btn_remove_from_fav);
                TextView dialog_tv_text = (TextView) myDialog.findViewById(R.id.dialog_fact_text);
                TextView dialod_tv_title = (TextView) myDialog.findViewById(R.id.dialog_fact_title);
                //ImageView dialog_img = (ImageView) myDialog.findViewById(R.id.dialog_iv_fact_image);
                //добавить чекбокс и глайд
                dialod_tv_title.setText(mData.get(position).getId());
                dialog_tv_text.setText(mData.get(position).getText());
//dialog_img.setImageResource(mData.get(position).getImageURL());
                Toast.makeText(mContext, "Test click" + String.valueOf(position), Toast.LENGTH_SHORT).show();
                dialog_btn_add.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Fact fact = mData.get(position);
                        fact.setFavorite(true);
                        mData.set(position, fact);
                        vHolder.chb_isFavorite.setChecked(true);
                        Toast.makeText(mContext, "mp[" + String.valueOf(position)
                                + "]=" + String.valueOf(mData.get(position).getFavorite()), Toast.LENGTH_SHORT).show();
                    }
                });

                dialog_btn_remove.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Fact fact = mData.get(position);
                        fact.setFavorite(false);
                        mData.set(position, fact);
                        vHolder.chb_isFavorite.setChecked(false);
                        Toast.makeText(mContext, "mp[" + String.valueOf(position)
                                + "]=" + String.valueOf(mData.get(position).getFavorite()), Toast.LENGTH_SHORT).show();
                    }
                });

                myDialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_fact;

        private ImageView iv_factImage;
        private TextView tv_title;
        private TextView tv_text;
        private CheckBox chb_isFavorite;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //глайд
            item_fact = (LinearLayout) itemView.findViewById(R.id.item_fact_id);
            tv_title = (TextView) itemView.findViewById(R.id.item_tv_title);
            tv_text = (TextView) itemView.findViewById(R.id.item_tv_text);
            chb_isFavorite = itemView.findViewById(R.id.item_checkbox_is_favorite);

        }
    }
}
