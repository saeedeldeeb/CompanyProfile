package com.fahmawy.cms.ui.activities.service;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fahmawy.cms.model.entity.Service;
import com.fahmawy.cms.repository.Retrofit.ApiConfig;
import com.fahmawy.cms.repository.Retrofit.ApiInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    MutableLiveData<List<Service>> mServices;
    MutableLiveData<String> mError;
    private Context mContext;

    public ServiceViewModel() {
        mError = new MutableLiveData<>();
        mServices = new MutableLiveData<>();
    }

    public void getServices(Context context,String name ,  int cat) {
        mContext = context;
        ApiInterface apiInterface = ApiConfig.getRetrofit(mContext).create(ApiInterface.class);
        Call<List<Service>> call = apiInterface.getServices(name , cat);
        call.enqueue(new Callback<List<Service>>() {
            @Override
            public void onResponse(Call<List<Service>> call, Response<List<Service>> response) {
                if (response.isSuccessful())
                    mServices.setValue(response.body());
                else {
                    try {
                        mError.setValue(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Service>> call, Throwable t) {
                mError.setValue(t.getMessage());
            }
        });
    }
}
