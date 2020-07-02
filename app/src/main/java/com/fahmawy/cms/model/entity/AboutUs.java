
package com.fahmawy.cms.model.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutUs {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("company_inf")
    @Expose
    private CompanyInf companyInf;
    @SerializedName("team")
    @Expose
    private List<Team> team = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CompanyInf getCompanyInf() {
        return companyInf;
    }

    public void setCompanyInf(CompanyInf companyInf) {
        this.companyInf = companyInf;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

}
