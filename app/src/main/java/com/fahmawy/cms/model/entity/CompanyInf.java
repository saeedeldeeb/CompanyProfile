
package com.fahmawy.cms.model.entity;

import com.fahmawy.cms.repository.Retrofit.ApiConstans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyInf {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("company_type")
    @Expose
    private String companyType;
    @SerializedName("company_description")
    @Expose
    private String companyDescription;
    @SerializedName("company_owner")
    @Expose
    private String companyOwner;
    @SerializedName("company_photo")
    @Expose
    private String companyPhoto;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("company")
    @Expose
    private Integer company;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyOwner() {
        return companyOwner;
    }

    public void setCompanyOwner(String companyOwner) {
        this.companyOwner = companyOwner;
    }

    public String getCompanyPhoto() {
        return ApiConstans.IMAGE_BASE_URL + companyPhoto;
    }

    public void setCompanyPhoto(String companyPhoto) {
        this.companyPhoto = companyPhoto;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
