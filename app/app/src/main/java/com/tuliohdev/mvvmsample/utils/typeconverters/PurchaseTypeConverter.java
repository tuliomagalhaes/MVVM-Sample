package com.tuliohdev.mvvmsample.utils.typeconverters;

import android.arch.persistence.room.TypeConverter;
import com.tuliohdev.mvvmsample.data.model.Transaction.PurchaseType;

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