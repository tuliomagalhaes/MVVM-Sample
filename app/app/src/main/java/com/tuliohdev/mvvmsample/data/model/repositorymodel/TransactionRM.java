package com.tuliohdev.mvvmsample.data.model.repositorymodel;

import android.arch.persistence.room.TypeConverters;
import com.tuliohdev.mvvmsample.utils.typeconverters.PurchaseTypeConverter;

/**
 * Created by tulio on 20/01/2018.
 */
public class TransactionRM {

    public enum OperationType {
        CREDIT,
        DEBIT
    }

    public enum PurchaseType {
        RESTAURANT,
        SERVICE,
        EDUCATION,
        TRANSPORT
    }

    private Double value;
    private String merchantName;
    @TypeConverters({ OperationType.class})
    private OperationType operationType;
    @TypeConverters({ PurchaseTypeConverter.class})
    private PurchaseType purchaseType;

    public Double getValue() {
        return value;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public PurchaseType getPurchaseType() {
        return purchaseType;
    }
}
