package com.fahmawy.cms.model.entity;

import com.fahmawy.cms.repository.Retrofit.ApiConstans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomePageData {
    @SerializedName("slider")
    @Expose
    private List<Slider> slider = null;
    @SerializedName("mostorderd")
    @Expose
    private List<Mostorderd> mostorderd = null;

    public List<Slider> getSlider() {
        return slider;
    }

    public void setSlider(List<Slider> slider) {
        this.slider = slider;
    }

    public List<Mostorderd> getMostorderd() {
        return mostorderd;
    }

    public void setMostorderd(List<Mostorderd> mostorderd) {
        this.mostorderd = mostorderd;
    }

    public class Mostorderd {

        @SerializedName("photo_url")
        @Expose
        private String photoUrl;
        @SerializedName("title")
        @Expose
        private String title;

        public String getPhotoUrl() {
            return ApiConstans.IMAGE_BASE_URL + photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

    public class Slider {

        @SerializedName("photo_url")
        @Expose
        private String photoUrl;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("page_url")
        @Expose
        private String pageUrl;

        public String getPhotoUrl() {
            return ApiConstans.IMAGE_BASE_URL + photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPageUrl() {
            return pageUrl;
        }

        public void setPageUrl(String pageUrl) {
            this.pageUrl = pageUrl;
        }

    }
}
