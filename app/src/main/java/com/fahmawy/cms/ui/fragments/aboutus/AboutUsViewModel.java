package com.fahmawy.cms.ui.fragments.aboutus;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fahmawy.cms.model.entity.AboutUs;
import com.fahmawy.cms.repository.Retrofit.ApiConfig;
import com.fahmawy.cms.repository.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutUsViewModel extends ViewModel {

    MutableLiveData<AboutUs> mAboutUs;
    MutableLiveData<String> mError;
    private Context mContext;

    public AboutUsViewModel() {
        mAboutUs = new MutableLiveData<>();
        mError = new MutableLiveData<>();
    }

    public void getAboutUsData(Context context) {
        mContext = context;
        ApiInterface apiInterface = ApiConfig.getRetrofit(mContext).create(ApiInterface.class);
        Call<AboutUs> call = apiInterface.aboutUsData();
        call.enqueue(new Callback<AboutUs>() {
            @Override
            public void onResponse(Call<AboutUs> call, Response<AboutUs> response) {
                if (response.isSuccessful())
                    mAboutUs.setValue(response.body());
                else
                    mError.setValue(response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<AboutUs> call, Throwable t) {
                mError.setValue(t.getMessage());
            }
        });
    }
}