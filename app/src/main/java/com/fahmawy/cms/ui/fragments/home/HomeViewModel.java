package com.fahmawy.cms.ui.fragments.home;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.fahmawy.cms.model.entity.HomePageData;
import com.fahmawy.cms.repository.Retrofit.ApiConfig;
import com.fahmawy.cms.repository.Retrofit.ApiInterface;

import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    MutableLiveData<HomePageData> mHomePageData;
    MutableLiveData<String> mError;
    private Context mContext;

    public HomeViewModel() {
        mHomePageData = new MutableLiveData<>();
        mError = new MutableLiveData<>();
    }

    public void getHomeData(Context context) {
        mContext = context;
        ApiInterface apiInterface = ApiConfig.getRetrofit(mContext).create(ApiInterface.class);
        Call<HomePageData> call = apiInterface.homeData();
        call.enqueue(new Callback<HomePageData>() {
            @Override
            public void onResponse(Call<HomePageData> call, Response<HomePageData> response) {
                if (response.isSuccessful())
                    mHomePageData.setValue(response.body());
                else
                    mError.setValue(response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<HomePageData> call, Throwable t) {
                mError.setValue(t.getMessage());
            }
        });
    }
}