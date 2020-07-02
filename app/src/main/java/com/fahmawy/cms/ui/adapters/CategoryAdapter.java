package com.fahmawy.cms.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahmawy.cms.R;
import com.fahmawy.cms.model.entity.Category;
import com.fahmawy.cms.repository.Retrofit.ApiConstans;
import com.fahmawy.cms.ui.activities.service.ServiceActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoriesViewHolder> {
    private Context context;
    private List<Category> categoryList = new ArrayList<>();
    private String activity_name;

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_item, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Category category = categoryList.get(position);
        Picasso.get().load(category.getPhotoUrl()).into(holder.thumbnail);
        holder.title.setText(category.getTitle());
        holder.description.setText(category.getDescription());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ServiceActivity.class);
            intent.putExtra("image_url", category.getPhotoUrl());
            intent.putExtra("title", category.getTitle());
            intent.putExtra("cat_id",category.getId());
            intent.putExtra("ActivityName",activity_name);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setCatList(List<Category> catList , String activity_name) {
        this.activity_name = activity_name;
        this.categoryList = catList;
        notifyDataSetChanged();
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.catInfo)
        TextView description;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
