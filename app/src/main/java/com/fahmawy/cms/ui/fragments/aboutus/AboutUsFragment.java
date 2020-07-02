package com.fahmawy.cms.ui.fragments.aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.fahmawy.cms.R;
import com.fahmawy.cms.model.utils.Utils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutUsFragment extends Fragment {
    @BindView(R.id.company_img)
    ImageView company_image;
    @BindView(R.id.company_name)
    TextView company_name;
    @BindView(R.id.company_owner)
    TextView company_owner;
    @BindView(R.id.company_type)
    TextView company_type;
    @BindView(R.id.company_desc)
    TextView company_desc;

    private AboutUsViewModel aboutUsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutUsViewModel =
                ViewModelProviders.of(this).get(AboutUsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        ButterKnife.bind(this, root);
        initView();

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Utils.isConnected(getContext()))
            aboutUsViewModel.getAboutUsData(getContext());
        else
            Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
    }

    private void initView() {
        aboutUsViewModel.mAboutUs.observe(getActivity(), aboutUs -> {
            Picasso.get().load(aboutUs.getCompanyInf().getCompanyPhoto()).into(company_image);
            company_name.setText(aboutUs.getCompanyInf().getCompanyName());
            company_owner.setText(aboutUs.getCompanyInf().getCompanyOwner());
            company_type.setText(aboutUs.getCompanyInf().getCompanyType());
            company_desc.setText(aboutUs.getCompanyInf().getCompanyDescription());
        });

        aboutUsViewModel.mError.observe(getActivity(), s -> Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show());
    }
}