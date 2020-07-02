package com.fahmawy.cms.ui.fragments.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.fahmawy.cms.R;
import com.fahmawy.cms.model.entity.Category;
import com.fahmawy.cms.model.utils.Utils;
import com.fahmawy.cms.ui.adapters.CategoryAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectsCategoriesFragment extends Fragment {
    @BindView(R.id.recyclerCaregory)
    RecyclerView category_recycler;
    @BindView(R.id.shimmer)
    ShimmerFrameLayout shimmer;

    private CategoriesViewModel categoriesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, root);

        categoriesViewModel =
                ViewModelProviders.of(this).get(CategoriesViewModel.class);
        return root;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (Utils.isConnected(getContext())) {
            categoriesViewModel.getCategories(getContext(), "project");
            initRecycler();
            setViewsVisible(true);
        } else {
            Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
            setViewsVisible(false);
        }
    }

    private void initRecycler() {
        final CategoryAdapter adapter = new CategoryAdapter();
        category_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        category_recycler.setAdapter(adapter);
        categoriesViewModel.mCategories.observe(getActivity(), categories -> {
            adapter.setCatList(categories,"projects");
            shimmer.setVisibility(View.GONE);
            shimmer.stopShimmer();
        });
        categoriesViewModel.mError.observe(getActivity(), s -> {
            Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            shimmer.setVisibility(View.GONE);
            shimmer.stopShimmer();
        });
    }

    private void setViewsVisible(boolean visible) {
        category_recycler.setVisibility(visible ? View.VISIBLE : View.GONE);
//        mHadithBinding.includeInternet.noInternetRelativeLayout.setVisibility(visible ? View.GONE : View.VISIBLE);
        shimmer.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
}