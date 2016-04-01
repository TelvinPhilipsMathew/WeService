package com.wehubs.weservice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suyati on 1/4/16.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<ServicesModel> mList;

    public CategoryAdapter(Context context) {
        mList = new ArrayList<>();
        mList.add(new ServicesModel("IT", R.drawable.it));
        mList.add(new ServicesModel("Construction", R.drawable.construction));
        mList.add(new ServicesModel("Real Estate", R.drawable.realestate));
        mList.add(new ServicesModel("Jobs", R.drawable.jobs));
        mList.add(new ServicesModel("Education", R.drawable.education));
        mList.add(new ServicesModel("Maids And Domestic Help", R.drawable.domestic));
        mList.add(new ServicesModel("Movers And Packers", R.drawable.packers));
        mList.add(new ServicesModel("Drivers And Taxis", R.drawable.taxis));
        mList.add(new ServicesModel("Accommodations", R.drawable.accommodation));
        mList.add(new ServicesModel("Events And Fuctions", R.drawable.events));
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_category, parent, false);
        CategoryViewHolder holder = new CategoryViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        ServicesModel model = mList.get(position);
        holder.title.setText(model.getTitle());
        try {

            holder.image.setBackgroundResource(model.getDrawable());
        } catch (Exception e) {
            holder.image.setBackgroundResource(R.drawable.default_category_pic);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        protected ImageView image;
        protected TextView title;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_category);
            title = (TextView) itemView.findViewById(R.id.tv_category);
        }
    }
}
