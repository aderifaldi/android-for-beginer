package com.ar.androidforbeginer.app.model;

import java.io.Serializable;

/**
 * Created by aderifaldi on 09-Apr-16.
 */
public class MemberGeneralInfo implements Serializable{

    private String name;
    private String palce_born;
    private String birth_date;
    private String address;
    private String status;
    private String email;
    private String contact;
    private String facebook;
    private String twitter;
    private String photo;

    public String getName() {
        return name;
    }

    public String getPalce_born() {
        return palce_born;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPalce_born(String palce_born) {
        this.palce_born = palce_born;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
