package com.tuliohdev.mvvmsample.data.model.presentationmodel;

import android.graphics.drawable.Drawable;

/**
 * Created by tulio on 26/01/18.
 */

public class CreditCardPM {

    private String id;
    private String number;
    private Drawable brandType;
    private String expirationDate;
    private String cvv;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Drawable getBrandType() {
        return brandType;
    }

    public void setBrandType(Drawable brandType) {
        this.brandType = brandType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
