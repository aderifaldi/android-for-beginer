package com.ar.androidforbeginer.app.model;

import java.io.Serializable;

/**
 * Created by aderifaldi on 09-Apr-16.
 */
public class Alert implements Serializable {

    private int alert_code;
    private String message;

    public int getAlert_code() {
        return alert_code;
    }

    public String getMessage() {
        return message;
    }
}
