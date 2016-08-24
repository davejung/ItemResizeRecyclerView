package com.example.jaehoonjung.practice_interaction.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaehoonjung.practice_interaction.Data.MagazineData;
import com.example.jaehoonjung.practice_interaction.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaehoonjung on 2016. 8. 22..
 */
public class MagazineAdapter extends RecyclerView.Adapter<MagazineAdapter.ViewHolder> {

    private List<MagazineData> datas = new ArrayList<MagazineData>();

    int screenWidth;
    int minHeight, maxHeight;
    int lastFullSizePosition = 0;

    public MagazineAdapter(int screenWidth){
        this.screenWidth = screenWidth;
        this.minHeight = screenWidth / 2;
        this.maxHeight = screenWidth;
    }

    public void setSource(List<MagazineData> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    @Override
    public MagazineAdapter.ViewHolder onCreateViewHolder(ViewGroup group, int type) {
        View v = LayoutInflater.from(group.getContext()).inflate(R.layout.view_item_magazine, group, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }


    public void setLastFullSizePosition(int position){
        this.lastFullSizePosition = position;
    }

    @Override
    public void onBindViewHolder(MagazineAdapter.ViewHolder holder, int position) {
        MagazineData data = this.datas.get(position);

        holder.itemImageView.setImageResource(data.getResource());
        holder.titleTextView.setText(data.getTitle());
        holder.itemLayout.setTag(String.valueOf(position));
        holder.coverView.setAlpha(holder.itemLayout.getMaxValue());

    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        if(Integer.parseInt(String.valueOf(holder.itemLayout.getTag())) <= lastFullSizePosition){
            holder.itemLayout.getLayoutParams().height = maxHeight;
            holder.itemLayout.requestLayout();

            holder.titleTextView.setTextScaleX(FadingRelativeLayout.getMaxValue());
            holder.titleTextView.setScaleY(FadingRelativeLayout.getMaxValue());
            holder.coverView.setAlpha(FadingRelativeLayout.getMinValue());
        }else{
            holder.itemLayout.getLayoutParams().height = minHeight;
            holder.itemLayout.requestLayout();

            holder.coverView.setAlpha(FadingRelativeLayout.getMaxValue());
            holder.titleTextView.setTextScaleX(FadingRelativeLayout.getMinValue());
            holder.titleTextView.setScaleY(FadingRelativeLayout.getMinValue());

        }
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImageView;
        View coverView;
        TextView titleTextView;
        FadingRelativeLayout itemLayout;

        public ViewHolder(View view) {
            super(view);
            itemLayout = (FadingRelativeLayout) view;
            itemImageView = (ImageView) view.findViewById(R.id.itemImageView);
            itemLayout.setHeightRange(minHeight, maxHeight);
            coverView = (View) view.findViewById(R.id.coverView);
            coverView.setAlpha(0.8f);
            titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        }
    }

}


