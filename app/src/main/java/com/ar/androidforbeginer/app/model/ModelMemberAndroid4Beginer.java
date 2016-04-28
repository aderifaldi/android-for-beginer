package com.ar.androidforbeginer.app.model;

import java.io.Serializable;

/**
 * Created by aderifaldi on 09-Apr-16.
 */
public class ModelMemberAndroid4Beginer implements Serializable {

    private Alert alert;
    private String logo;
    private String subject;
    private String venue;
    private String city;
    private Member[] member;

    public Alert getAlert() {
        return alert;
    }

    public String getLogo() {
        return logo;
    }

    public String getSubject() {
        return subject;
    }

    public String getVenue() {
        return venue;
    }

    public String getCity() {
        return city;
    }

    public Member[] getMember() {
        return member;
    }
}
