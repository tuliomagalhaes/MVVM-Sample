package com.tuliohdev.mvvmsample.data.source.local.typeconverters;

import android.arch.persistence.room.TypeConverter;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.TransactionRM.PurchaseType;

/**
 * Created by tulio on 21/01/2018.
 */

public class PurchaseTypeConverter {

    @TypeConverter
    public static PurchaseType toPurchaseType(String value) {
        return PurchaseType.valueOf(value);
    }

    @TypeConverter
    public static String fromPurchaseType(PurchaseType value) {
        return value.toString();
    }

}
