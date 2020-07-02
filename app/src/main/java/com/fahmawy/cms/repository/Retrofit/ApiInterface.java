package com.fahmawy.cms.repository.Retrofit;

import com.fahmawy.cms.model.entity.AboutUs;
import com.fahmawy.cms.model.entity.Category;
import com.fahmawy.cms.model.entity.HomePageData;
import com.fahmawy.cms.model.entity.Service;
import com.fahmawy.cms.model.entity.ServiceRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("url")
    Call<List<Category>> getCategories(
            @Path(value = "category") String category
    );

    @GET("url")
    Call<List<Service>> getServices(
            @Path(value = "tabName") String name,
            @Path(value = "category") int category
    );

    @POST("url")
    Call<ServiceRequest> makeRequest(
            @Body ServiceRequest request
    );

    @GET("url")
    Call<HomePageData> homeData();

    @GET("url")
    Call<AboutUs> aboutUsData();
}
