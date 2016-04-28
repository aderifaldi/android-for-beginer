package com.ar.androidforbeginer.app.model;

import java.io.Serializable;

/**
 * Created by aderifaldi on 09-Apr-16.
 */
public class MemberEducation implements Serializable {

    private String year;
    private String at;
    private String subject;

    public String getYear() {
        return year;
    }

    public String getAt() {
        return at;
    }

    public String getSubject() {
        return subject;
    }
}
