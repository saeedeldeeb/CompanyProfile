package com.fahmawy.cms.ui.activities.request;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fahmawy.cms.model.entity.ServiceRequest;
import com.fahmawy.cms.repository.Retrofit.ApiConfig;
import com.fahmawy.cms.repository.Retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestViewModel extends ViewModel {
    MutableLiveData<ServiceRequest> mServicesRequest;
    MutableLiveData<String> mError;
    private Context mContext;

    public RequestViewModel() {
        mServicesRequest = new MutableLiveData<>();
        mError = new MutableLiveData<>();
    }

    public void makeRequest(Context context, ServiceRequest request) {
        mContext = context;
        ApiInterface apiInterface = ApiConfig.getRetrofit(mContext).create(ApiInterface.class);
        Call<ServiceRequest> call = apiInterface.makeRequest(request);
        call.enqueue(new Callback<ServiceRequest>() {
            @Override
            public void onResponse(Call<ServiceRequest> call, Response<ServiceRequest> response) {
                if (response.isSuccessful())
                    mServicesRequest.setValue(response.body());
                else
                    mError.setValue(response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<ServiceRequest> call, Throwable t) {
                mError.setValue(t.getMessage());
            }
        });
    }
}
