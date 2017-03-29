package com.winnin.reddit.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.winnin.reddit.R;
import com.winnin.reddit.model.ChildData;
import com.winnin.reddit.model.Children;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RenanKirk on 28/03/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Children> items;
    private final Context context;

    public CategoryAdapter(Context context){
        this.items = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, null);
        ViewHolder rcv = new ViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChildData childData = items.get(position).getData();
        holder.categoryTitle.setText(childData.getTitle());
        holder.categorySubtitle.setText(childData.getAuthor());
        holder.categoryUrl.setText(childData.getUrl());
        Glide.with(context).load(childData.getThumbnail()).into(holder.categoryImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<Children> data) {
        this.items = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryImage;
        private TextView categoryTitle;
        private TextView categorySubtitle;
        private TextView categoryUrl;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryImage = (ImageView) itemView.findViewById(R.id.imv_category_item);
            categoryTitle = (TextView) itemView.findViewById(R.id.txv_category_title);
            categorySubtitle = (TextView) itemView.findViewById(R.id.txv_category_subtitle);
            categoryUrl = (TextView) itemView.findViewById(R.id.txv_category_url);
        }
    }
}
