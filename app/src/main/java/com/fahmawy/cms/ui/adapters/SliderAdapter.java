package com.fahmawy.cms.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fahmawy.cms.R;
import com.fahmawy.cms.model.entity.HomePageData;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SliderAdapter extends
        SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<HomePageData.Slider> mSliderItems = new ArrayList<>();

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void renewItems(List<HomePageData.Slider> sliderItems) {
        this.mSliderItems = sliderItems;
        Log.d("SliderAdapter","size:"+sliderItems.size());

        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(HomePageData.Slider sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        HomePageData.Slider sliderItem = mSliderItems.get(position);

        Picasso.get()
                .load(sliderItem.getPhotoUrl())
                .fit()
                .into(viewHolder.imageViewBackground);

       viewHolder.sliderTitle.setText(sliderItem.getTitle());
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        @BindView(R.id.iv_auto_image_slider)
        ImageView imageViewBackground;
        @BindView(R.id.sliderTitle)
        TextView sliderTitle;
        @BindView(R.id.sliderButton)
        Button sliderBtn;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.itemView = itemView;
        }
    }

}
