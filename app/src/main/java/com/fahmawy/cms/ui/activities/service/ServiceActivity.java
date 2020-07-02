package com.fahmawy.cms.ui.activities.service;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.fahmawy.cms.R;
import com.fahmawy.cms.databinding.ActivityServiceBinding;
import com.fahmawy.cms.ui.adapters.CategoryAdapter;
import com.fahmawy.cms.ui.adapters.ServiceAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ServiceActivity extends AppCompatActivity {
    private ServiceViewModel mViewModel;
    private ActivityServiceBinding serviceBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceBinding = DataBindingUtil.setContentView(this, R.layout.activity_service);
        initAppBar();
        Intent i = getIntent();

        mViewModel = ViewModelProviders.of(this).get(ServiceViewModel.class);
        mViewModel.getServices(this,i.getStringExtra("ActivityName"),i.getIntExtra("cat_id",0));
        final ServiceAdapter adapter = new ServiceAdapter();

        Picasso.get().load(i.getStringExtra("image_url")).into(serviceBinding.toolbarImageView);
        serviceBinding.collapsingToolbar.setTitle(i.getStringExtra("title"));
        serviceBinding.serviceRecycler.setLayoutManager(new LinearLayoutManager(this));
        serviceBinding.serviceRecycler.setAdapter(adapter);
        mViewModel.mServices.observe(this, services -> {
            adapter.setSerList(services);
        });
        mViewModel.mError.observe(this, s -> {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        });
    }

    private void initAppBar() {

        setSupportActionBar(serviceBinding.singleToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_24dp);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
