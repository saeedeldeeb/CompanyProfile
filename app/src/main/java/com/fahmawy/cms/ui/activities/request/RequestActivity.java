package com.fahmawy.cms.ui.activities.request;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fahmawy.cms.R;
import com.fahmawy.cms.model.entity.ServiceRequest;
import com.fahmawy.cms.repository.Retrofit.ApiConstans;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RequestActivity extends AppCompatActivity {
    @BindView(R.id.thumbnail)
    ImageView thumbnail;
    @BindView(R.id.textViewTitle)
    TextView title;
    @BindView(R.id.textViewDesc)
    TextView desc;
    @BindView(R.id.editTextEmail)
    EditText email;
    @BindView(R.id.editTextName)
    EditText name;
    @BindView(R.id.editTextNotes)
    EditText notes;
    @BindView(R.id.editTextNumber)
    EditText number;
    @BindView(R.id.buttonSend)
    Button send_btn;
    @BindView(R.id.requestToolbar)
    Toolbar toolbar;

    private RequestViewModel viewModel;
    private ServiceRequest request;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        ButterKnife.bind(this);
        intent = getIntent();
        Picasso.get()
                .load(intent.getStringExtra("image_url"))
                .fit()
                .into(thumbnail);
        title.setText(intent.getStringExtra("title"));
        desc.setText(intent.getStringExtra("desc"));

        initAppBar();
        request = new ServiceRequest();
        viewModel = ViewModelProviders.of(this).get(RequestViewModel.class);

        send_btn.setOnClickListener(v -> {
            getUserInputs();
            viewModel.makeRequest(RequestActivity.this, request);
        });

        viewModel.mServicesRequest.observe(this, request1 -> Log.d("TAG", request1.getCreatedAt()));
        viewModel.mError.observe(this, s -> Log.e("TAG", s));
    }

    private void getUserInputs() {
        request.setEmail(email.getText().toString());
        request.setName(name.getText().toString());
        request.setPhone(number.getText().toString());
        request.setNotes(notes.getText().toString());
        request.setCompany(ApiConstans.COMPANY_ID);
        request.setService(intent.getIntExtra("service_id",0));
    }

    private void initAppBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_24dp);
        actionBar.setTitle("");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
