package com.tuliohdev.mvvmsample.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import com.tuliohdev.mvvmsample.utils.typeconverters.BrandTypeConverter;
import com.tuliohdev.mvvmsample.utils.typeconverters.ListTransactionTypeConverter;
import java.util.List;

/**
 * Created by tulio on 20/01/2018.
 */
@Entity
public class CreditCard {

    public enum BrandType {
        MASTERCARD,
        VISA
    }

    @NonNull @PrimaryKey
    private String id;
    private String number;
    @TypeConverters({ BrandTypeConverter.class})
    private BrandType brandType;
    private String expirationDate;
    private String cvv;
    @TypeConverters({ ListTransactionTypeConverter.class})
    private List<Transaction> transactions;

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

    public BrandType getBrandType() {
        return brandType;
    }

    public void setBrandType(BrandType brandType) {
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
