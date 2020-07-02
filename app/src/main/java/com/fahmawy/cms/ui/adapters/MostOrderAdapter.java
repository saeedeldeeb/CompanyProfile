package com.fahmawy.cms.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahmawy.cms.R;
import com.fahmawy.cms.model.entity.HomePageData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MostOrderAdapter extends RecyclerView.Adapter<MostOrderAdapter.MostOrderViewHolder> {

    private Context mContext;
    private List<HomePageData.Mostorderd> list = new ArrayList<>();

    @NonNull
    @Override
    public MostOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.most_ordered_item, parent, false);
        return new MostOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostOrderViewHolder holder, int position) {
        HomePageData.Mostorderd mostorderd = list.get(position);
        holder.title.setText(mostorderd.getTitle());
        //TODO:take our description from model
        holder.description.setText("This is short description for service and i write it until toqa prepare");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<HomePageData.Mostorderd> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MostOrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.most_order_title)
        TextView title;
        @BindView(R.id.most_order_desc)
        TextView description;
        public MostOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
