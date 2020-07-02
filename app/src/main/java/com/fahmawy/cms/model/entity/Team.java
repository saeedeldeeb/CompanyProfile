
package com.fahmawy.cms.model.entity;

import com.fahmawy.cms.repository.Retrofit.ApiConstans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("team_title")
    @Expose
    private String teamTitle;
    @SerializedName("team_members")
    @Expose
    private String teamMembers;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("team_photos")
    @Expose
    private String teamPhotos;
    @SerializedName("team_skilles")
    @Expose
    private String teamSkilles;
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

    public String getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTeamPhotos() {
        return ApiConstans.IMAGE_BASE_URL + teamPhotos;
    }

    public void setTeamPhotos(String teamPhotos) {
        this.teamPhotos = teamPhotos;
    }

    public String getTeamSkilles() {
        return teamSkilles;
    }

    public void setTeamSkilles(String teamSkilles) {
        this.teamSkilles = teamSkilles;
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
