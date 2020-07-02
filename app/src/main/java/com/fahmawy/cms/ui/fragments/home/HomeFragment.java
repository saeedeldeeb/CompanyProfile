package com.fahmawy.cms.ui.fragments.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.fahmawy.cms.R;
import com.fahmawy.cms.ui.adapters.MostOrderAdapter;
import com.fahmawy.cms.ui.adapters.SliderAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    @BindView(R.id.recyclerHome)
    RecyclerView recyclerView;
    @BindView(R.id.imageSlider)
    SliderView sliderView;


    private MostOrderAdapter recyclerAdapter;
    private SliderAdapter sliderAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        homeViewModel.getHomeData(getContext());
        initSlider();
        initRecycler();
        homeViewModel.mHomePageData.observe(getActivity(), homePageData -> {
            recyclerAdapter.setList(homePageData.getMostorderd());
            if (homePageData.getSlider().size() > 0) {
                sliderAdapter.renewItems(homePageData.getSlider());
                sliderView.setVisibility(View.VISIBLE);
            }
        });
        homeViewModel.mError.observe(getActivity(), s -> {
            Snackbar.make(root,"Can't reach our server",Snackbar.LENGTH_LONG).show();
        });
        return root;
    }

    private void initRecycler() {
        recyclerAdapter = new MostOrderAdapter();
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initSlider() {
        sliderAdapter = new SliderAdapter(getContext());
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.DROP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.RED);
        sliderView.setIndicatorUnselectedColor(Color.WHITE);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }

//        adapter.renewItems(list);
}