package com.fahmawy.cms.ui.fragments.category;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fahmawy.cms.model.entity.Category;
import com.fahmawy.cms.repository.Retrofit.ApiConfig;
import com.fahmawy.cms.repository.Retrofit.ApiInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesViewModel extends ViewModel {

     MutableLiveData<List<Category>> mCategories;
     MutableLiveData<String> mError;
    private Context mContext;

    public CategoriesViewModel() {
        mError = new MutableLiveData<>();
        mCategories = new MutableLiveData<>();
    }

    public void getCategories(Context context , String cat) {
        mContext = context;
        ApiInterface apiInterface = ApiConfig.getRetrofit(mContext).create(ApiInterface.class);
        Call<List<Category>> listCall = apiInterface.getCategories(cat);
        listCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful())
                    mCategories.setValue(response.body());
                else {
                    try {
                        mError.setValue(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                mError.setValue(t.getMessage());
            }
        });
    }
}