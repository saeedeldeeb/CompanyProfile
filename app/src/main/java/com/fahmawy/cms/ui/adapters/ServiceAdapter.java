package com.fahmawy.cms.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahmawy.cms.R;
import com.fahmawy.cms.model.entity.Service;
import com.fahmawy.cms.repository.Retrofit.ApiConstans;
import com.fahmawy.cms.ui.activities.request.RequestActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {
    private Context context;
    private List<Service> serviceList = new ArrayList<>();

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.service_item, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        Service service = serviceList.get(position);
        Picasso.get().load(service.getPhotoUrl()).into(holder.thumbnail);
        holder.title.setText(service.getTitle());
        holder.description.setText(service.getDescription());
        holder.requestBtn.setOnClickListener(v -> {
            Intent i = new Intent(context, RequestActivity.class);
            i.putExtra("service_id", service.getId());
            i.putExtra("image_url", service.getPhotoUrl());
            i.putExtra("title", service.getTitle());
            i.putExtra("desc", service.getDescription());

            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public void setSerList(List<Service> serList) {
        this.serviceList = serList;
        notifyDataSetChanged();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.catInfo)
        TextView description;
        @BindView(R.id.request_btn)
        Button requestBtn;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
